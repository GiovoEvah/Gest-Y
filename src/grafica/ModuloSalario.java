package grafica;
import javax.swing.*;

import Entita.Utente;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;




@SuppressWarnings("serial")
public class ModuloSalario extends JFrame implements ActionListener{

	public JPanel ModuloSalarioPanel;
	public JLabel testodiprova;
	public JButton Indietro;
	private Utente utente;
	
	public ModuloSalario(Utente utente){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.utente = new Utente();
		this.utente = utente;
	testodiprova = new JLabel();
	testodiprova.setText("Non abbiamo soldi figa");      //set label value for textField2
	testodiprova.setBounds(500,180, 200,30);
	testodiprova.setForeground(Color.RED.darker());
	
    Indietro = new JButton("Indietro"); //set label to button
    Indietro.setBounds(500,280, 200,60);
	
	 Indietro.addActionListener(this::indietro);
	 
	 ModuloSalarioPanel = new JPanel();
	 ModuloSalarioPanel.setLayout(null);
	 ModuloSalarioPanel.setSize(1200,600);
	 ModuloSalarioPanel.add(testodiprova);
	 ModuloSalarioPanel.add(Indietro);
	 add(ModuloSalarioPanel);
	 ModuloSalarioPanel.setVisible(true);
	 
	}

	private void indietro(ActionEvent ActionEvent) {
   	 ModuloDashBoard dash = new ModuloDashBoard(this.utente);
   	dash.setSize(1200, 600);  //set size of the frame
   	dash.setVisible(true);  //make form visible to the user
	 	dispose();
	 	
	 	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
