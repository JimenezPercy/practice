package com.joker.network.socket.tcp;

import com.joker.network.socket.Request;
import com.joker.network.socket.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
            new Thread(new SocketThread(socket)).start();
        }

    }
}

class SocketThread implements Runnable {

    private final Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Scanner scanner=new Scanner(System.in);
        try {
            InputStream input = socket.getInputStream();
            in = new ObjectInputStream(input);
            Object obj = in.readObject();

            if (obj instanceof Request) {
                Request req=(Request)obj;
                System.out.println(req.getId()+" "+req.getName()+":"+req.getMessage());
            }

            //获取输出流
            OutputStream output = socket.getOutputStream();

            Response res = new Response();
            res.setId(1);
            res.setName("服务器");
            System.out.println("服务器：");
            res.setMessage(scanner.next());

            out = new ObjectOutputStream(output);
            out.writeObject(res);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
