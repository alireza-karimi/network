package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public Server(){
        init();
    }
    
    ServerSocket server = null ;
    InputStream in = null ; 
    OutputStream out = null ; 
    
    public void init(){
        try {
            server = new ServerSocket(777);
            Socket channel = server.accept();
            Worker w = new Worker(channel);
            
        }catch(IOException e){
            e.printStackTrace();
        }
            
    }
    
}
