package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    DataInputStream in = null ; 
    DataOutputStream out = null ; 
    Scanner scanner = new Scanner(System.in);
	
    public Client(){
    	
        try {
            Socket s = new Socket("0.0.0.0" , 777 );
            in = new DataInputStream(new BufferedInputStream(s.getInputStream())) ; 
            out = new DataOutputStream(s.getOutputStream()) ; 
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        start();
    }
    
    public void run(){
    	
        while(true){
        	
            try {
                
                String outputStr = scanner.nextLine();
                
                out.writeUTF(outputStr);
                
                int a = in.available();
                
                if(a > 0){
                	String message = in.readUTF();
                	System.out.println(message);
                }
                
            } catch (IOException ex) {
            	ex.printStackTrace();
            }
              
        }
    }
    
}
