package grafica;
import javax.swing.*;

import gestione_account.RecuperaCredenzialiControl;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
public class ModuloForgot extends JFrame implements ActionListener {

	
    JButton indietrorecupero,inviorecupero;
    JPanel menu_forgot;
    JLabel MailLabel, emailinviatatxt,Gif;
    JLabel erroremail,erroremailvuoto,confermamail;
    private String emailValue;
    String userValue;
    final JTextField  MailText;
    public static final Color VERY_LIGHT_RED = new Color(255,102,102);
	ModuloForgot(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon gif = new ImageIcon("mail.gif");
        Gif = new JLabel();
        Gif.setText("");
        Gif.setBounds(490,80, 220,100);
        Gif.setIcon(gif);
        Gif.setVisible(false);
		
        MailLabel = new JLabel();
        MailLabel.setText("La tua mail:");      //set label value for textField1
        MailLabel.setBounds(450,160, 200,30);

        indietrorecupero = new JButton("Indietro"); //set label to button
        indietrorecupero.setBounds(500,290, 200,30);

        inviorecupero = new JButton("Invia");
        inviorecupero.setBounds(500, 210, 200, 60);

		
        MailText = new JTextField(15);    //set length of the text
        MailText.setBounds(550,160, 200,30);
        
        emailinviatatxt = new JLabel();
        emailinviatatxt.setVisible(false);
        emailinviatatxt.setText("Credenziali Inviate Tramite Email");
        emailinviatatxt.setForeground(Color.GREEN.darker());
        emailinviatatxt.setBounds(508,180, 184,30);
		
        menu_forgot = new JPanel();
        menu_forgot.setLayout(null);
        menu_forgot.setSize(1200,600);
        menu_forgot.setBackground(Color.white);
        menu_forgot.add(inviorecupero);
        menu_forgot.add(indietrorecupero);
        menu_forgot.add(MailText);
        menu_forgot.add(MailLabel);
        menu_forgot.add(emailinviatatxt);
        menu_forgot.add(Gif);
        add(menu_forgot);
        
        indietrorecupero.addActionListener(this::indietro);
        inviorecupero.addActionListener(this);
        
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	        emailValue = MailText.getText();        //get user entered pasword from the textField2
	        //check whether the credentials are authentic or not
            RecuperaCredenzialiControl recuperaCtl = new RecuperaCredenzialiControl();
	        if (recuperaCtl.verificaEmail(emailValue)) {  //QUI VA MESSO IL CHECK DEL DMBS PER VEDERE SE LA MAIL ESISTE
	        	emailinviatatxt.setVisible(true);
	            MailText.setVisible(false);
	            MailLabel.setVisible(false);
	            indietrorecupero.setBounds(500, 210, 200, 60);
	            inviorecupero.setVisible(false);
	            Gif.setVisible(true);
	            recuperaCtl.sendEmail();
	        }
	        else{
	            //show error message
	            System.out.println("Email non trovata!");
              ModuloErroreMail errore = new ModuloErroreMail();
	            errore.setSize(300, 150);  //set size of the frame
	            errore.setVisible(true);  //make form visible to the user

	            
	            
	        
	            
	            
	        }


	    }
	public void indietro(ActionEvent e)
	{
		ModuloLogin login = new ModuloLogin();
		login.setSize(1200,600);
		login.setVisible(true);
		dispose();
	}

}
