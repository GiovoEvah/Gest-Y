package grafica;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import Entita.Utente;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.Exception;

public class ModuloAccount extends JFrame implements ActionListener{
   
	JButton cambiaiban,indietroaccount, modificaPass, modificatelefono,modificaemail;
    JPanel menu_account;
    private Utente utente;
	
	ModuloAccount(Utente utente){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.utente = new Utente();
		this.utente = utente;
		 cambiaiban = new JButton("Modifica Iban"); //set label to button
	        cambiaiban.setBounds(390,220, 200,100);
	        
	        modificatelefono = new JButton("Modifica Telefono"); //set label to button
	        modificatelefono.setBounds(610,220, 200,100);
	        
	        modificaPass = new JButton("Modifica Password"); //set label to button
	        modificaPass.setBounds(610,100, 200,100);
	        
	        modificaemail = new JButton("Modifica Email"); //set label to button
	        modificaemail.setBounds(390,100, 200,100);

	        indietroaccount = new JButton("Torna alla Dashboard"); //set label to button
	        indietroaccount.setBounds(500,340, 200,100);
		
        menu_account = new JPanel();
        menu_account.setLayout(null);
        menu_account.setSize(1200,600);
        add(menu_account);
        menu_account.add(cambiaiban);
        menu_account.add(indietroaccount);
        menu_account.add(modificaPass);
        menu_account.add(modificatelefono);
        menu_account.add(modificaemail);
        menu_account.setVisible(true);
        
        indietroaccount.addActionListener(this);
        cambiaiban.addActionListener(this::Iban);
        modificaPass.addActionListener(this::Pass);
        modificatelefono.addActionListener(this::Telefono);
        modificaemail.addActionListener(this::Email);
		
		
	}

	public void Email(ActionEvent e) {
		// TODO Auto-generated method stub
	   	 ModuloModificaEmail mail = new ModuloModificaEmail(this.utente);
	    	mail.setSize(1200, 600);  //set size of the frame
	    	mail.setVisible(true);  //make form visible to the user
	 	 	dispose();
	}
	public void Iban(ActionEvent e) {
		// TODO Auto-generated method stub
	   	 ModuloModificaIban iban = new ModuloModificaIban(this.utente);
	   	iban.setSize(1200, 600);  //set size of the frame
	   	iban.setVisible(true);  //make form visible to the user
	 	 	dispose();
	}
	public void Pass(ActionEvent e) {
		// TODO Auto-generated method stub
	   	 ModuloModificaPassword pass = new ModuloModificaPassword(this.utente);
	    	pass.setSize(1200, 600);  //set size of the frame
	    	pass.setVisible(true);  //make form visible to the user
	 	 	dispose();
	}
	public void Telefono(ActionEvent e) {
		// TODO Auto-generated method stub
	   	 ModuloModificaTelefono tel = new ModuloModificaTelefono(this.utente);
	    	tel.setSize(1200, 600);  //set size of the frame
	    	tel.setVisible(true);  //make form visible to the user
	 	 	dispose();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	   	 ModuloDashBoard dash = new ModuloDashBoard(this.utente);
	    	dash.setSize(1200, 600);  //set size of the frame
	    	dash.setVisible(true);  //make form visible to the user
	 	 	dispose();
	}
	
}
