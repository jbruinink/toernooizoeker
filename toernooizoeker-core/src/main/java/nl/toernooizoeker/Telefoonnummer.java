package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Telefoonnummer {
    @Value.Parameter
    abstract String value();

    public static Telefoonnummer of(String value) {
        return ImmutableTelefoonnummer.of(value);
    }
}
