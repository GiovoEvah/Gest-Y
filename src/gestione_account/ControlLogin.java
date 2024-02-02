package gestione_account;

import DBMSBoundary.DBMSservice;
import Entita.Utente;

public class ControlLogin {
    /*
     * questa control ha solo due metodi:
     * - uno per verificare che l'impiegato esista
     * - uno per "prendere" i dati dell'impiegato creato
     */
    private boolean exist;
    //private DBMSservice dbmsBnd;

    public boolean isExist() {
        return exist;
    }

    public ControlLogin() {
        this.exist = false;
        //dbmsBnd = new DBMSservice();
    }

    public boolean verificaCredenziali(int matricola, String password) {
        DBMSservice dbmsBnd = new DBMSservice();
        this.exist = dbmsBnd.queryVerificaCredenziali(matricola, password);
        return this.isExist();
    }

    public Utente createEntity(int matricola) {
        DBMSservice dbmsBnd = new DBMSservice();
        System.out.println("Creato utente con matriola: " + matricola);
        Utente utente = new Utente();
        utente = dbmsBnd.queryGetUtente(matricola);
        return utente;
    }


}
