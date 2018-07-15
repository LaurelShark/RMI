package main.java.socketTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.OutputStreamWriter;

public class SocketClient {


    public static void main(String[] args) throws Exception {

        /* if (args.length != 2) {
            System.out.println("Usage: start java sokclient host port");
            System.exit(0);
        }
        */


        Socket clsock = new Socket("localhost" , 8800);
        System.out.println("Connection established");
        BufferedReader inStream = new BufferedReader(new InputStreamReader(clsock.getInputStream()));
        PrintWriter outStream = new PrintWriter(new OutputStreamWriter(clsock.getOutputStream()), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        while (!exit) {
            System.out.print(">");
            String command = br.readLine();
            outStream.println(command);
            if (command.trim().toUpperCase().equals("BYE")) {
                exit = true;
                inStream.close();
                outStream.close();
                clsock.close();
            } else {

                String reply = inStream.readLine();
                System.out.println(reply);
            }
        }

    }
}
