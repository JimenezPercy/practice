package com.joker.network.rpc.rpc.server.impl;

import com.joker.network.rpc.rpc.server.base.ServiceInformation;
import com.joker.network.rpc.rpc.server.NetServer;
import com.joker.network.rpc.service.UserService;
import com.joker.network.rpc.service.impl.UserServiceImpl;
import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * RPC的核心通讯功能
 *
 * @author wangzhipeng01
 * @date 2020-09-19 10:22
 */
@Data
public class NetServerImpl implements NetServer {
    private String url;//主机IP
    private int port;//端口
    private Socket clientSocket;//客户端socket
    private Socket serverSocket;//服务端socket
    private ServerSocket server;

    public NetServerImpl() {
    }

    public NetServerImpl(String url, int port) {
        this.url = url;
        this.port = port;
    }

    //容器及其初始化
    private static Map<String, Class<?>> beans = new HashMap<String, Class<?>>();

    static {
        beans.put(UserService.class.getName(), UserServiceImpl.class);
    }

    public void recv(int port) {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            //正常启动服务
            this.server = new ServerSocket(port);
            while (true) {
                //获取远程监听
                this.serverSocket = this.server.accept();
                //接收ServiceInformation
                in = new ObjectInputStream(this.serverSocket.getInputStream());

                String className = in.readUTF();//类名
                String methodName = in.readUTF();//方法名
                Class<?>[] argTypes = (Class<?>[]) in.readObject();//参数类型
                Object[] args = (Object[]) in.readObject();//参数

                Class clazz = null;
                //要到实例容器中匹配服务
                //原则上，应该有一个容器，如map，其中包含了所有待引用的接口实现
                //可以根据接口名获取对应的实现类
                for (String cName : beans.keySet()) {
                    //模拟从容器当中拿出来的
                    if (className.equals(cName)) {
                        clazz = beans.get(cName);
                    }
                }
                //获取要执行的方法
                Method method = clazz.getMethod(methodName, argTypes);
                //执行对应方法
                Object returnObj = method.invoke(clazz.newInstance(), args);
                //把得到的返回值写出去
                out = new ObjectOutputStream(this.serverSocket.getOutputStream());
                out.writeObject(returnObj);
                out.flush();
                //服务关闭
                this.serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Object send(ServiceInformation serviceInformation) {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            //获取客户端socket
            this.clientSocket = new Socket(serviceInformation.getServiceUrl(), serviceInformation.getPort());
            //类名
            String className = serviceInformation.getClassName();
            //方法名
            String methodName = serviceInformation.getMethod().getName();
            //参数类型
            Class<?>[] argTypes = serviceInformation.getMethod().getParameterTypes();
            //参数
            Object[] args = serviceInformation.getArgs();

            //输出流
            out=new ObjectOutputStream(this.clientSocket.getOutputStream());

            //读写顺序需保持一致
            out.writeUTF(className);//类名
            out.writeUTF(methodName);//方法名
            out.writeObject(argTypes);//参数类型
            out.writeObject(args);//参数

            //输入流
            in=new ObjectInputStream(this.clientSocket.getInputStream());
            Object returnObj=in.readObject();

            return returnObj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if( this.clientSocket!=null){
                    this.clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
