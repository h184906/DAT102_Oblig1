package no.hvl.data102.impl;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2  implements FilmarkivADT{
    
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> iterasjon = start;

        while (iterasjon != null) {
            if (iterasjon.data.getFilmnr() == nr) {
                return iterasjon.data;
            }
            iterasjon = iterasjon.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm); 

        nyNode.neste = start;
        start = nyNode; 
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> iterasjon = start;
        LinearNode<Film> forgje = null; 

        while (iterasjon != null) {
            if (iterasjon.data.getFilmnr() == filmnr) {
                if (forgje == null) {
                    start = iterasjon.neste;
                } else {
                    forgje.neste = iterasjon.neste;
                }
                antall--;
                return true;
            }
            forgje = iterasjon;
            iterasjon = iterasjon.neste;
        }
        return false;
    }

    @Override
    //tolker oppgave som at vi skal gi ut filmene i en tabell og ikke endre klassene, bare ta i bruk Noder. Så endrer ikke på Film[] slik at tester osv ikke skal endres
    public Film[] soekTittel(String delstreng) {
        //TEST FEILER
        LinearNode<Film> itresjon = start;

        Film[] soekteTittler = new Film[antall];
        
        int index = 0;

        while (itresjon != null) {
            if (itresjon.data.getTittel().contains(delstreng)) {
                soekteTittler[index++] = itresjon.data;
            }
            itresjon = itresjon.neste;
        }

        Film[] onlyMatching = new Film[index];
        System.arraycopy(soekteTittler, 0, onlyMatching, 0, index);
        return onlyMatching;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> itresjon = start;

        Film[] soekteProdusenter = new Film[antall];
        
        int index = 0;

        while (itresjon != null) {
            if (itresjon.data.getFilmskaper().contains(delstreng)) {
                soekteProdusenter[index++] = itresjon.data;
            }
            itresjon = itresjon.neste;
        }

        Film[] onlyMatching = new Film[index];
        System.arraycopy(soekteProdusenter, 0, onlyMatching, 0, index);
        return onlyMatching;
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> iterasjon = start;

        int antallSjanger = 0;

        while (iterasjon != null) {
            if (iterasjon.data.getSjanger().equals(sjanger)) {
                antallSjanger++;
            }
            iterasjon = iterasjon.neste;
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }
    
}
