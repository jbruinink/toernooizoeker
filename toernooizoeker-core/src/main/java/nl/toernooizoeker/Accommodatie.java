package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public interface Accommodatie {
    String naam();
    Adres adres();
}
