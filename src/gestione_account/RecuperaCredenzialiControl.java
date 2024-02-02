package gestione_account;

import DBMSBoundary.DBMSservice;
import Entita.Utente;
import grafica.SendEmail;

public class RecuperaCredenzialiControl {
    private String email;
    private Utente utente;

    public RecuperaCredenzialiControl() {
        utente = new Utente();
    }

    public boolean verificaEmail(String email) {
        DBMSservice dbms = new DBMSservice();
        this.utente = dbms.queryVerificaEmail(email);
        if(this.utente == null)
            return false;
        this.email = email;
        return true;
    }

    public void sendEmail() {
        SendEmail sender = new SendEmail();
	    sender.sendEmail(this.utente.getEmail(), Integer.toString(this.utente.getMatricola()), this.utente.getPassw());
    } 

}
