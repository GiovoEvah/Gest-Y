package gestione_turni;

import java.time.LocalDate;

import DBMSBoundary.DBMSservice;

public class MockIndisponibilita {
    public static void main(String[] args) {
        //aggiungo le indisponibilità
         DBMSservice dbms = new DBMSservice();
        //LOCALDATE YYYY-MM-DD
        String start = "2023-01-01";
        //LocalDate today = LocalDate.now();
        LocalDate startDay = LocalDate.parse(start);
        dbms.addIndisponibilita(7, startDay);
    }
}
