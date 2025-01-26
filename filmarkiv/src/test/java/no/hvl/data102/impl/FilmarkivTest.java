package no.hvl.data102.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FilmarkivTest {

    // private Filmarkiv filmarkiv;
    private Filmarkiv2 filmarkiv;
    private Film film1;
    private Film film2;
    private Film film3;
    private Film film4;

    
    @Before
    public void setup() {
        
        // filmarkiv = new Filmarkiv(3);
        filmarkiv = new Filmarkiv2();

        
        film1 = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros");
        film2 = new Film(2, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax");
        film3 = new Film(3, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "20th Century Fox");
        film4 = new Film(4, "Moren Tann", "Hodet Pulp", 2017, Sjanger.COMEDY, "Bla Muggost");

        
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
    }

    @Test
    public void testAntallForSjanger() {
        int forventetAntallAction = 2;
        int faktiskAntallAction = filmarkiv.antall(Sjanger.ACTION);
        assertEquals(forventetAntallAction, faktiskAntallAction);
    
        int forventetAntallDrama = 1;
        int faktiskAntallDrama = filmarkiv.antall(Sjanger.DRAMA);
        assertEquals(forventetAntallDrama, faktiskAntallDrama);
    }

    @Test
    public void testAntall2() {
        int forventetAntall = 3;
        int faktiskAntall = filmarkiv.antall();
        assertEquals(forventetAntall, faktiskAntall);
    }

    @Test
    public void testFinnFilm() {
        Film forventetFilm = film2;
        Film faktiskFilm = filmarkiv.finnFilm(2);
        assertEquals(forventetFilm, faktiskFilm);
    }

    @Test
    public void testLeggTilFilm() {
        int forventetLengde = 4;
        filmarkiv.leggTilFilm(film4);
        int faktiskLengde = filmarkiv.antall();
        assertEquals(forventetLengde, faktiskLengde);
    }

    @Test
    public void testSlettFilm() {
        int forventetLengde = 2;
        filmarkiv.slettFilm(2);
        int faktiskLengde = filmarkiv.antall();
        assertEquals(faktiskLengde, forventetLengde);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testSoekProdusent() {
        Film[] forventetSkaperFilmer = new Film[]{film1};
        Film[] faktiskSkaperFilmer = filmarkiv.soekProdusent("Chris");
        assertEquals(forventetSkaperFilmer, faktiskSkaperFilmer);
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testSoekTittel() {
        Film[] forventetFilmer = new Film[]{film2, film4};
        filmarkiv.leggTilFilm(film4);
        Film[] faktiskFilmer = filmarkiv.soekTittel("Pulp");
        assertEquals(forventetFilmer, faktiskFilmer);
    }

    // @Test
    // public void testUtvidFilmArkiv() {
    //     int forventetUtvidelse = 6;
    //     filmarkiv.leggTilFilm(film4);
    //     int faktiskLengden = filmarkiv.getFilmArkivLengde();
    //     assertEquals(faktiskLengden, forventetUtvidelse);

    // }
}
