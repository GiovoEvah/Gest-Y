package gestione_impiegato;

import java.util.ArrayList;
import java.util.Objects;

import DBMSBoundary.DBMSservice;
import Entita.Impiegato;

public class cercaImpiegatoCtl {
    private ArrayList<Impiegato> listaImpiegati;

    public cercaImpiegatoCtl() {
        this.listaImpiegati = new ArrayList<>();
        this.setListaImpiegati();
    }

    public ArrayList<Impiegato> getListaImpiegati() {
        return listaImpiegati;
    }

    public void setListaImpiegati() {
        DBMSservice dbms = new DBMSservice();
        this.listaImpiegati = dbms.queryGetListaImpiegati();
    }

    public ArrayList<Impiegato> getListaImpiegatiFiltrata(String nome, String cognome) {
        ArrayList<Impiegato> lista = new ArrayList<>();
        /*
        if(nome.compareTo(" ")==0 && cognome.compareTo(" ")==0) {
            return this.getListaImpiegati();
        } else if (nome.compareTo(" ")==0 && cognome.compareTo(" ")!=0) {
            //filtro per cognome
            return lista;
        } else if (nome.compareTo(" ")!=0 && cognome.compareTo(" ")==0) {
            //filtro per nome
            return lista;
        } else if (nome.compareTo(" ")!=0 && cognome.compareTo(" ")!=0){
            //filtro per nome e cognome
            return lista;
        }
         */
        if (Objects.isNull(nome) && Objects.isNull(cognome)) {
            //non filtro
            return this.getListaImpiegati();
        } else if (Objects.isNull(nome) && Objects.isNull(cognome)==false) {
            //filtro per cognome
            for(Impiegato imp: this.getListaImpiegati()) {
                if(imp.getCognome().contains(cognome))
                    lista.add(imp);
            }
        } else if (Objects.isNull(nome)==false && Objects.isNull(cognome)) {
            //filtro per nome
            for(Impiegato imp: this.getListaImpiegati()) {
                if(imp.getNome().contains(nome))
                    lista.add(imp);
            }
        } else {
            //filtro per nome e cognome
            for(Impiegato imp: this.getListaImpiegati()) {
                if(imp.getCognome().contains(cognome) && imp.getNome().contains(nome))
                    lista.add(imp);
            }
        }
        return lista;
    }

}
