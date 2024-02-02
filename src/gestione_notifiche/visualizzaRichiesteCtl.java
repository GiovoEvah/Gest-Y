package gestione_notifiche;

import java.util.ArrayList;

import DBMSBoundary.DBMSservice;
import Entita.Richiesta;

public class visualizzaRichiesteCtl {
    public visualizzaRichiesteCtl() { }

    public ArrayList<Richiesta> getListaRichiesteConcesse() {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryGetListaRichiesteConcesse();
    }
}
