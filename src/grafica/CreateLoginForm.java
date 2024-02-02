//import required classes and packages
package grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click
class CreateLoginForm extends JFrame implements ActionListener
{

	grafica.ModuloSalario modulosalario = new grafica.ModuloSalario(null);
    JButton b1,Presenza, Assunzione, Salario, LogOut, accountbtn,calendarbtn,notifybtn, indietrorecupero,inviorecupero, invioiban;
    JButton indietroiban,cambiaiban,indietroaccount, modificaPass, okerroremail,modificatelefono,inviatelefono,indietrotelefono,modificaemail,invianuovaemail,indietrodanuovamail,inviapassword,indietropassword;
    JPanel newPanel, dashboard, menu_presenza,menu_account,menu_assunzioni,menu_forgot,menu_iban,box,menu_password,menu_email,menu_telefono, menusalario;
    JLabel userLabel, passLabel, Forgot, Wrong, costast,welcome, wel_label, dashboardimp, dashboardadmin, MailLabel, emailinviatatxt, emailnontrovata,erroreiban,nuovapassword,vecchiapassword;
    JLabel ibanLabel, confermaiban,errorematricola,errorepassword,erroreempty,confermapassword,nuovaemail,nuovotelefono,erroretelefono,confermatelefono,erroretelefonovuoto,trenove;
    JLabel erroremail,erroremailvuoto,confermamail;
    private String emailValue;
    String userValue;
    final JTextField  textField1, textField2,MailText,ibanField,vecchiapasswordField,nuovapasswordField,confermapasswordField,nuovamailField,nuovotelefonoField;
    public static final Color VERY_LIGHT_RED = new Color(255,102,102);

