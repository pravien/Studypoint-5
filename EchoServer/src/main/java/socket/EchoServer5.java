/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pravien
 */
public class EchoServer5
{
   public static void main(String[] args) throws IOException
    {
        Map<String,String> map = new HashMap();
        map.put("hund", "dog");
        map.put("kat", "cat");
        map.put("abe", "monky");
        map.put("bird", "fugel");
        ServerSocket serverSocket = null;

        try
        {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e)
        {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection.....");

        try
        {
            clientSocket = serverSocket.accept();
        } catch (IOException e)
        {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        System.out.println("Connection successful");
        System.out.println("Waiting for input.....");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()).contains("#"))
        {
            String input = inputLine;
            String[] split = input.split("#");
            String keyword = split[0].toUpperCase();
            String message = split[1];
            System.out.println("keyword: "+keyword);
            System.out.println("message: "+message);
            if(keyword.equals("UPPER")){
             message = message.toUpperCase();
             //System.out.println("Server: "+message);
             //out.println(message);
             answer(message,out);
            }
            else if(keyword.equals("LOWER")){
              message = message.toLowerCase();
              //System.out.println("Server: "+message);
              //out.println(message); 
              answer(message,out);
            }
            else if(keyword.equals("REVERSE")){
              message = message = new StringBuilder(message).reverse().toString();
              answer(message,out);
            }
            else if(keyword.equals("TRANSLATE")){
               if(map.containsKey(message)){ 
               answer(map.get(message),out);
               }
               else{
                   out.println("BYE");
                   break;
               }
            }
           // System.out.println("first elemt"+split[0]);     
            
            if(inputLine.equals("Bye."))
            {
             System.out.println("Server: " + message);
             out.println("BYE");   
                break;
            }
            
            
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
   
   public static void answer(String answer,PrintWriter out){
       System.out.println("Server: "+answer);
       out.println(answer);
   }
 
}
