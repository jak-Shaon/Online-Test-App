import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class FrontPage extends JFrame {
    private JLabel name;
    private JTextField namefield;
    private JLabel dept;
    private JTextField deptfield;
    private JLabel id;
    private JTextField idfield;
    private JLabel batch;
    private JTextField batchfield;
    private JButton register;
    private JButton result;

    public FrontPage() {
        //construct components
        name = new JLabel ("Name");
        namefield = new JTextField (5);
        dept = new JLabel ("Department");
        deptfield = new JTextField (5);
        id = new JLabel ("ID");
        idfield = new JTextField (5);
        batch = new JLabel ("Batch");
        batchfield = new JTextField (5);
        register = new JButton ("Register");
        result = new JButton("Result");
    
        register.addActionListener(new RegisterButtonListener());

        //adjust size and set layout
        setTitle("Front Page");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.green); 

        setVisible (true);
        setSize(450, 350);
        setLayout (null);

        //add components
        add (name);
        add (namefield);
        add (dept);
        add (deptfield);
        add (id);
        add (idfield);
        add (batch);
        add (batchfield);
        add (register);
        add(result);

        //set component bounds (only needed by Absolute Positioning)
        name.setBounds (15, 30, 170, 25);
        namefield.setBounds (185, 30, 190, 25);
        dept.setBounds (15, 70, 170, 25);
        deptfield.setBounds (185, 70, 190, 25);
        id.setBounds (15, 115, 170, 25);
        idfield.setBounds (185, 115, 190, 25);
        batch.setBounds (15, 160, 170, 25);
        batchfield.setBounds (185, 160, 190, 25);
        register.setBounds (145, 235, 100, 25);
        result.setBounds(145, 270, 100, 25);
    }
    public class RegisterButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String name = namefield.getText();
            String dept = deptfield.getText();
            String id = idfield.getText();
            String batch = batchfield.getText();

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("registration.txt", true));
                writer.append(name + "\n" + dept + "\n" + id + "\n" + batch);
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            
        register.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                OnlineTest frame2 = new OnlineTest("");
                frame2.setVisible(true);
            }

        });

            namefield.setText("");
            deptfield.setText("");
            idfield.setText("");
            batchfield.setText("");
        }
    }


    public static void main (String[] args) {
        new FrontPage();
    }
}