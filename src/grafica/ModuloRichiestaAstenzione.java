package grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
//import com.toedter.calendar.JDateChooser;

import Entita.Utente;


public class ModuloRichiestaAstenzione extends JFrame implements ActionListener {

	JButton Indietro, Invia, Seleziona,Invia2, Calendar;
	JLabel RichiestaTXT, l,CheckTXT, DataTXT, Data2TXT;
	JPanel Modulo;
	JTextField Oggetto;
    String Motivo;
    File j;
    String filename;
	private Utente utente;
	ModuloRichiestaAstenzione(Utente utente){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.utente = new Utente();
		this.utente = utente;
		
        ImageIcon calendar = new ImageIcon("calendar.png");
		Calendar = new JButton(calendar);
		Calendar.setBounds(250,250,40,40);
        Calendar.setContentAreaFilled(false);
        Calendar.setBorder(null);
		
		DataTXT = new JLabel("Seleziona intervallo date:");
	    DataTXT.setBounds(100,250,200,50);
	    
		Data2TXT = new JLabel("DD/MM/YYYY");
	    Data2TXT.setBounds(100,300,200,50);
		
		Indietro = new JButton("Indietro");
	    Indietro.setBounds(550,430,200,50);
	    
		Invia = new JButton("Invia");
	    Invia.setBounds(550,310,200,50);
	    
		Invia2 = new JButton("Invia");
	    Invia2.setBounds(550,310,200,50);
	    Invia2.setVisible(false);
	    
		Seleziona = new JButton("Seleziona");
	    Seleziona.setBounds(550,370,200,50);
		
		RichiestaTXT = new JLabel("Inserisci Oggetto Richiesta:");
		RichiestaTXT.setBounds(420,250,250,50);
		
		CheckTXT = new JLabel("Seleziona Motivo Richiesta:");
		CheckTXT.setBounds(420,80,250,50);
		
		l = new JLabel("Nessun File Selezionato");
		l.setBounds(790,250,250,50);
		
        JCheckBox checkBox1 = new JCheckBox("Malattia",true);  
        checkBox1.setBounds(525,130, 150,50);  
        JCheckBox checkBox2 = new JCheckBox("Congedo Familiare",false);  
        checkBox2.setBounds(525,180, 150,50);  
        JCheckBox checkBox3 = new JCheckBox("Ferie",false);  
        checkBox3.setBounds(675,130, 150,50);  
        JCheckBox checkBox4 = new JCheckBox("Sciopero",false);  
        checkBox4.setBounds(675,180, 150,50);  
        
        final ButtonGroup bg = new ButtonGroup();
        bg.add(checkBox1);
        bg.add(checkBox2);
        bg.add(checkBox3);
        bg.add(checkBox4);
 
        checkBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                Seleziona.setVisible(true);
                l.setVisible(true);
                Indietro.setBounds(550,430,200,50);
                Invia2.setVisible(false);
                Invia.setVisible(true);
            }
        });
        checkBox2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                Seleziona.setVisible(true);
                l.setVisible(true);
                Indietro.setBounds(550,430,200,50);
                Invia2.setVisible(false);
                Invia.setVisible(true);
            	
            }
        });
        checkBox3.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
             Seleziona.setVisible(false);
             l.setVisible(false);
             Indietro.setBounds(550,370,200,50);
             Invia2.setVisible(true);
             Invia.setVisible(false);
            	
            }
        });
        checkBox4.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                Seleziona.setVisible(true);
                l.setVisible(true);
                Indietro.setBounds(550,430,200,50);
                Invia2.setVisible(false);
                Invia.setVisible(true);
            	
            }
        });
        
		Oggetto = new JTextField("");
		Oggetto.setBounds(580,260, 200,30);
		Modulo = new JPanel();
		Modulo.setLayout(null);
        Modulo.setSize(1200,600);
        Modulo.setVisible(true);
        
        Modulo.add(l);
        Modulo.add(Indietro);
        Modulo.add(Invia);
        Modulo.add(Invia2);
        Modulo.add(Seleziona);
        Modulo.add(RichiestaTXT);
        Modulo.add(Oggetto);
        Modulo.add(CheckTXT);
        Modulo.add(checkBox1);
        Modulo.add(checkBox2);
        Modulo.add(checkBox3);
        Modulo.add(checkBox4);
        Modulo.add(Calendar);
        Modulo.add(DataTXT);
        Modulo.add(Data2TXT);
        add(Modulo);
        Indietro.addActionListener(this);
		Seleziona.addActionListener(this::Selezione);
		Invia.addActionListener(this::Invia);
		Invia2.addActionListener(this::Invia2);
		Calendar.addActionListener(this::Calendar);
		setFile(null);
		setFileName(null);
		
		

    }
	
	
    public void Calendar(ActionEvent e) {

    }
	public void Invia(ActionEvent e) {
		Motivo = Oggetto.getText();
        SendEmail sender = new SendEmail();
        //File j = null;
		sender.sendEmailAssenzione(Motivo,this.getFile(),this.getFileName());
		
	}
	public void Invia2(ActionEvent e) {
		Motivo = Oggetto.getText();
        SendEmail sender = new SendEmail();
		sender.sendEmailAstenzione2(Motivo);
		
	}
	
	public File getFile() {
		return this.j;
	}
	
	public void setFile(File new_file) {
		this.j = new_file;
	}
	
	public String getFileName() {
		return this.filename;
	}
	
	public void setFileName(String pippo) {
		this.filename = pippo;
	}
	
	
	public void Selezione(ActionEvent e) {
		
		 String com = e.getActionCommand();
		 JFileChooser j_new = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		 
	        if (com.equals("save")) {
	            // create an object of JFileChooser class
	            //JFileChooser j_new = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	 
	            // invoke the showsSaveDialog function to show the save dialog
	            int r = j_new.showSaveDialog(null);
	 
	            // if the user selects a file
	            if (r == JFileChooser.APPROVE_OPTION)
	 
	            {
	                // set the label to the path of the selected file
	                l.setText(j_new.getSelectedFile().getAbsolutePath());
	                setFile(j_new.getSelectedFile());
	                setFileName(j_new.getSelectedFile().getName());
	            }
	            // if the user cancelled the operation
	            else {
	            	l.setText("the user cancelled the operation");
	            	setFile(null);
	            }
	        }
	 
	        // if the user presses the open dialog show the open dialog
	        else {
	            // create an object of JFileChooser class
	            //JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	 
	            // invoke the showsOpenDialog function to show the save dialog
	            int r = j_new.showOpenDialog(null);
	 
	            // if the user selects a file
	            if (r == JFileChooser.APPROVE_OPTION)
	           	 
	            {
	                // set the label to the path of the selected file
	                l.setText(j_new.getSelectedFile().getAbsolutePath());
	                setFile(j_new.getSelectedFile());
	                setFileName(j_new.getSelectedFile().getName());
	            }
	            // if the user cancelled the operation
	            else {
	            	l.setText("the user cancelled the operation");
	            	setFile(null);
	            }
	        }
	        
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
   	 ModuloDashBoard dash = new ModuloDashBoard(this.utente);
     dash.setSize(1200, 600);  //set size of the frame
     dash.setVisible(true);  //make form visible to the user
     dispose();
	}

	
	
	
	
	
	
}
