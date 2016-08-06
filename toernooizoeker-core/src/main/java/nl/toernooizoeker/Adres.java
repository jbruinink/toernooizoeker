package nl.toernooizoeker;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface Adres {
    String straat();
    String huisnummer();
    Optional<String> huisnummerToevoeging();
    String plaats();
    Postcode postcode();
    Locatie locatie();
}
