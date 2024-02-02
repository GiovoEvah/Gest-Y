package gestione_presenza;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import DBMSBoundary.DBMSservice;
import Entita.Turno;

public class ingressoRemotoCtl {
    public ingressoRemotoCtl() { }

    private LocalDate checkDate() {
        //String date = "2023-01-01";
        return LocalDate.now();
        //return LocalDate.parse(date);
    }

    private LocalTime checkTime() {
        //String time = "10:05";
        //String time = "09:09";
        return LocalTime.now();
        //return LocalTime.parse(time);
    }

    public boolean checkImpiegato(int matricola) {
        DBMSservice dbms = new DBMSservice();
        return dbms.queryExistsImpiegato(matricola);
    }

    public Turno getTurno(int matricola) {
        //per ora gestisco io date e tempo, poi ci penseranno le classi checkTime e checkDate
        //LocalDate data = this.checkDate();
        LocalDate data = this.checkDate();
        LocalTime ora = this.checkTime();
        //System.out.println("Sono le " + ora + " del " + data );
        DBMSservice dbms = new DBMSservice();
        if(dbms.queryGetTurno(matricola, data).size()==0) {
            return null;
        } else {
            return dbms.queryGetTurno(matricola, data).get(0);
        }
    }

    public void firmaIngresso(Turno turno, int matricola, String motivazione) {
        if(Objects.isNull(turno)) {
            System.out.println("Impiegato non in turno");
        } else {
            System.out.println(turno.toString());
            if(turno.isFirmaIN()==false && turno.isFirmaOUT()==false) {
                //turno non ancora firmato, ne in ingresso ne in uscita
                //siamo da remoto, dunque la firma può avvenire solo 10 minuti dopo
                if(turno.getOraInizio().plusMinutes(10).isAfter(this.checkTime())) {
                    //sono ancora in tempo
                    long minutes = ChronoUnit.MINUTES.between(turno.getOraInizio(),this.checkTime());
                    System.out.println("Puoi registrare la presenza da remoto tra " + minutes + " minuti");
                } else {
                    //può registrare la presenza
                    DBMSservice dbms = new DBMSservice();
                    dbms.queryFirmaIngresso(turno);
                    dbms.queryInserisciMotivazioneRitardo(turno, motivazione);
                    System.out.println("Presenza registrata in ritardo per il turno " + turno.getId_turno() + " in data " + turno.getDataTurno());
                }
            } else if(turno.isFirmaOUT()==true) {
                System.out.println("Turno già firmato in uscita");
            } else if (turno.isFirmaIN()==true) {
                System.out.println("Turno già firmato in ingresso");
            } else if (turno.isFirmaIN()==true && turno.isFirmaOUT()==true) {
                System.out.println("Turno già firmato in ingresso ed uscita");
            }
        }
    }

    public boolean isPresente(Turno turno) {
        return Objects.isNull(turno);
    }
}
