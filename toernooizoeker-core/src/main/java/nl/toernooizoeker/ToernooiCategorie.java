package nl.toernooizoeker;

import java.time.LocalDate;

public interface ToernooiCategorie {
    boolean accepteert(LocalDate toernooiDatum, Persoon persoon);
}
