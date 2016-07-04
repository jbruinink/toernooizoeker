package nl.toernooizoeker;

import org.immutables.value.Value;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@Value.Immutable
public interface Persoon {
    String voornaam();
    String achternaam();
    Geslacht geslacht();
    Adres adres();
    Telefoonnummer telefoonnummer();
    Emailadres emailadres();
    LocalDate geboortedatum();

    Speelsterkte speelsterkte();
}
