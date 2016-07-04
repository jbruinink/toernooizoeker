package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Emailadres {
    @Value.Parameter
    abstract String value();

    public static Emailadres of (String value) {
        return ImmutableEmailadres.of(value);
    }
}
