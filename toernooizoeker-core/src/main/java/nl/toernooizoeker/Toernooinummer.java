package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Toernooinummer {
    @Value.Parameter
    abstract String value();

    public static Toernooinummer of(String value) {
        return ImmutableToernooinummer.of(value);
    }
}
