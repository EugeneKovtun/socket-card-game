package ua.kpi.tef.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static ua.kpi.tef.utils.CommonUtils.inputIntegerWithScanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        InputStreamReader reader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
        System.out.println("m");

        System.out.println(bufferedReader.readLine());
        System.out.println("m");

//        OutputStream os = socket.getOutputStream();
//        OutputStreamWriter osw = new OutputStreamWriter(os);
//        BufferedWriter bw = new BufferedWriter(osw);

        String number = String.valueOf(inputIntegerWithScanner(new Scanner(System.in)));

        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
        writer.println(number);
//        bw.write(number);
//        bw.flush();
        System.out.println(bufferedReader.readLine());
    }
}
