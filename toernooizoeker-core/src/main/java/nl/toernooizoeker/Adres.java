package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public interface Adres {
    String straat();
    String huisnummer();
    String huisnummerToevoeging();
    String plaats();
    Postcode postcode();
    Locatie locatie();
}
