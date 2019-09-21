/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Analizadores.LexicoHTML;
import Analizadores.LexicoUFE;
import Analizadores.SintacticoHTML;
import Analizadores.SintacticoUFE;
import Datos.Panel;
import Entorno.Entorno;
import IntruccionHTML.InstruccionHtml;
import IntruccionHTML.Noufe;
import Sentecia.Declaracion;
import Sentecia.Sentencia;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        salidaConsola = new java.awt.TextArea();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(salidaConsola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salidaConsola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    static String nuevo;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        LinkedList<InstruccionHtml> resultados;
        String datos = textArea1.getText();
        LexicoHTML lexico = new LexicoHTML(new BufferedReader(new StringReader(datos)));
        SintacticoHTML sintactico = new SintacticoHTML(lexico);
          try{
            sintactico.parse();
           
        }catch(Exception e){
            System.out.println(e);
        }
        resultados=sintactico.resultados;
        nuevo=sintactico.nuevo;
        for(InstruccionHtml ins:resultados){
            ins.Ejecutar();
        }
        
        System.out.println("Analisis Comleto HTML");
        AnalizarAppUfe();
        //analizarEntrada(datos);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void AnalizarAppUfe(){
        String aux="";
        String texto="";
         File abre= new File(String.valueOf("App.ufe"));
         FileReader archivos = null;
        try {
                archivos = new FileReader(abre);
        } catch (FileNotFoundException e3) {
                e3.printStackTrace();
        }
        BufferedReader lee=new BufferedReader(archivos);
         try {
                while((aux=lee.readLine())!=null)
                  {
                     texto+= aux+ "\n";
                  }
        } catch (IOException e2) {
                e2.printStackTrace();
        }
         try {
                        lee.close();
                } catch (IOException e1) {
                        e1.printStackTrace();
                }
         analizarEntrada(texto);
    }
    public void analizarEntrada(String datos){
        
        LexicoUFE lexico = new LexicoUFE(new BufferedReader(new StringReader(datos)));
        SintacticoUFE sintactico = new SintacticoUFE(lexico);
        //sintactico.salidaConsola = salidaConsola;
        
        try{
            sintactico.parse();
            recorrerArbol(sintactico);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static Entorno ent = new Entorno(null);
    public static LinkedList<Sentencia> listaInstrucciones=null;
     public void recorrerArbol(SintacticoUFE sintactico){
         JFrame principal = new JFrame(nuevo);
        principal.setSize(200, 150);
        jPanel1.removeAll();
        jPanel1.setLayout(null);
        principal.setLayout(null);
        Declaracion decl;
        listaInstrucciones = sintactico.resultado;
        LinkedList<Sentencia> listaInstrucciones = sintactico.resultado;
        for (Sentencia i : listaInstrucciones) {
            if(i!=null)
                i.ejecutar(ent);
        }
        jPanel1.repaint();
        principal.setContentPane(jPanel1);
        jPanel1.setVisible(true);
        principal.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JPanel jPanel1;
    public static java.awt.TextArea salidaConsola;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
