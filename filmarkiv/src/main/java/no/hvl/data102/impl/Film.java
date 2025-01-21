package no.hvl.data102.impl;

import java.util.Objects;

public class Film {
    @Override
    public int hashCode() {
        return Objects.hash(filmnr, filmskaper, tittel, lansering, sjanger, filmselskap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Film))
            return false;
        Film other = (Film) obj;
        return filmnr == other.filmnr && Objects.equals(filmskaper, other.filmskaper)
                && Objects.equals(tittel, other.tittel) && lansering == other.lansering && sjanger == other.sjanger
                && Objects.equals(filmselskap, other.filmselskap);
    }

    private int filmnr;
    private String filmskaper;
    private String tittel;
    private int lansering;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {};

    public Film(int filmnr, String filmskaper, String tittel, int lansering, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.filmskaper = filmskaper;
        this.tittel = tittel; 
        this.lansering = lansering; 
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    public String getTittel() {
        return tittel;
    }

    public int getLansering() {
        return lansering;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
}
