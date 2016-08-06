package nl.toernooizoeker;

import org.immutables.value.Value;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@Value.Immutable
public interface Persoon {
    String voornaam();
    String achternaam();
    Adres adres();
    Telefoonnummer telefoonnummer();
    Emailadres emailadres();
}
