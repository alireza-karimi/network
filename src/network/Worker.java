package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Worker extends Thread {

    Socket channel = null ; 
    DataInputStream in;
    DataOutputStream out;
    
    public Worker(Socket s){
        channel = s ; 
        start();
    }
    
    
    public void run(){
        
        String result = "";
        
        try {
            in = new DataInputStream( new BufferedInputStream( channel.getInputStream() ) );
            out = new DataOutputStream(channel.getOutputStream());
            
            while(true){

                int a = in.available() ;
                String message = "";
                
                if(a > 0){
                	
                	message = in.readUTF();
                	
                    System.out.println("The message sent from the socket was: " + message);
                    
                    if(message.equals("over")){
                    	channel.close();
                    	break;
                    }
                    
                    if(!result.equals("")){
                    	result = result.concat("\n"); 
                    }
                    result = result.concat(message);
                    out.writeUTF(result);
                    
                }
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }   
    
}
