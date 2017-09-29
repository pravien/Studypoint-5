/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise6;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class TcpServer
{
    public TcpServer( String ip, int port )
    {
        ServerSocket serverSocket = null;

        try
        {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip, port));

            System.out.println( "Server log: Server created..." );
            System.out.println( "Server log: Listening for clients on port " + port + "..." );
            
            try
            {
                System.out.println( "Server log: Waiting for connections..." );
                
                while (true)
                {    
                    new TcpServerClientThread( serverSocket.accept() );
                }
            }
            catch (Exception e)
            {
                System.err.println( "Server log: Accepting connection failed..." );
            }
        }
        catch (Exception e)
        {
            System.out.println( "Server log: Could not listen on port: " + port + "..." );
        }
    }    
}
