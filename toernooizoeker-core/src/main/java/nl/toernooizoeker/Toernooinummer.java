package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Toernooinummer implements Wrapper<String> {

    public static Toernooinummer of(String value) {
        return ImmutableToernooinummer.of(value);
    }
}
