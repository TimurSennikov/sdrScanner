package com.Ben.SDR.Client;

import java.io.*;
import java.net.ConnectException;

import com.Ben.SDR.Client.SocketConnection;

public class MainParser{
    public static void main(String[] args){
        try{
            if(args.length == 0){System.exit(1);}

            SocketConnection connection = new SocketConnection();

                if (args[0].equals("--send")){
                    connection.connect(args[2], Integer.parseInt(args[3]));
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
                        String line;

                        while ((line = in.readLine()) != null) {
                            connection.sendLine(line);
                        }
                }
                else if (args[0].equals("--receive")) {connection.connect(args[1], Integer.parseInt(args[2])); System.out.println(connection.receivePretty());}

                connection.disconnect();
        }
        catch(IOException e){
            System.err.println("An IO exception has occured. If the specified IP and port are correct and there s a server running on them, there might be an issue in the code.");
            e.printStackTrace();
        }
    }
}