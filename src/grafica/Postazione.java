package grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

class createform extends JFrame
{
    JPanel newPanel;
    JButton submit, ingresso, uscita, indietro, inviomail;
    JLabel nome, cognome, matricola,costast,testouscita,testoentrata,testoerrore,wel_label, Wrong,dashboardlogo;
    final JTextField textField1, textField2, textField3;
    boolean entrato = false;

    String userValue;

    createform() {
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon dashboardad = new ImageIcon("dashboard.png");
        dashboardlogo = new JLabel();
        dashboardlogo.setText("");
        dashboardlogo.setBounds(475,20, 249,39);
        dashboardlogo.setIcon(dashboardad);

        Wrong = new JLabel();
        Wrong.setText("Credenziali Errate, riprova");
        Wrong.setVisible(false);
        Wrong.setBounds(525, 300, 200, 60);

        testoentrata = new JLabel();
        testoentrata.setText("Entrata registrata con successo!");
        testoentrata.setBounds(504,70, 192,100);
        testoentrata.setVisible(false);

        testouscita = new JLabel();
        testouscita.setText("Uscita registrata con successo!");
        testouscita.setBounds(504,70, 200,100);
        testouscita.setVisible(false);

        testoerrore= new JLabel();
        testoerrore.setText("Errore, dati non trovati nel database");
        testoerrore.setBounds(20, 310, 200, 60);
        testoerrore.setVisible(false);

        ImageIcon costas = new ImageIcon("costa.png");
        costast = new JLabel();
        costast.setText("");
        costast.setBounds(20,20, 556,54);
        costast.setIcon(costas);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nome = new JLabel();
        nome.setText("Nome: ");
        nome.setBounds(450,100, 200,30);
        cognome = new JLabel();
        cognome.setText("Cognome: ");
        cognome.setBounds(450,150, 200,30);
        matricola = new JLabel();
        matricola.setText("Matricola: ");
        matricola.setBounds(450, 200, 200, 30);

        textField1 = new JTextField(15);    //set length of the text
        textField1.setBounds(550,100, 200,30);

        textField2 = new JTextField(15);    //set length of the text
        textField2.setBounds(550,150, 200,30);

        textField3 = new JTextField(15);    //set length of the text
        textField3.setBounds(550,200, 200,30);

        wel_label = new JLabel();
        wel_label.setBounds(475,20, 200,100);
        wel_label.setVisible(false);

        submit = new JButton("Entra");
        submit.setBounds(500, 250, 200, 60);


        ingresso = new JButton("Registra Ingresso");
        ingresso.setBounds(450,140, 300,150);
        ingresso.setVisible(false);

        uscita = new JButton("Registra Uscita");
        uscita.setBounds(450,140, 300,150);
        uscita.setVisible(false);

        indietro = new JButton("Indietro");
        indietro.setBounds(450,310, 300,150);
        indietro.setVisible(false);

        newPanel = new JPanel();
        newPanel.setLayout(null);
        newPanel.setSize(800, 500);

        newPanel.add(nome);
        newPanel.add(cognome);
        newPanel.add(matricola);
        newPanel.add(textField1);
        newPanel.add(textField2);
        newPanel.add(textField3);
        newPanel.add(submit);
        newPanel.add(ingresso);
        newPanel.add(uscita);
        newPanel.add(indietro);
        newPanel.add(testoentrata);
        newPanel.add(testouscita);
        newPanel.add(testoerrore);
        newPanel.add(costast);
        newPanel.add(wel_label);
        newPanel.add(Wrong);
        newPanel.add(dashboardlogo);

        add(newPanel);
        setTitle("Login Aziendale");

        ingresso.addActionListener(this::entrata);
        submit.addActionListener(this::submit);
        uscita.addActionListener(this::uscita);
        indietro.addActionListener(this::indietro);


    }

    private void entrata(ActionEvent e){
        testoentrata.setVisible(true);
        testouscita.setVisible(false);
        testoerrore.setVisible(false);
        entrato = true;
        indietro.setBounds(450,140, 300,150);
        ingresso.setVisible(false);


    }
    private void uscita(ActionEvent e){
        testoentrata.setVisible(false);
        testouscita.setVisible(true);
        testoerrore.setVisible(false);
        entrato = false;
        indietro.setBounds(450,140, 300,150);
        uscita.setVisible(false);
    }
    private void submit(ActionEvent e){


        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();        //get user entered pasword from the textField2
        String matValue = textField3.getText();        //get user entered pasword from the textField2

        //check whether the credentials are authentic or not
        if (userValue.equals("Gabriele") && passValue.equals("Costa")) {  //if authentic, navigate user to a new page
            loggedin();
            Wrong.setVisible(false);
        }
        else if (userValue.equals("Giovanni") && passValue.equals("Castelli")) {  //if authentic, navigate user to a new page
            loggedin();
            Wrong.setVisible(false);
        }
        else{
            //show error message
            System.out.println("Please enter valid username and password");
            Wrong.setVisible(true);
        }

    }
    private void loggedin(){

        if(entrato == false)
        {
            ingresso.setVisible(true);
            uscita.setVisible(false);
        }
        if(entrato == true)
        {
            ingresso.setVisible(false);
            uscita.setVisible(true);
        }

        userValue = textField1.getText();
        wel_label.setText("Benvenuto: " + userValue);
        wel_label.setVisible(true);

        submit.setVisible(false);
        nome.setVisible(false);
        cognome.setVisible(false);
        matricola.setVisible(false);
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        indietro.setVisible(true);
        wel_label.setVisible(true);
    }
    private void indietro(ActionEvent e){
        indietro.setBounds(450,310, 300,150);
        submit.setVisible(true);
        nome.setVisible(true);
        cognome.setVisible(true);
        matricola.setVisible(true);
        textField1.setVisible(true);
        textField2.setVisible(true);
        textField3.setVisible(true);
        ingresso.setVisible(false);
        uscita.setVisible(false);
        indietro.setVisible(false);
        wel_label.setVisible(false);
        wel_label.setVisible(false);
        testoentrata.setVisible(false);
        testoerrore.setVisible(false);
        testouscita.setVisible(false);
    }
}
public class Postazione {
    public static void main(String arg[]) {

        try {
            //create instance of the CreateLoginForm
            createform form = new createform();
            form.setSize(1200, 600);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        } catch (Exception e) {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}