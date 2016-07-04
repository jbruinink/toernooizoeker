package nl.toernooizoeker;

import org.immutables.value.Value;

import java.time.LocalDate;
import java.util.List;

@Value.Immutable
public interface Toernooi {
    String naam();
    Toernooinummer toernooinummer();
    LocalDate startDatum();
    LocalDate eindDatum();
    Accommodatie accommodatie();
    List<ToernooiCategorie> categorien();
    Persoon inschrijfAdres();
    Persoon bondsGedelegeerde();
}
