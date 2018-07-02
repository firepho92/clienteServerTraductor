/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorclientexhr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jano-
 */
class ButtonHandler implements ActionListener{
    private JTextField jTextField1;
    private JComboBox jComboBox1;
    private JLabel jLabel1, jLabel2;
    
    public ButtonHandler(JTextField jTextField1, JComboBox jComboBox1, JLabel jLabel1, JLabel jLabel2){
        this.jTextField1 = jTextField1;
        this.jComboBox1 = jComboBox1;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lang, word;
        word = jTextField1.getText();
        lang = (String)jComboBox1.getSelectedItem();
        try {
            URL url = new URL("http://localhost:8000/?word=" + word + "&lang=" + lang);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            jLabel2.setText(in.readLine());
        } catch (IOException ex) {
            jLabel2.setText("Oops intente de nuevo más tarde");
        }
        
    }
    
}
