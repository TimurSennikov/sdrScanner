package com.Ben.SDR.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            SdrServer server = new SdrServer(Integer.parseInt(args[0]));
            server.listen();
        }
        catch(IndexOutOfBoundsException e){
            System.err.println("Please specify server port as args[0]");
            System.exit(1);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}