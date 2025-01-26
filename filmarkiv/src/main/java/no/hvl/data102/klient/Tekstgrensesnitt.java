package no.hvl.data102.klient;

import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.impl.Film;
import no.hvl.data102.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(int filmNr, Scanner obj, FilmarkivADT t) {
        //Tolker oppgaven som å lese inn info til å opprette en film i arkivet

        System.out.println("Hva heter filmen?");
        String filmNavn = obj.nextLine();

        System.out.println("Hva heter film skaperen?");
        String filmSkaper = obj.nextLine();

        System.out.println("Hva år ble den lansert?");
        int årstall = obj.nextInt();
        obj.nextLine(); 

        System.out.println("Hvilke sjanger er den?");
        Sjanger filmSjanger = Sjanger.finnSjanger(obj.nextLine());

        System.out.println("Hva heter film selskapet?");
        String filmSelskap = obj.nextLine();
        
        Film brukerFilm = new Film(filmNr, filmSkaper, filmNavn, årstall, filmSjanger, filmSelskap);

        t.leggTilFilm(brukerFilm);
        
        System.out.println("Film lagt til");
        return brukerFilm;
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.printf("%-12s : %d\n", "Film ID", film.getFilmnr());
        System.out.printf("%-12s : %s\n", "Regissør", film.getFilmskaper());
        System.out.printf("%-12s : %s\n", "Tittel", film.getTittel());
        System.out.printf("%-12s : %d\n", "År", film.getLansering());
        System.out.printf("%-12s : %s\n", "Sjanger", (film.getSjanger()).toString());
        System.out.printf("%-12s : %s\n", "Filmselskap", film.getFilmselskap());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] sammeTittelFilmer = arkiv.soekTittel(delstreng);
        System.out.print("Det er " + sammeTittelFilmer.length + " filmer som har " + delstreng + " i tittelen.\nDe er : ");
        for (Film f : sammeTittelFilmer) { 
            System.out.print("" + f.getTittel() + ", ");
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] sammeProdusentFilmer = arkiv.soekProdusent(delstreng);
        System.out.print("Det er " + sammeProdusentFilmer.length + " filmer som har samme produsent som " + delstreng + " .\nDe er : ");
        for (Film f : sammeProdusentFilmer) { 
            System.out.print("" + f.getFilmskaper() + ", ");
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        int totAntall = arkiv.antall();
        System.out.println("Det er totalt " + totAntall + " filmer i arkivet");

        Sjanger[] sjangTab = Sjanger.values();

        for (int i = 0; i < sjangTab.length; i++) {
            int lengde = arkiv.antall(sjangTab[i]);
            System.out.println("Sjangeren: " + sjangTab[i] + " har " + lengde + " filmer under seg");
        }
    }

    public void delMovie(int nummer, FilmarkivADT arkiv) {
        System.out.println(arkiv.slettFilm(nummer));
    }
    // osv ... andre metoder
    
}
