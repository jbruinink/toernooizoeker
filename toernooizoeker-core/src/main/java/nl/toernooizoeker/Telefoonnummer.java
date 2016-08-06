package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Telefoonnummer implements Wrapper<String>{
    public static Telefoonnummer of(String value) {
        return ImmutableTelefoonnummer.of(value);
    }
}
