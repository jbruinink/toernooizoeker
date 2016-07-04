package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Bondsnummer {
    private static final long MAX_BONDSNUMMER = 99999999;

    abstract long value();

    public static Bondsnummer of(long value) {
        if(value < 0 || value > MAX_BONDSNUMMER) {
            throw new IllegalArgumentException(String.format("Bondsnummer moet tussen 0 en %d zijn", MAX_BONDSNUMMER));
        } else {
            return ImmutableBondsnummer.of(value);
        }
    }
}
