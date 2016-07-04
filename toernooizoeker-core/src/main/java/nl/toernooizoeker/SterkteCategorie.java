package nl.toernooizoeker;

import java.time.LocalDate;

public class SterkteCategorie implements ToernooiCategorie {
    @Override
    public boolean accepteert(LocalDate toernooiDatum, Persoon persoon) {
        return accepteert(persoon.speelsterkte());
    }

    private boolean accepteert(Speelsterkte speelsterkte) {
        //TODO: implement this
        return false;
    }
}
