package no.hvl.data102.klient;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.impl.Film;
import no.hvl.data102.impl.Sjanger;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        Film film1 = new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros");
        Film film2 = new Film(2, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures");
        Film film3 = new Film(3, "James Cameron", "Avatar", 2009, Sjanger.ACTION, "20th Century Fox");
        Film film4 = new Film(4, "Peter Jackson", "The Lord of the Rings: The Fellowship of the Ring", 2001, Sjanger.FANTASY, "New Line Cinema");
        Film film5 = new Film(5, "Quentin Tarantino", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax");
        Film film6 = new Film(6, "Francis Ford Coppola", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures");
        Film film7 = new Film(7, "Ridley Scott", "Gladiator", 2000, Sjanger.ACTION, "DreamWorks");
        Film film8 = new Film(8, "Christopher Nolan", "The Dark Knight", 2008, Sjanger.ACTION, "Warner Bros");
        Film film9 = new Film(9, "David Fincher", "Fight Club", 1999, Sjanger.DRAMA, "20th Century Fox");
        Film film10 = new Film(10, "George Lucas", "Star Wars: Episode IV - A New Hope", 1977, Sjanger.SCIENCE_FICTION, "Lucasfilm");
        Film film11 = new Film(11, "James Cameron", "Titanic", 1997, Sjanger.ROMANCE, "Paramount Pictures");
        Film film12 = new Film(12, "Robert Zemeckis", "Forrest Gump", 1994, Sjanger.DRAMA, "Paramount Pictures");
        Film film13 = new Film(13, "Christopher Nolan", "Interstellar", 2014, Sjanger.SCIENCE_FICTION, "Paramount Pictures");
        Film film14 = new Film(14, "Alfred Hitchcock", "Psycho", 1960, Sjanger.HORROR, "Paramount Pictures");
        Film film15 = new Film(15, "Martin Scorsese", "The Wolf of Pulp Wall Street", 2013, Sjanger.DRAMA, "Paramount Pictures");
        Film film16 = new Film(16, "Peter Jackson", "The Pulp Hobbit: An Unexpected Journey", 2012, Sjanger.FANTASY, "New Line Cinema");
        Film film17 = new Film(17, "Stanley Kubrick", "The Shining", 1980, Sjanger.HORROR, "Warner Bros");
        Film film18 = new Film(18, "Tim Burton", "Edward Scissorhands", 1990, Sjanger.FANTASY, "20th Century Fox");
        Film film19 = new Film(19, "Jon Favreau", "Iron Man", 2008, Sjanger.ACTION, "Marvel Studios");
        Film film20 = new Film(20, "Christopher Nolan", "DunkPulpirk", 2017, Sjanger.WAR, "Warner Bros");
        Film film21 = new Film(21, "Steven Spielberg", "Schindler's List", 1993, Sjanger.DRAMA, "Universal Pictures");
        Film film22 = new Film(22, "George Miller", "PulpMad Max: Fury Road", 2015, Sjanger.ACTION, "Warner Bros");
        Film film23 = new Film(23, "Sam Raimi", "Spider-Man", 2002, Sjanger.ACTION, "Sony Pictures");
        Film film24 = new Film(24, "The Wachowskis", "The Matrix", 1999, Sjanger.SCIENCE_FICTION, "Warner Bros");
        Film film25 = new Film(25, "James Wan", "The Pulp Conjuring", 2013, Sjanger.HORROR, "Warner Bros");
        Film film26 = new Film(26, "Christopher Nolan", "The Prestige", 2006, Sjanger.DRAMA, "Warner Bros");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        filmarkiv.leggTilFilm(film7);
        filmarkiv.leggTilFilm(film8);
        filmarkiv.leggTilFilm(film9);
        filmarkiv.leggTilFilm(film10);
        filmarkiv.leggTilFilm(film11);
        filmarkiv.leggTilFilm(film12);
        filmarkiv.leggTilFilm(film13);
        filmarkiv.leggTilFilm(film14);
        filmarkiv.leggTilFilm(film15);
        filmarkiv.leggTilFilm(film16);
        filmarkiv.leggTilFilm(film17);
        filmarkiv.leggTilFilm(film18);
        filmarkiv.leggTilFilm(film19);

        // int filmnret = filmarkiv.antall() + 1;

        // tekstgr.skrivUtStatistikk(filmarkiv);
        

    Scanner obj = new Scanner(System.in);
    boolean ActiveUser = true;

    while (ActiveUser) {
        valgMeny();
        System.out.println("Skriv hva du vil gjøre med nummeret valgt");
        String valg = obj.nextLine().trim();
        ActiveUser = brukerValg(valg, obj);
    }
    obj.close();
}

public void valgMeny() {
    System.out.println("1:. Legg til din egen film i film arkivet");
    System.out.println("2:. Velg en film du vil ha informasjon om");
    System.out.println("3:. Skriv ut alle filmer som har en valgt tekst i tittelen");
    System.out.println("4:. Skriv ut alle filmer fra en produsent du velger");
    System.out.println("5:. Skriv ut statistikk om antall filmer i hver sjanger");
    System.out.println("6:. Sletter en film fra arkivet");
    //SKAL BRUKE ALLE METODER FRA FILMARKIV, SLETT OSV
    System.out.println("7:. Exit");
    System.out.println();
}

public boolean brukerValg(String valgtOpperasjon, Scanner obj) {
    switch (valgtOpperasjon) {
        case "1":
            tekstgr.lesFilm(filmarkiv.antall() + 1, obj, filmarkiv);
            break;
        case "2":
            System.out.println("Hvilke filmnummer er filmen");
            int filmrn = obj.nextInt();
            tekstgr.skrivUtFilm(filmarkiv.finnFilm(filmrn));
            break;
        case "3":
            System.out.println("Skriv tittelen på filmen du ønsker");
            String filmDelStr = obj.nextLine();
            tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, filmDelStr);
            break;
        case "4":
            System.out.println("Skriv produsentens navn");
            String filmProdDelstreng = obj.nextLine();
            tekstgr.skrivUtFilmProdusent(filmarkiv, filmProdDelstreng);
            break;
        case "5":
            tekstgr.skrivUtStatistikk(filmarkiv);
            System.out.println();
            break;
        case "6":
            System.out.println("Skriv Filmnummeret på filmen du vil slette");
            //fikk problemer med nextint i noen tilfeller, omgjøre til int i ettkant ser ut som å fungere
            String filmNr = obj.nextLine();
            tekstgr.delMovie(Integer.parseInt(filmNr), filmarkiv);
            break;
        case "7":
            System.out.println("Avslutter...");
            return false; 
        default:
            System.out.println("Ugyldig input, prøv igjen");
            break;
        }
    return true;
    }
}