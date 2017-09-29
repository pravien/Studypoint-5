package Socket;

import Socket.Turnstile;
import Socket.TurnstileCounter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TcpServerClientThread extends Thread
{

    private Socket clientSocket;
    private Turnstile t;
    TurnstileCounter c;
    List<Turnstile> turnstiles;

    public TcpServerClientThread(Socket s, TurnstileCounter c,List<Turnstile>turnstiles,Turnstile t)
    {
        this.turnstiles = turnstiles;
        this.c = c ;
        this.clientSocket = s;
        this.t=t;
        turnstiles.add(this.t);
        Thread thread = new Thread (t);
        thread.start();
        start();
    }

    public void run()
    {
        
        System.out.println("Server log: Client connected...");

        try
        {
            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            toClient.println("WELCOME...");
            String clientInput;
            outerloop:
            while ((clientInput = fromClient.readLine()) !=null)
            {
                
                System.out.println("client: "+clientInput);
                if(clientInput.equals("spectators")){
                    System.out.println("server: "+ c.getValue());
                   toClient.println(c.getValue());
                }
                else if(clientInput.equals("countturntile")){
                  System.out.println("server: "+turnstiles.toString());
                  toClient.println(turnstiles.toString());  
                }
                else if(clientInput.equals("bye")){
                    System.out.println("server: "+ "BYE");
                    toClient.println("BYE");
                   break; 
                }
                else{
                    toClient.println("dosen't know command");
                }

            }
            System.out.println("ude af while");
            //System.exit(0);
            toClient.close();
            fromClient.close();
            clientSocket.close();
        } catch (Exception e)
        {
            System.out.println("Server log: Problem with Communication Server...");
        }
    }
}

