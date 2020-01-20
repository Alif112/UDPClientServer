/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author REVE
 */
public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        System.err.println("UDP Server Started Successfully");
        try{
            DatagramSocket ds=new DatagramSocket(1111);
            byte[] b=new byte[2048];
            
            DatagramPacket dp=new DatagramPacket(b, b.length);
            DatagramPacket dp2 = new DatagramPacket(b, b.length);
            
            while(true){
                ds.receive(dp);
                String message=new String(dp.getData(),0,dp.getLength());
                System.out.println(message);

                //Backend coding
                message=message.toUpperCase();


                //Send data back to client
                byte[] b1=message.getBytes();
                dp2.setData(b1);
                dp2.setAddress(dp.getAddress());
                dp2.setPort(dp.getPort());
                ds.send(dp2);
                
                System.err.println("------sending from server: "+message);
            
            }
            
            
            
        }catch(Exception e){
            
            
            e.printStackTrace();
        }
        
        
        
        
        
    }
    
}
