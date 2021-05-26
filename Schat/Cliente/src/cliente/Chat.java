package cliente;

import com.sun.glass.events.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import static javax.swing.JOptionPane.*;

public class Chat extends javax.swing.JFrame {

    private String nome;
    private Socket S;
    private BufferedReader br;
    private InputStreamReader isr;
    
    
    //Construtor   
    public Chat(String nome) {
        
        this.nome = nome;
        try {
        S = new Socket("192.168.93.140",5000);
        
        }
        catch (IOException e){
            showMessageDialog(null, "Não se conectou ao servidor","", ERROR_MESSAGE);
            System.exit(0);
        }
        Thread();
        initComponents();
    }

private void Thread(){

        Thread t = new Thread(new Runnable() {
            String menssagem;
            @Override
            public void run() {
                try{
             isr = new InputStreamReader(S.getInputStream());
             br = new BufferedReader(isr);
             
                    while((menssagem = br.readLine())  != null){
                        
                        mensagemRecebida1.setText(mensagemRecebida1.getText() + menssagem + "\n");
                    
                    
                    }
             
             
                }
                catch (IOException e){
                        showMessageDialog(null, "Erro na conexão com o servidor", "", ERROR_MESSAGE);
                }
            }
    
        });
        
        t.start();

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mensagemRecebida1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensagemEnviada1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Schating 1.0.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(240, 240));
        setResizable(false);

        mensagemRecebida1.setColumns(20);
        mensagemRecebida1.setRows(5);
        jScrollPane1.setViewportView(mensagemRecebida1);

        mensagemEnviada1.setColumns(20);
        mensagemEnviada1.setRows(5);
        mensagemEnviada1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mensagemEnviada1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(mensagemEnviada1);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Created BY                        @Danilo Luiz da Silva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String mensagem = nome + "Disse: ";
        
        try{
        
        PrintStream ps = new PrintStream(S.getOutputStream());
        mensagem += mensagemEnviada1.getText();
        
        ps.println(mensagem);
        ps.flush();
        mensagemEnviada1.setText("");
        }
        catch(IOException e){
         showMessageDialog(null, "Não conseguiu enviar a menssagem","", ERROR_MESSAGE);   
        
        
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mensagemEnviada1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemEnviada1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
         String mensagem = nome + "Disse: ";
        
        try{
        
        PrintStream ps = new PrintStream(S.getOutputStream());
        mensagem += mensagemEnviada1.getText();
        
        ps.println(mensagem);
        ps.flush();
        mensagemEnviada1.setText("");
        }
        catch(IOException e){
         showMessageDialog(null, "Não conseguiu enviar a menssagem","", ERROR_MESSAGE);   
        
        
}
        
        }
        
        
    }//GEN-LAST:event_mensagemEnviada1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea mensagemEnviada1;
    private javax.swing.JTextArea mensagemRecebida1;
    // End of variables declaration//GEN-END:variables
}
