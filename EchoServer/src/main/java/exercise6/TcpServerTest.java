/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise6;

public class TcpServerTest
{
    public static void main(String[] args) throws Exception
    {
        new TcpServer("0.0.0.0", 9842);
        //new TcpServer("127.0.0.1", 9876);
    }
}
