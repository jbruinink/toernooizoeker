package nl.toernooizoeker;

import org.immutables.value.Value;

import java.time.LocalDate;

@Value.Immutable
public abstract class JeugdCategorie implements ToernooiCategorie{
    @Value.Parameter
    abstract int maxLeeftijd();

    @Override
    public boolean accepteert(LocalDate toernooiDatum, Persoon persoon) {
        return toernooiDatum.withMonth(12).withDayOfMonth(31)
                .minusYears(maxLeeftijd())
                .isBefore(persoon.geboortedatum());
    }
}
