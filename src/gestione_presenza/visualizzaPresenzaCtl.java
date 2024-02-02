package gestione_presenza;

import java.time.LocalDate;
import java.util.ArrayList;

import DBMSBoundary.DBMSservice;
import Entita.Turno;

public class visualizzaPresenzaCtl {
    public visualizzaPresenzaCtl() { }

    public ArrayList<Turno> getListaTurniFirmati(int matricola) {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryGetListaTurniFirmati(matricola);
    }

    public ArrayList<Turno> getListaAssenze(int matricola) {
        DBMSservice dbms = new DBMSservice();
        //LocalDate data = LocalDate.parse("2023-01-05");
        LocalDate data = LocalDate.now();
        return dbms.queryGetListaAssenze(matricola, data);
    }

    public ArrayList<Turno> showList(int matricola) {
        ArrayList<Turno> lista = new ArrayList<>();
        for(Turno turno: this.getListaTurniFirmati(matricola))
            lista.add(turno);
        for(Turno turno: this.getListaAssenze(matricola))
            lista.add(turno);
        return lista;
    }
}
