package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;


public class Servidor {

    

    public static void main(String[] args) {
      
        ArrayList<PrintStream> clientes = new ArrayList<>();
  
        try {
        ServerSocket server = new ServerSocket(5000);
        Socket socket;
           
        
     while(true){
             
             socket = server.accept();
         
        clientes.add(new PrintStream(socket.getOutputStream()));
        Menssagem menssagem = new Menssagem(socket,clientes);
        
        
        
             
     
     }
        
        }
        catch(IOException e){
            
            e.printStackTrace();
        }
    }
}