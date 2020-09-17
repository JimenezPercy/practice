package com.joker.network.socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @Author: wzp
 * @Date: 2020/9/17 7:58
 */
public class ServerTest {
    public static void main(String[] args) throws Exception {
        //1.服务端建立服务
        ServerSocket server = new ServerSocket(9999);//请求端口
        while (true) {
            //2.创建监听
            Socket socket = server.accept();
            //获取输入流
            InputStream input = socket.getInputStream();

            ObjectInputStream in = new ObjectInputStream(input);
            Object obj = in.readObject();
            System.out.println(obj);

//            Thread.sleep(1000);
//            byte[] bytes = new byte[input.available()];
//            input.read(bytes);
//            input.close();

//            System.out.println(new String(bytes));
//            System.out.println(bytes.length);

            //获取输出流
            OutputStream output = socket.getOutputStream();
//            output.write("Hello client!!!".getBytes());
//            output.flush();
            Response res=new Response();
            res.setId(2);
            res.setName("回应");
            ObjectOutputStream out=new ObjectOutputStream(output);
            out.writeObject(res);
            out.flush();

//            input.close();
//            in.close();
//            out.close();
//            output.close();
//            socket.close();
//            server.close();
        }

    }
}
