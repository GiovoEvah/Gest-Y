package gestione_salario;

import java.util.ArrayList;

import DBMSBoundary.DBMSservice;
import Entita.BustaPaga;

public class GestioneSalarioCtl {

    public GestioneSalarioCtl() { }

    public ArrayList<BustaPaga> getBustePaga(int matricola, int mese_inizio, int anno_inizio, int mese_fine, int anno_fine) {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryGetListaBustePaga(matricola, mese_inizio, anno_inizio, mese_fine, anno_fine);
    }
}
