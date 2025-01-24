package no.hvl.data102.impl;

public enum Sjanger {
    ACTION,
    DRAMA,
    COMEDY,
    HORROR,
    THRILLER, 
    FANTASY, 
    SCIENCE_FICTION, 
    ROMANCE, 
    WAR;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }
}
