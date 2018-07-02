/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorclientexhr;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jano-
 */
public class appFrame extends JFrame {
    private JLabel jLabel1, jLabel2;
    private JButton jButton1;
    private JTextField jTextField1;
    private ButtonHandler buttonHandler1;
    private JComboBox jComboBox1;
    private JPanel jPanel1;
    
    private void initialize(){
        jLabel1 = new JLabel("Ingresa palabra a traducir");
        jLabel2 = new JLabel();
        jButton1 = new JButton("Traducir");
        jTextField1 = new JTextField();
        jComboBox1 = new JComboBox();
        buttonHandler1 = new ButtonHandler(jTextField1, jComboBox1, jLabel1, jLabel2);
    }
    
    private void add(){
        jPanel1 = new JPanel(new GridLayout(1, 6));
        
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);
        jPanel1.add(jComboBox1);
        jPanel1.add(jButton1);
        jPanel1.add(jLabel2);
        
        jComboBox1.addItem("Ingles");
        jComboBox1.addItem("Frances");
                
        add(jPanel1);
    }
    
    private void addEvents(){
        jButton1.addActionListener((ActionListener)buttonHandler1);
    }
    
    public appFrame(){
        super("Traductor cliente");
        initialize();
        add();
        addEvents();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
