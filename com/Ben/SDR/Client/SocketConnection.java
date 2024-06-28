package com.Ben.SDR.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnection{
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;

    public void connect(String host, int port) throws IOException{
        this.socket = new Socket(host, port);

        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendLine(String line) throws IOException{
        if(out != null && line != null){
            out.println(line);
        }
    }

    public String receivePretty() throws IOException{
        String text = "";

        if(out != null && in != null){
            out.println("/getPretty");

            String line;
            while(!(line = in.readLine()).isEmpty()){
                text += line + "\n";
            }
        }

        return text;
    }

    public void disconnect() throws IOException{
        out.println("END");

        in.close();
        out.close();

        socket.close();
    }
}