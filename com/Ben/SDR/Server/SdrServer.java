package com.Ben.SDR.Server;

import com.Ben.SDR.Tools.PrettyParser;
import com.Ben.SDR.Tools.ReadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SdrServer{
    private ServerSocket socket;
    private PrintWriter out;

    public SdrServer(int port) throws IOException{
        this.socket = new ServerSocket(port);
        this.out = new PrintWriter(new FileOutputStream(new File("sdr_data.csv")), true);
    }

    public void listen(){
        while(true){
            try {
                Socket incoming = this.socket.accept();

                AnswerThread thread = new AnswerThread(incoming);
                thread.start();
            }
            catch(IOException e){}
        }
    }

    private class AnswerThread extends Thread{
        private Socket incoming;
        private BufferedReader in;
        private PrintWriter out;
        private PrintWriter fileOut;

        public AnswerThread(Socket i) throws IOException{
            this.incoming = i;

            in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            out = new PrintWriter(this.incoming.getOutputStream(), true);

            fileOut = new PrintWriter(new FileOutputStream(new File("sdr_data.csv")), true);
        }

        public void run(){
            while(true){
                String line;
                try {
                    out.println("HELLO");
                    while (!(line = in.readLine()).isEmpty()){
                        if(line.contains("/getPretty")){out.println(ReadFile.readFile("sdr_data.csv.pretty"));}
                        else {
                            fileOut.println(line);
                            PrettyParser.parseData("sdr_data.csv");
                        }
                    }

                    socket.close();
                    stop();
                }
                catch(IOException e){}
            }
        }
    }
}