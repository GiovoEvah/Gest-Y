package grafica;
import javax.swing.*;

import Entita.Utente;

import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class ModuloDashBoard extends JFrame implements ActionListener {

    JButton Presenza, Assunzione, Salario, LogOut, Astenzione,accountbtn,calendarbtn,notifybtn,malattiaadmin,calendariogiornaliero,accredita;
    JButton inviocomunicazione,approvaferie,chiusuraservizi,richieste,visualizzara,gestioneimpiegato,cerca,visualizzapresenza;
    JPanel dashboard;
    JLabel userLabel, wel_label, dashboardimp, dashboardadmin;
    private String userValue;
    private Utente utente;
	
	ModuloDashBoard(Utente utente){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.userValue = utente.getNome() + " " + utente.getCognome();
		this.utente = new Utente();
		this.utente = utente;
    	
    	richieste = new JButton("Visualizza Richieste");
    	richieste.setBounds(360,100, 200,80);
    	richieste.setFont(new Font("Arial", Font.PLAIN, 16));
    	richieste.setBackground(Color.white);
    	
	    Salario = new JButton("Visualizza Buste Paga"); //set label to button
	    Salario.setBounds(360,190, 200,80);
	    Salario.setFont(new Font("Arial", Font.PLAIN, 16));
	    Salario.setBackground(Color.white);

    	visualizzara = new JButton("Visualizza Ritardi/Assenze");
    	visualizzara.setBounds(360,280, 200,80);
    	visualizzara.setFont(new Font("Arial", Font.PLAIN, 14));
    	visualizzara.setBackground(Color.white);
    	
    	calendariogiornaliero = new JButton("Calendario Giornaliero");
    	calendariogiornaliero.setBounds(360,370, 200,80);
	    calendariogiornaliero.setFont(new Font("Arial", Font.PLAIN, 16));
	    calendariogiornaliero.setBackground(Color.white);
    	
    	accredita = new JButton("Paga quei cazzo di cinesi");
    	accredita.setBounds(360,460, 200,80);
		accredita.setFont(new Font("Arial", Font.PLAIN, 16));
		accredita.setBackground(Color.white);
	    
    	visualizzapresenza = new JButton("Visualizza Presenza");
    	visualizzapresenza.setBounds(640,190, 200,80);
    	visualizzapresenza.setFont(new Font("Arial", Font.PLAIN, 16));
    	visualizzapresenza.setBackground(Color.white);
    	
    	gestioneimpiegato = new JButton("Gestione Impiegato");
    	gestioneimpiegato.setBounds(640,190, 200,80);
    	gestioneimpiegato.setFont(new Font("Arial", Font.PLAIN, 16));
    	gestioneimpiegato.setBackground(Color.white);
    	
    	chiusuraservizi = new JButton("Chiusura Servizi");
    	chiusuraservizi.setBounds(640,370, 200,80);
    	chiusuraservizi.setFont(new Font("Arial", Font.PLAIN, 16));
    	chiusuraservizi.setBackground(Color.white);
    	
    	approvaferie = new JButton("Approva Ferie Schiavi");
    	approvaferie.setBounds(640,460, 200,80);
    	approvaferie.setFont(new Font("Arial", Font.PLAIN, 16));
    	approvaferie.setBackground(Color.white);
    	
    	inviocomunicazione = new JButton("Invia Comunicazionens");
    	inviocomunicazione.setBounds(640,280, 200,80);
    	inviocomunicazione.setFont(new Font("Arial", Font.PLAIN, 16));
    	inviocomunicazione.setBackground(Color.white);
    	
		malattiaadmin = new JButton("Malattia Admin");
		malattiaadmin.setBounds(640,280, 200,80);
	    malattiaadmin.setFont(new Font("Arial", Font.PLAIN, 16));
	    malattiaadmin.setBackground(Color.white);
	    
		Presenza = new JButton("Rilevazione Presenza"); //set label to button
	    Presenza.setBounds(640,100, 200,80);
	    Presenza.setVisible(false);
	    Presenza.setFont(new Font("Arial", Font.PLAIN, 16));
	    Presenza.setBackground(Color.white);
	    
	    Assunzione = new JButton("Gestisci Assunzione"); //set label to button
	    Assunzione.setBounds(640,100, 200,80);
	    Assunzione.setVisible(false);
	    Assunzione.setFont(new Font("Arial", Font.PLAIN, 16));
	    Assunzione.setBackground(Color.white);
	    
	    Astenzione = new JButton("Richiesta Astenzione"); //set label to button
	    Astenzione.setBounds(640,190, 200,80);
	    Astenzione.setFont(new Font("Arial", Font.PLAIN, 16));
	    Astenzione.setBackground(Color.white);
	   
	    //Cerca amante di costa
        ImageIcon search = new ImageIcon("search.png");
    	cerca = new JButton(search);
        cerca.setBounds(1020,20,40,40);
        cerca.setContentAreaFilled(false);
        cerca.setBorder(null);
	    
	    LogOut = new JButton("LogOut"); //set label to button
	    LogOut.setBounds(975,472, 200,80);
	    LogOut.setFont(new Font("Arial", Font.PLAIN, 16));
	    LogOut.setBackground(Color.white);
	    
        ImageIcon account = new ImageIcon("account.png");
        accountbtn = new JButton(account);
        accountbtn.setContentAreaFilled(false);
        accountbtn.setBorder(null);
        accountbtn.setBounds(1080,20,40,40);

        ImageIcon calendar = new ImageIcon("calendar.png");
        calendarbtn = new JButton(calendar);
        calendarbtn.setContentAreaFilled(false);
        calendarbtn.setBorder(null);
        calendarbtn.setBounds(1020,20,40,40);

        ImageIcon notify = new ImageIcon("notify.png");
        notifybtn = new JButton(notify);
        notifybtn.setContentAreaFilled(false);
        notifybtn.setBorder(null);
        notifybtn.setBounds(1140,20,40,40);
        
        ImageIcon dashboardad = new ImageIcon("dashboard.png");
        dashboardadmin = new JLabel();
        dashboardadmin.setText("");
        dashboardadmin.setBounds(475,20, 249,39);
        dashboardadmin.setIcon(dashboardad);

        ImageIcon dashboardim = new ImageIcon("dashboard.png");
        dashboardimp = new JLabel();
        dashboardimp.setText("");
        dashboardimp.setBounds(475,20, 249,39);
        dashboardimp.setIcon(dashboardim);
        dashboardimp.setVisible(false);
		
        wel_label = new JLabel();
        wel_label.setBounds(10,25, 200,40);
        wel_label.setFont(new Font("Arial", Font.BOLD, 15));

        wel_label.setText("Benvenuto: " + userValue);
		dashboard = new JPanel();
        dashboard.setLayout(null);
        dashboard.setSize(1200,600);
        dashboard.add(accountbtn);
        dashboard.add(notifybtn);
        dashboard.add(calendarbtn);
        dashboard.add(dashboardadmin);
        dashboard.add(dashboardimp);
        dashboard.add(Salario);
        dashboard.add(LogOut);
        dashboard.add(Assunzione);
        dashboard.add(Presenza);
        dashboard.add(wel_label);
        dashboard.add(Astenzione);
        dashboard.add(calendariogiornaliero);
        dashboard.add(malattiaadmin);
        dashboard.add(calendariogiornaliero);
        dashboard.add(accredita);
        dashboard.add(inviocomunicazione);
        dashboard.add(approvaferie);
        dashboard.add(chiusuraservizi);
        dashboard.add(richieste);
        dashboard.add(visualizzara);
        dashboard.add(gestioneimpiegato);
        dashboard.add(cerca);
        dashboard.add(visualizzapresenza);
        add(dashboard);
        LogOut.addActionListener(this);
        Salario.addActionListener(this::Salario);
        Astenzione.addActionListener(this::Astenzione);
        accountbtn.addActionListener(this::Account);
        
        if(utente.getIsAdmin()==false && utente.getIsDDL()==false) {
    		//utente è impiegato
        	cerca.setBounds(960,20,40,40);
    		calendarbtn.setVisible(true);
    		Astenzione.setVisible(true);
    		Assunzione.setVisible(false);
    		malattiaadmin.setVisible(false);
    		calendariogiornaliero.setVisible(false);
    		accredita.setVisible(false);
    		inviocomunicazione.setVisible(false);
    		approvaferie.setVisible(false);
    		chiusuraservizi.setVisible(false);
    		visualizzara.setVisible(false);
    		gestioneimpiegato.setVisible(false);
    		cerca.setVisible(false);
    		Presenza.setVisible(true);
    		visualizzapresenza.setVisible(true);
    	} else if (utente.getIsAdmin()==true && utente.getIsDDL()==false) {
    		//utente è admin;
    		cerca.setBounds(960,20,40,40);
    		calendarbtn.setVisible(true);
    		Astenzione.setVisible(true);
    		Assunzione.setVisible(false);
    		malattiaadmin.setVisible(true);
    		calendariogiornaliero.setVisible(true);
    		accredita.setVisible(false);
    		inviocomunicazione.setVisible(false);
    		approvaferie.setVisible(false);
    		chiusuraservizi.setVisible(true);
    		visualizzara.setVisible(true);
    		gestioneimpiegato.setVisible(false);
    		cerca.setVisible(true);
    		Presenza.setVisible(true);
    		visualizzapresenza.setVisible(false);
    	} else if(utente.getIsAdmin()==true && utente.getIsDDL()==true){
    		//utente è DDL
    		cerca.setBounds(1020,20,40,40);
    		calendarbtn.setVisible(false);
    		Astenzione.setVisible(false);
    		Assunzione.setVisible(true);
    		malattiaadmin.setVisible(false);
    		calendariogiornaliero.setVisible(true);
    		accredita.setVisible(true);
    		inviocomunicazione.setVisible(true);
    		approvaferie.setVisible(true);
    		chiusuraservizi.setVisible(true);
    		visualizzara.setVisible(true);
    		gestioneimpiegato.setVisible(true);
    		cerca.setVisible(true);
    		Presenza.setVisible(false);
    		visualizzapresenza.setVisible(false);
    	}
        
        
        
        
    }


	public void Account(ActionEvent e) {
	   	 ModuloAccount account = new ModuloAccount(this.utente);
	     account.setSize(1200, 600);  //set size of the frame
	     account.setVisible(true);  //make form visible to the user
	     dispose();
		}

	public void Astenzione(ActionEvent e) {
   	 ModuloRichiestaAstenzione form = new ModuloRichiestaAstenzione(this.utente);
     form.setSize(1200, 600);  //set size of the frame
     form.setVisible(true);  //make form visible to the user
     dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
   	   ModuloLogin form = new ModuloLogin();
       form.setSize(1200, 600);  //set size of the frame
       form.setVisible(true);  //make form visible to the user
	   dispose();
	}
	public void Salario(ActionEvent e) {
	      ModuloSalario salario = new ModuloSalario(this.utente);
	      salario.setSize(1200,600);
	      salario.setVisible(true);
		   dispose();
	}
	
	
}
