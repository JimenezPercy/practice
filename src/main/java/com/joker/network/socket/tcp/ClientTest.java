package com.joker.network.socket.tcp;

import com.joker.network.socket.Request;
import com.joker.network.socket.Response;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: wzp
 * @Date: 2020/9/17 7:59
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        while (true){

            Socket client = new Socket("127.0.0.1", 9999);

            //获取输出流
            OutputStream output = client.getOutputStream();
//        output.write("Hello server!!!".getBytes());
//        output.flush();
//        output.close();

            //创建请求对象
            Request req=new Request();
            req.setId(1);
            req.setName("客户端");
            System.out.println("客户端：");
            req.setMessage(sc.next());

            //对象输出流
            ObjectOutputStream out=new ObjectOutputStream(output);
            out.writeObject(req);
            out.flush();

            //输入流
            InputStream input=client.getInputStream();
//        Thread.sleep(2000);
//        byte[] bytes=new byte[input.available()];
//        input.read(bytes);
//        System.out.println(new String(bytes));

            //对象输入流
            ObjectInputStream in=new ObjectInputStream(input);
            Object obj=in.readObject();

            if(obj instanceof Response){
                Response res=(Response)obj;
                System.out.println(res.getId()+" "+res.getName()+":"+res.getMessage());
            }


            output.close();
            input.close();
            out.close();
            input.close();
            client.close();
        }
    }
}
