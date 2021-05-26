
package cliente;
import static javax.swing.JOptionPane.*;
public class Cliente {

 
    public static void main(String[] args) {
        
        String nome = showInputDialog(null,"Digite seu nome: ","",PLAIN_MESSAGE);
        
        
        
      Chat chat = new Chat(nome);
      chat.setVisible(true);
      
    }
    
}
