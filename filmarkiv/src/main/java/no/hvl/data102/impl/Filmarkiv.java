package no.hvl.data102.impl;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{
    private int antallFilmer; 
    private Film[] filmarkiv;

    public Filmarkiv(int antallFilmer) {
        this.antallFilmer = 0;
        this.filmarkiv = new Film[antallFilmer];        
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : filmarkiv) {
            if (film.getFilmnr() == nr) {
                return film;
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (filmarkiv.length == antallFilmer) {
            utvidFilmArkiv();
        }
        filmarkiv[antallFilmer] = nyFilm;
        antallFilmer++;
    }

    private void utvidFilmArkiv() {
        Film[] nytabell = new Film[filmarkiv.length*2];
        for (int i = 0; i < filmarkiv.length; i++) {
            nytabell[i] = filmarkiv[i];
        }
        filmarkiv = nytabell;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        Film film = finnFilm(filmnr);
        if (film != null) {
            for (int i = 0; i < antallFilmer; i++) {
                if (filmarkiv[i] == film) {
                    for (int j = i; j < antallFilmer - 1; j++) { 
                        filmarkiv[j] = filmarkiv[j + 1];
                    }
                    filmarkiv[antallFilmer - 1] = null; 
                    antallFilmer--;
                    return true;
                }
            }
        }
        return false;
    }
    //De to metodene under kunne hatt en egen metode for å "korte ned" tabellene.
    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] sokteTitler = new Film[antallFilmer];
        int index = 0;
        for (Film film : filmarkiv) {
            if (film != null && film.getTittel().contains(delstreng)) {
                sokteTitler[index] = film;
                index++;
            }
        }
        Film[] onlyMatching = new Film[index];

        for (int i = 0; i < index; i++) {
            onlyMatching[i] = sokteTitler[i];
        }
        return onlyMatching;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] sokteTitler = new Film[antallFilmer];
        int index = 0;
        for (Film film : filmarkiv) {
            if (film != null && film.getFilmskaper().contains(delstreng)) {
                sokteTitler[index] = film;
                index++;
            }
        }
        Film[] onlyMatching = new Film[index];

        for (int i = 0; i < index; i++) {
            onlyMatching[i] = sokteTitler[i];
        }
        return onlyMatching;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;
        for (Film film : filmarkiv) {
            if (film != null && film.getSjanger().equals(sjanger)) {  
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        return antallFilmer;
    };

    public int getFilmArkivLengde() {
        return filmarkiv.length;
    }

}
