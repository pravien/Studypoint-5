/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import static socket.EchoServer5.answer;

public class TcpServerClientThread extends Thread
{

    private Socket clientSocket;

    public TcpServerClientThread(Socket s)
    {
        clientSocket = s;
        start();
    }

    public void run()
    {
        System.out.println("Server log: Client connected...");

        try
        {
            Map<String, String> map = new HashMap();
            map.put("hund", "dog");
            map.put("kat", "cat");
            map.put("abe", "monky");
            map.put("bird", "fugel");
            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            toClient.println("WELCOME...");

            String clientInput;
            outerloop:
            while ((clientInput = fromClient.readLine()).contains("#"))
            {
                String input = clientInput;
                String[] split = input.split("#");
                String keyword = split[0].toUpperCase();
                String message = split[1];
                System.out.println("keyword: " + keyword);
                System.out.println("message: " + message);
                if (keyword.equals("UPPER"))
                {
                    message = message.toUpperCase();
                    //System.out.println("Server: "+message);
                    //out.println(message);
                    answer(message, toClient);
                } else if (keyword.equals("LOWER"))
                {
                    message = message.toLowerCase();
                    //System.out.println("Server: "+message);
                    //out.println(message); 
                    answer(message, toClient);
                } else if (keyword.equals("REVERSE"))
                {
                    message = message = new StringBuilder(message).reverse().toString();
                    answer(message, toClient);
                } else if (keyword.equals("TRANSLATE"))
                {
                    if (map.containsKey(message))
                    {
                        answer(map.get(message), toClient);
                    } else
                    {
                        toClient.println("BYE");
                        break;
                    }
                } // System.out.println("first elemt"+split[0]);     
                else if (message.equals("Bye."))
                {
                    System.out.println("Server: " + message);
                    toClient.println("BYE");
                    System.out.println("done");
                    break;
                } else
                {
                    toClient.println("unknown request");
                }

            }
            System.out.println("ude af while");
            System.exit(0);
            toClient.close();
            fromClient.close();
            clientSocket.close();
        } catch (Exception e)
        {
            System.out.println("Server log: Problem with Communication Server...");
        }
    }
}
