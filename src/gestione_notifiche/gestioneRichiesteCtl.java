package gestione_notifiche;

import java.util.ArrayList;

import DBMSBoundary.DBMSservice;
import Entita.Richiesta;

public class gestioneRichiesteCtl {
    public gestioneRichiesteCtl() { }

    public ArrayList<Richiesta> getListaRichieste(int matricola) {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryGetListaRichiesteImpiegato(matricola);
    }

    public ArrayList<Richiesta> getListaRichiesteConcesse() {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryGetListaRichiesteConcesse();
    }
}