    //calling constructor
    CreateLoginForm()
    {        
        
    	erroremail = new JLabel();
    	erroremail.setText("Errore, inserire una email valida");      //set label value for textField2
    	erroremail.setBounds(500,180, 200,30);
    	erroremail.setForeground(Color.RED.darker());
    	erroremail.setVisible(false);
    	
    	erroremailvuoto = new JLabel();
    	erroremailvuoto.setText("Errore, campo email vuoto");      //set label value for textField2
    	erroremailvuoto.setBounds(500,180, 200,30);
    	erroremailvuoto.setForeground(Color.RED.darker());
    	erroremailvuoto.setVisible(false);
    	
    	confermamail = new JLabel();
    	confermamail.setText("Nuova mail registrata con successo");      //set label value for textField2
    	confermamail.setBounds(500,180, 250,30);
    	confermamail.setForeground(Color.GREEN.darker());
    	confermamail.setVisible(false);
    	
    	
    	
    	
    	nuovapassword = new JLabel();
        nuovapassword.setText("Nuova Password:");      //set label value for textField2
        nuovapassword.setBounds(410,150, 200,30);
        
    	erroretelefono = new JLabel();
    	erroretelefono.setText("Errore, inserire un numero di telefono valido");      //set label value for textField2
    	erroretelefono.setBounds(500,180, 300,30);
        erroretelefono.setForeground(Color.RED.darker());
    	erroretelefono.setVisible(false);
    	
    	erroretelefonovuoto = new JLabel();
    	erroretelefonovuoto.setText("Errore, campo telefono vuoto");      //set label value for textField2
    	erroretelefonovuoto.setBounds(500,180, 300,30);
    	erroretelefonovuoto.setForeground(Color.RED.darker());
        erroretelefonovuoto.setVisible(false);
    	
    	confermatelefono = new JLabel();
    	confermatelefono.setText("Nuovo numero di telefono registrato con successo");      //set label value for textField2
    	confermatelefono.setBounds(465,180, 300,30);
        confermatelefono.setForeground(Color.GREEN.darker());
        confermatelefono.setVisible(false);
    	
        nuovapasswordField = new JPasswordField(10);    //set length for the password
        nuovapasswordField.setBounds(550,150, 200,30);
        
        vecchiapassword = new JLabel();
        vecchiapassword.setText("Vecchia Password:");      //set label value for textField2
        vecchiapassword.setBounds(410,100, 200,30);
    	
        vecchiapasswordField = new JTextField(15);    //set length of the text
        vecchiapasswordField.setBounds(550,100, 200,30);
        
        confermapassword = new JLabel();
        confermapassword.setText("Conferma Password:");      //set label value for textField2
        confermapassword.setBounds(410,200, 200,30);
    	
        confermapasswordField = new JTextField(15);    //set length of the text
        confermapasswordField.setBounds(550,200, 200,30);
        
        nuovaemail = new JLabel();
        nuovaemail.setText("Nuova Email:");      //set label value for textField2
        nuovaemail.setBounds(450,150, 200,30);
        
        nuovamailField = new JTextField(15);    //set length of the text
        nuovamailField.setBounds(550,150, 200,30);
        
        nuovotelefono = new JLabel();
        nuovotelefono.setText("Nuovo Telefono:");      //set label value for textField2
        nuovotelefono.setBounds(450,150, 200,30);
        
        trenove = new JLabel();
        trenove.setText("(+39)");      //set label value for textField2
        trenove.setBounds(550,125, 200,30);
        trenove.setForeground(Color.YELLOW.darker());
        
        nuovotelefonoField = new JTextField(15);    //set length of the text
        nuovotelefonoField.setBounds(550,150, 200,30);
    	
        inviatelefono = new JButton("Invio"); //set label to button
        inviatelefono.setBounds(500, 210, 200, 60);

        
        indietrotelefono = new JButton("Indietro"); //set label to button
        indietrotelefono.setBounds(500,280, 200,60);

        invianuovaemail = new JButton("Invio"); //set label to button
        invianuovaemail.setBounds(500, 210, 200, 60);
        
        indietrodanuovamail = new JButton("Indietro"); //set label to button
        indietrodanuovamail.setBounds(500,280, 200,60);
        
        inviapassword = new JButton("Invio"); //set label to button
        inviapassword.setBounds(500, 260, 200, 60);
        
        indietropassword = new JButton("Indietro"); //set label to button
        indietropassword.setBounds(500,330, 200,60);
    	
    	box = new JPanel();
    	box.setBounds(450,350,300,100);
    	box.setVisible(false);
    	box.setBackground(VERY_LIGHT_RED);
    	box.setBorder(BorderFactory.createLineBorder(Color.black));
    	
        erroreiban = new JLabel();
        erroreiban.setText("Errore, campo Iban vuoto");      //set label value for textField1
        erroreiban.setBounds(550,125, 170,30);
        erroreiban.setVisible(false);
        erroreiban.setForeground(Color.RED.darker());
    	
        okerroremail = new JButton("OK"); //set label to button
        okerroremail.setBounds(550,400, 80,30);
        okerroremail.setVisible(false);
        okerroremail.setBackground(Color.white);
    	
        ibanLabel = new JLabel();
        ibanLabel.setText("Nuovo Iban: ");      //set label value for textField1
        ibanLabel.setBounds(450,100, 200,30);
        
        ibanField = new JTextField(15);    //set length of the text
        ibanField.setBounds(550,100, 200,30);
        
        confermaiban = new JLabel();
        confermaiban.setText("Iban Modificato con successo");      //set label value for textField1
        confermaiban.setBounds(515,115, 170,30);
        confermaiban.setVisible(false);
        confermaiban.setForeground(Color.GREEN.darker());
        
        invioiban = new JButton("Conferma Iban"); //set label to button
        invioiban.setBounds(500,150, 200,100);
        
        indietroiban = new JButton("Indietro"); //set label to button
        indietroiban.setBounds(500,270, 200,100);
        
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
    	
        ImageIcon account = new ImageIcon("account.png");
        accountbtn = new JButton(account);
        accountbtn.setContentAreaFilled(false);
        accountbtn.setBorder(null);
        accountbtn.setBounds(1020,20,40,40);

        ImageIcon calendar = new ImageIcon("calendar.png");
        calendarbtn = new JButton(calendar);
        calendarbtn.setContentAreaFilled(false);
        calendarbtn.setBorder(null);
        calendarbtn.setBounds(1080,20,40,40);

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

        ImageIcon costas = new ImageIcon("dashboard.png");
        costast = new JLabel();
        costast.setText("");
        costast.setBounds(475,40, 249,39);
        costast.setIcon(costas);

        Wrong = new JLabel();
        Wrong.setText("Credenziali Errate, riprova");
        Wrong.setVisible(false);
        Wrong.setBounds(550,180, 200,30);
        Wrong.setForeground(Color.RED.darker());
        
        errorepassword = new JLabel();
        errorepassword.setText("Errore, campo password vuoto");
        errorepassword.setVisible(false);
        errorepassword.setBounds(550,175, 200,30);
        errorepassword.setForeground(Color.RED.darker());
        
        errorematricola = new JLabel();
        errorematricola.setText("Errore, campo matricola vuoto");
        errorematricola.setVisible(false);
        errorematricola.setBounds(550,175, 200,30);
        errorematricola.setForeground(Color.RED.darker());
        
        erroreempty = new JLabel();
        erroreempty.setText("Errore, campi credenziali vuoti");
        erroreempty.setVisible(false);
        erroreempty.setBounds(550,175, 200,30);
        erroreempty.setForeground(Color.RED.darker());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userLabel = new JLabel();
        userLabel.setText("Matricola:");      //set label value for textField1
        userLabel.setBounds(450,100, 200,30);

        Forgot = new JLabel();
        Forgot.setText("Password Dimenticata?"); //126 +2 +2 +2 +2 +2
        Forgot .setForeground(Color.BLUE.darker());
        Forgot.setBounds(537,240, 136,30);
        Forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      //  Forgot.setText("Ciao ciao"); //ciao = 6x4 = 24, Ciao  3x4 + 5= 25, spazio = 3
      //  Forgot.setBounds(537,240, 52,30);LO SPAZIO VALE 3, Lettera Grande 5, Lettera Piccola 4



        //create text field to get username from the user
        textField1 = new JTextField(15);    //set length of the text
        textField1.setBounds(550,100, 200,30);


        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Password:");      //set label value for textField2
        passLabel.setBounds(450,150, 200,30);
     //   passLabel.setSize(400,400);

        //create text field to get password from the user
        textField2 = new JPasswordField(10);    //set length for the password
        textField2.setBounds(550,150, 200,30);
        //create submit button
        b1 = new JButton("Entra"); //set label to button
        b1.setBounds(500,210, 200,30);

        welcome = new JLabel(); //set label to button
        welcome.setText("Benvenuto Amministratore:");
        welcome.setBounds(20,20, 200,100);
        welcome.setVisible(false);

        Presenza = new JButton("Rilevazione Presenza"); //set label to button
        Presenza.setBounds(290,150, 300,150);
        Presenza.setVisible(false);
        Presenza.setFont(new Font("Arial", Font.PLAIN, 25));

        Assunzione = new JButton("Gestisci Assunzione"); //set label to button
        Assunzione.setBounds(610,150, 300,150);
        Assunzione.setVisible(false);
        Assunzione.setFont(new Font("Arial", Font.PLAIN, 25));

        Salario = new JButton("Gestisci Salario"); //set label to button
        Salario.setBounds(290,320, 300,150);
        Salario.setVisible(false);
        Salario.setFont(new Font("Arial", Font.PLAIN, 25));

        LogOut = new JButton("LogOut"); //set label to button
        LogOut.setBounds(610,320, 300,150);
        LogOut.setVisible(false);
        LogOut.setFont(new Font("Arial", Font.PLAIN, 25));

        wel_label = new JLabel();
        userValue = textField1.getText();
        wel_label.setText("Password:" + userValue);
        wel_label.setBounds(550,40, 200,100);
        wel_label.setFont(new Font("Arial", Font.PLAIN, 15));
        wel_label.setVisible(false);

        MailLabel = new JLabel();
        MailLabel.setText("La tua mail:");      //set label value for textField1
        MailLabel.setBounds(450,160, 200,30);

        MailText = new JTextField(15);    //set length of the text
        MailText.setBounds(550,160, 200,30);

        indietrorecupero = new JButton("Indietro"); //set label to button
        indietrorecupero.setBounds(500,290, 200,30);

        inviorecupero = new JButton("Invia");
        inviorecupero.setBounds(500, 210, 200, 60);

        emailinviatatxt = new JLabel();
        emailinviatatxt.setVisible(false);
        emailinviatatxt.setText("Credenziali Inviate Tramite Email");
        emailinviatatxt.setForeground(Color.GREEN.darker());
        emailinviatatxt.setBounds(508,130, 184,30);

        emailnontrovata = new JLabel();
        emailnontrovata.setVisible(false);
        emailnontrovata.setText("Email non trovata nel sistema! Riprova!");
        emailnontrovata.setForeground(Color.white);
        emailnontrovata.setBounds(492, 350, 240, 60);

        //INIZIALIZZAZIONE JPANEL
        newPanel = new JPanel();
        newPanel.setLayout(null);
        newPanel.setSize(1200,600);
        newPanel.add(costast);
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(b1);           //set button to panel
        newPanel.add(Forgot);
        newPanel.add(Wrong, BorderLayout.PAGE_END);
        newPanel.add(errorematricola);
        newPanel.add(errorepassword);
        newPanel.add(erroreempty);
        add(newPanel);

        


        //INIZIALIZZAZIONE JPANEL
        menu_presenza = new JPanel();
        menu_presenza.setLayout(null);
        menu_presenza.setSize(1200,600);
        add(menu_presenza);
        menu_presenza.setVisible(false);

        //INIZIALIZZAZIONE JPANEL
        menu_account = new JPanel();
        menu_account.setLayout(null);
        menu_account.setSize(1200,600);
        add(menu_account);
        menu_account.add(cambiaiban);
        menu_account.add(indietroaccount);
        menu_account.add(modificaPass);
        menu_account.add(modificatelefono);
        menu_account.add(modificaemail);
        menu_account.setVisible(false);
        
        cambiaiban.addActionListener(this::menuiban);
        indietroaccount.addActionListener(this::indietroaccount);
        modificaemail.addActionListener(this::menu_email);
        modificaPass.addActionListener(this::menu_password);
        modificatelefono.addActionListener(this::menu_telefono);
        
        //INIZIALIZZAZIONE JPANEL
        menu_assunzioni = new JPanel();
        menu_assunzioni.setLayout(null);
        menu_assunzioni.setSize(1200,600);
        add(menu_assunzioni);
        menu_assunzioni.setVisible(false);

        //INIZIALIZZAZIONE JPANEL
        menu_iban = new JPanel();
        menu_iban.setLayout(null);
        menu_iban.setSize(1200,600);
        add(menu_iban);
        menu_iban.setVisible(false);
        menu_iban.add(ibanLabel);
        menu_iban.add(ibanField);
        menu_iban.add(confermaiban);
        menu_iban.add(indietroiban);
        menu_iban.add(invioiban);
        menu_iban.add(erroreiban);

        invioiban.addActionListener(this::inviaiban);
        indietroiban.addActionListener(this::indietrodaiban);

        //INIZIALIZZAZIONE JPANEL
        menu_forgot = new JPanel();
        menu_forgot.setLayout(null);
        menu_forgot.setSize(1200,600);
        add(menu_forgot);
        menu_forgot.setVisible(false);

        menu_forgot.add(inviorecupero);
        menu_forgot.add(indietrorecupero);
        menu_forgot.add(MailText);
        menu_forgot.add(MailLabel);
        menu_forgot.add(emailinviatatxt);
        menu_forgot.add(okerroremail);
        menu_forgot.add(emailnontrovata);
        menu_forgot.add(box);

        
        
        menu_password = new JPanel();
        menu_password.setLayout(null);
        menu_password.setSize(1200,600);
        add(menu_password);
        menu_password.add(inviapassword);
        menu_password.add(indietropassword);
        menu_password.add(nuovapassword);        
        menu_password.add(nuovapasswordField);
        menu_password.add(vecchiapassword);
        menu_password.add(vecchiapasswordField);
        menu_password.add(confermapassword);
        menu_password.add(confermapasswordField);
        menu_password.setVisible(false);
        
        menu_telefono = new JPanel();
        menu_telefono.setLayout(null);
        menu_telefono.setSize(1200,600);
        add(menu_telefono);
        menu_telefono.add(inviatelefono);
        menu_telefono.add(indietrotelefono);
        menu_telefono.add(nuovotelefono);
        menu_telefono.add(nuovotelefonoField);
        menu_telefono.add(confermatelefono);
        menu_telefono.add(erroretelefono);
        menu_telefono.add(erroretelefonovuoto);
        menu_telefono.add(trenove);
        menu_telefono.setVisible(false);
        
        
        menu_email = new JPanel();
        menu_email.setLayout(null);
        menu_email.setSize(1200,600);
        add(menu_email);
        menu_email.add(invianuovaemail);
        menu_email.add(indietrodanuovamail);
        menu_email.add(nuovaemail);
        menu_email.add(nuovamailField);
        menu_email.add(confermamail);
        menu_email.add(erroremail);
        menu_email.add(erroremailvuoto);
        menu_email.setVisible(false);
        
        
        
        InitDash();
        
        
        b1.addActionListener(this);     //add action listener to button
        setTitle("Login Aziendale");         //set title to the login form
        
        indietrorecupero.addActionListener(this::indietrodalrecupero);
        inviorecupero.addActionListener(this::clickrecupero);
        okerroremail.addActionListener(this::okerroremail);
        
        indietropassword.addActionListener(this::indietro_password);
        indietrodanuovamail.addActionListener(this::indietro_mail);
        indietrotelefono.addActionListener(this::indietro_telefono);
        
        inviatelefono.addActionListener(this::invio_nuovotelefono);
        invianuovaemail.addActionListener(this::invio_nuovaemail);
        inviapassword.addActionListener(this::invio_nuovapassword);

        Forgot.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // the user clicks on the label
                newPanel.setVisible(false);
                menu_forgot.setVisible(true);
            }

        });

    }
    public void InitDash() {
    	//INIZIALIZZAZIONE JPANEL
        dashboard = new JPanel();
        dashboard.setLayout(null);
        dashboard.setSize(1200,600);
        dashboard.add(accountbtn);
        dashboard.add(notifybtn);
        dashboard.add(calendarbtn);
        dashboard.add(dashboardadmin);
        dashboard.add(dashboardimp);
        dashboard.add(welcome);
        dashboard.add(Salario);
        dashboard.add(LogOut);
        dashboard.add(Assunzione);
        dashboard.add(Presenza);
        dashboard.add(wel_label);
        add(dashboard);
        Assunzione.setVisible(true);
        Salario.setVisible(true);
        LogOut.setVisible(true);
        Presenza.setVisible(true);
        dashboard.setVisible(false);
        Salario.addActionListener(this::ModuloSalario);
    }
    public void RestoreDash() {
    	dashboard.setVisible(true);
    	modulosalario.ModuloSalarioPanel.setVisible(false);
    	add(dashboard);
    }
    public void ModuloSalario(ActionEvent event) {
    	

        dashboard.setVisible(false);
    	//modulosalario.ModuloSalarioFunction(); 	
    	add(modulosalario.ModuloSalarioPanel);


    	
	//	modulosalario.ModuloSalarioPanel.add(newPanel);
    //	modulosalario.ModuloSalario.setVisible(true);
    	
    }
    
    
    private void invio_nuovotelefono(ActionEvent event) {
    	String numero = nuovotelefonoField.getText();
    	if(numero.equals(""))
    	{
        	erroretelefonovuoto.setVisible(true);	
        	erroretelefono.setVisible(false);
        	confermatelefono.setVisible(false);
    	}
    	else if(numero.equals("3421763047")){
        	nuovotelefonoField.setVisible(false);
        	inviatelefono.setVisible(false);
        	nuovotelefono.setVisible(false);
        	indietrotelefono.setBounds(500, 210, 200, 60);
        	confermatelefono.setVisible(true);
        	erroretelefono.setVisible(false);
        	erroretelefonovuoto.setVisible(false);
        	trenove.setVisible(false);
    	}
    	else {
        	erroretelefonovuoto.setVisible(false);
    		erroretelefono.setVisible(true);
    		confermatelefono.setVisible(false);
    	}
    	
    }
    private void invio_nuovaemail(ActionEvent event) {
    	String email = nuovamailField.getText();
    	if(email.equals(""))
    	{
        	erroremailvuoto.setVisible(true);	
        	erroremail.setVisible(false);
        	confermamail.setVisible(false);
    	}
    	else if(email.equals("raoul.renda@gmail.com")){
        	nuovamailField.setVisible(false);
        	invianuovaemail.setVisible(false);
        	nuovaemail.setVisible(false);
        	indietrodanuovamail.setBounds(500, 210, 200, 60);
        	confermamail.setVisible(true);
        	erroremail.setVisible(false);
        	erroremailvuoto.setVisible(false);
    	}
    	else {
        	erroremailvuoto.setVisible(false);
    		erroremail.setVisible(true);
    		confermamail.setVisible(false);
    	}
    	
    }
    private void invio_nuovapassword(ActionEvent event) {
    	inviapassword.setVisible(false);
    	
    }
    
    private void indietro_mail(ActionEvent event) {
    	menu_email.setVisible(false);
    	menu_account.setVisible(true);
    	indietrodanuovamail.setBounds(500,280, 200,60);
    	nuovamailField.setVisible(true);
    	invianuovaemail.setVisible(true);
    	nuovaemail.setVisible(true);
    	confermamail.setVisible(false);
    	erroremail.setVisible(false);
    	erroremailvuoto.setVisible(false);
    	nuovamailField.setText("");
    }
    private void indietro_password(ActionEvent event) {
    	menu_password.setVisible(false);
    	menu_account.setVisible(true);	
    }
    private void indietro_telefono(ActionEvent event) {
    	menu_telefono.setVisible(false);
    	menu_account.setVisible(true);
        indietrotelefono.setBounds(500,280, 200,60);
    	confermatelefono.setVisible(false);
    	erroretelefono.setVisible(false);
    	erroretelefonovuoto.setVisible(false);
    	nuovotelefonoField.setText("");
    	nuovotelefonoField.setVisible(true);
    	inviatelefono.setVisible(true);
    	nuovotelefono.setVisible(true);
    	trenove.setVisible(true);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    private void menu_email(ActionEvent event)
    {
    	menu_email.setVisible(true);
    	menu_account.setVisible(false);
    }
    private void menu_password(ActionEvent event)
    {
    	menu_password.setVisible(true);
    	menu_account.setVisible(false);	
    }
    private void menu_telefono(ActionEvent event)
    {
    	menu_telefono.setVisible(true);
    	menu_account.setVisible(false);
    }
    
    private void okerroremail(ActionEvent event) {
    	okerroremail.setVisible(false);
    	box.setVisible(false);
    	emailnontrovata.setVisible(false);
    	
    }
    private void clickrecupero(ActionEvent event){

        emailValue = MailText.getText();        //get user entered pasword from the textField2
        //check whether the credentials are authentic or not
        if (emailValue.equals("raoul.renda@gmail.com")) {  //QUI VA MESSO IL CHECK DEL DMBS PER VEDERE SE LA MAIL ESISTE
            emailinviatatxt.setVisible(true);
            MailText.setVisible(false);
            MailLabel.setVisible(false);
            indietrorecupero.setBounds(500, 210, 200, 60);
            emailnontrovata.setVisible(false);
            inviorecupero.setVisible(false);
            box.setVisible(false);
            okerroremail.setVisible(false);
            
            SendEmail sender = new SendEmail();
            sender.sendEmail(emailValue);
        }
        else{
            //show error message
            System.out.println("Email non trovata!");
            emailnontrovata.setVisible(true);
            
            box.setVisible(true);
            okerroremail.setVisible(true);

            
        }


    }
    
    private void indietrodalrecupero(ActionEvent event) {

        newPanel.setVisible(true);
        menu_forgot.setVisible(false);
        emailinviatatxt.setVisible(false);
        emailnontrovata.setVisible(false);
        MailText.setText("");
        inviorecupero.setVisible(true);
        MailLabel.setVisible(true);
        MailText.setVisible(true);
        indietrorecupero.setBounds(500,290, 200,30);
        textField2.setText("");
        textField1.setText("");
        box.setVisible(false);
        okerroremail.setVisible(false);
        
        


    }

    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();        //get user entered pasword from the textField2

        if(passValue.equals("") && userValue.equals("")) {
        	errorematricola.setVisible(false);
        	errorepassword.setVisible(false);
        	erroreempty.setVisible(true);
        	Wrong.setVisible(false);
        }
        else if(passValue.equals("")) {
        	errorematricola.setVisible(false);
        	errorepassword.setVisible(true);
        	erroreempty.setVisible(false);
        	Wrong.setVisible(false);
        }
        else if(userValue.equals(""))
        {
            Wrong.setVisible(false);
        	errorematricola.setVisible(true);
        	errorepassword.setVisible(false);
        	erroreempty.setVisible(false);
        }
        else if (userValue.equals("admin") && passValue.equals("admin")) {  //if authentic, navigate user to a new page

            admin();
            Wrong.setVisible(false);
        	errorematricola.setVisible(false);
        	errorepassword.setVisible(false);
        	erroreempty.setVisible(false);
            //Wrong.setVisible(false);

        }
        else if (userValue.equals("impiegato") && passValue.equals("impiegato")) {  //if authentic, navigate user to a new page
          impiegato();
          Wrong.setVisible(false);
          Wrong.setVisible(false);
      	errorematricola.setVisible(false);
      	errorepassword.setVisible(false);
      	erroreempty.setVisible(false);
        }
        else{
            //show error message
            System.out.println("Please enter valid username and password");
            Wrong.setVisible(true);
        	errorematricola.setVisible(false);
        	errorepassword.setVisible(false);
        	erroreempty.setVisible(false);
        }
    }
    public void impiegato() {

        dashboard.setVisible(true);
        newPanel.setVisible(false);
        userValue = textField1.getText();
        wel_label.setText("Benvenuto: " + userValue);
        wel_label.setVisible(true);

        Assunzione.setVisible(false);
        Presenza.setBounds(290,150, 300,150);
        Salario.setBounds(610,150, 300,150);
        LogOut.setBounds(450,320, 300,150);



        setTitle("Dashboard " +userValue);
        LogOut.addActionListener(this::goback);     //add action listener to button
        accountbtn.addActionListener(this::accountclick);
        notifybtn.addActionListener(this::notifyclick);
        calendarbtn.addActionListener(this::calendarclick);

    }
    public void admin() {
        dashboard.setVisible(true);
        newPanel.setVisible(false);
        userValue = textField1.getText();
        wel_label.setText("Benvenuto: " + userValue);
        wel_label.setVisible(true);
        setTitle("Dashboard " +userValue);
        LogOut.addActionListener(this::goback);     //add action listener to button
        Assunzione.setVisible(true);
        accountbtn.addActionListener(this::accountclick);
        notifybtn.addActionListener(this::notifyclick);
        calendarbtn.addActionListener(this::calendarclick);
    }

    private void goback(ActionEvent actionEvent) {

        Presenza.setBounds(290,150, 300,150);
        Assunzione.setBounds(610,150, 300,150);
        Salario.setBounds(290,320, 300,150);
        LogOut.setBounds(610,320, 300,150);
        newPanel.setVisible(true);
        dashboard.setVisible(false);
        textField1.setText("");
        textField2.setText("");

    }
    private void accountclick(ActionEvent actionEvent) {
    dashboard.setVisible(false);
    menu_account.setVisible(true);
    }
    private void calendarclick(ActionEvent actionEvent) {



    }
    private void notifyclick(ActionEvent actionEvent) {



    }
    //torna al pannello di gestione account
    private void indietrodaiban(ActionEvent actionEvent) {
    	menu_account.setVisible(true);
    	menu_iban.setVisible(false);
    	ibanField.setText("");
    	confermaiban.setVisible(false);
    	ibanField.setVisible(true);
    	ibanLabel.setVisible(true);
    	invioiban.setVisible(true);
    	indietroiban.setBounds(500,270, 200,100);
    	erroreiban.setVisible(false);
    	
    }
    //torna alla dashboard utente
    private void indietroaccount(ActionEvent actionEvent) {
    	menu_account.setVisible(false);
    	dashboard.setVisible(true);
    	
    }
    //invia nuovo iban al dbms
    private void inviaiban(ActionEvent actionEvent) {
    	String iban = ibanField.getText();
    	if(iban.equals(""))
    	{
    		erroreiban.setVisible(true);
    	}
    	else {
    	confermaiban.setVisible(true);
    	ibanField.setVisible(false);
    	ibanLabel.setVisible(false);
    	invioiban.setVisible(false);
    	indietroiban.setBounds(500,150, 200,100);
    	erroreiban.setVisible(false);
    	}
    }
    //mostra interfaccia per cambiare iban
    private void menuiban(ActionEvent actionEvent) {
    	menu_account.setVisible(false);
    	menu_iban.setVisible(true);    	
    	
    }
    
   
    
}
//create the main class
class LoginFormDemo {
    //main() method start
    public static void main(String arg[]) {
        try {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(1200, 600);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        } catch (Exception e) {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}