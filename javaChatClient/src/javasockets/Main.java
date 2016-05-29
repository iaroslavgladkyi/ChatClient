/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaffs
 */
public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 5782;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (Socket client = new Socket()) {
            System.out.println("CONNECTING...");
            client.setSoTimeout(1000);

            InetSocketAddress serverAddress = new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT);
            client.connect(serverAddress);
        //    DataOutputStream server_dos = new DataOutputStream(client.getOutputStream());
         //       DataInputStream server_dis = new DataInputStream(client.getInputStream());
               
           // boolean work = true;
            if (client.isConnected() == true) {
           
                System.out.println("CONNECTION ESTABLISHED");
                System.out.println("Let's try to chating");
                System.out.println("Please, enter your message, you can send - PING, MSG, OK, other");}
                DataOutputStream server_dos = new DataOutputStream(client.getOutputStream());
                DataInputStream server_dis = new DataInputStream(client.getInputStream());
               try (Scanner scanner = new Scanner(System.in)) {
                
                //DataOutputStream server_dos = new DataOutputStream(client.getOutputStream());
               // DataInputStream server_dis = new DataInputStream(client.getInputStream());
                boolean work = true;
               while (work) {

                    //DataOutputStream server_dos = new DataOutputStream(client.getOutputStream());
                    //DataInputStream server_dis = new DataInputStream(client.getInputStream());
                    String input = scanner.nextLine();
                    server_dos.writeUTF(input);
                    server_dos.flush();
                    
                    if (input.equals("0") || input.equals("e")) {
                        work = false;
                    }
                    String server_response = server_dis.readUTF();
                    System.out.println(server_response);
               }
                

                //}
           // }

            //OutputStream outputStream = client.getOutputStream();
            //DataOutputStream dos = new DataOutputStream(outputStream);
            //DataInputStream dis = new DataInputStream(client.getInputStream());
            //dos.writeUTF("PING");
            //dos.flush();

            //String response = dis.readUTF();

            //System.out.println("RESPONSE" + response);

        } 

        System.out.println("DISCONNECTED");

    }   catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
