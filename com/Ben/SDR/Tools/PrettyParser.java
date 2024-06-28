package com.Ben.SDR.Tools;

import java.io.*;

public class PrettyParser{
    private static final int limit = 130;

    // обработка строк файла
    public static void parseData(String fName) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fName + ".pretty"))), true);

        String line;
        String outData;
        String equalSigns = "";

        while((line = in.readLine()) != null){
            String[] tokens = line.split(", ");

            if(tokens.length < 11){return;}

            if(Double.parseDouble(tokens[7]) > - 50 && Double.parseDouble(tokens[2]) / 1000000 < 500){
                outData = Double.parseDouble(tokens[2]) / 1000000 + ": ";

                for(int i = 0; i < Double.parseDouble(tokens[10]) + Double.parseDouble(tokens[10]); i++){
                    equalSigns += "=";
                }

                if(!equalSigns.isEmpty() && equalSigns.length() < limit) out.println(outData + equalSigns + ">");
                else if(!equalSigns.isEmpty()) out.println(outData + "=== +" + (equalSigns.length() - 3) + "(=)" + ">" + " (Probably garbage).");
            }
        }
    }
}