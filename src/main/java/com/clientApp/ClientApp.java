package com.clientApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8051);){
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String userInput;
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            System.out.println("Voting Client app");
            do {
                    userInput = scanner.nextLine();
                    output.println(userInput);

            } while (!userInput.equals("exit"));

        } catch (IOException e) {

        }

    }
}
