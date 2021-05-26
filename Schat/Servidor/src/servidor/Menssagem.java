package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class Menssagem {

    @SuppressWarnings("FieldMayBeFinal")
    private Socket s;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<PrintStream> clientes;


   
    public Menssagem(Socket s, ArrayList<PrintStream> clientes) {
    
    this.s = s;
    this.clientes = clientes;
    Thread();
    
    
    }

private void Thread(){

@SuppressWarnings("Convert2Lambda")
Thread t = new Thread(new Runnable(){
@Override
public void run(){
String menssagem = "";
    
    try{
    InputStreamReader isr = new InputStreamReader(s.getInputStream());
    BufferedReader br = new BufferedReader(isr);
    
    while((menssagem = br.readLine()) != null){
    
        enviarMenssagem(menssagem);
        
    
    }
    
    }
catch(IOException e){

e.printStackTrace();


}


}

});

t.start();

    

}

private void enviarMenssagem(String menssagem){

    for(int a = 0; a < clientes.size(); a++){
    clientes.get(a).println(menssagem);
    clientes.get(a).flush();
    }


}


}