package nl.toernooizoeker.pdfimport;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum ColumnName {
    WEEK("Week"),
    DATUM("Datum"),
    NUMMER("Toernooinr."),
    NAAM("Toernooi"),
    ACCOMODATIE("Accomodatie"),
    CATEGORIEN("Toernooicategorieen"),
    INSCHRIJFADRES("Toernooi inschrijfadres"),
    BONDSGEDELEGEERDE("Bondsgedelegeerde");

    private final String naam;

    ColumnName(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public static Optional<ColumnName> fromNaam(String naam) {
        return Arrays.stream(values()).filter(columnName -> columnName.naam.equals(naam)).findAny();
    }
}
