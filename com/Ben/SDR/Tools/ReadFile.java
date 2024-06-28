package com.Ben.SDR.Tools;

import java.io.*;

public class ReadFile{
    public static String readFile(String path) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line;
        String text = "";

        while((line = in.readLine()) != null){
            text += line + "\n";
        }

        in.close();
        return text;
    }
}