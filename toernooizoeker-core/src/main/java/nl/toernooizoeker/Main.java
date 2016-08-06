package nl.toernooizoeker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        new Main().start();
    }

    private void start() throws JsonProcessingException {
        Toernooi toernooi = ImmutableToernooi.builder()
                .naam("Toernooinaam")
                .toernooinummer(Toernooinummer.of("12345"))
                .startDatum(LocalDate.now())
                .eindDatum(LocalDate.now().plusWeeks(1))
                .bondsGedelegeerde(ImmutablePersoon.builder()
                        .achternaam("Gedelegeerde")
                        .voornaam("Bonds")
                        .adres(ImmutableAdres.builder()
                                .straat("Gedelegeerde Straat")
                                .huisnummer("17")
                                .postcode(Postcode.of("2222BB"))
                                .plaats("Gedelegeerde Plaats")
                                .locatie(ImmutableLocatie.of(37d, 41d))
                                .build())
                        .telefoonnummer(Telefoonnummer.of("0101234567"))
                        .emailadres(Emailadres.of("username@example.com"))
                        .build())
                .inschrijfAdres(ImmutablePersoon.builder()
                        .achternaam("Adres")
                        .voornaam("Inschrijf")
                        .adres(ImmutableAdres.builder()
                                .straat("Inschrijf Straat")
                                .huisnummer("23")
                                .postcode(Postcode.of("3333CC"))
                                .plaats("Inschrijf Plaats")
                                .locatie(ImmutableLocatie.of(43d, 51d))
                                .build())
                        .telefoonnummer(Telefoonnummer.of("0107654321"))
                        .emailadres(Emailadres.of("someone@example.com"))
                        .build())
                .accommodatie(ImmutableAccommodatie.builder()
                        .naam("Naam Accommodatie")
                        .adres(ImmutableAdres.builder()
                                .straat("Accomodatie Straat")
                                .huisnummer("1")
                                .postcode(Postcode.of("1234AB"))
                                .plaats("Accomodatie Plaats")
                                .locatie(ImmutableLocatie.of(7d, 13d))
                                .build())
                        .build())
                .build();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(toernooi));
    }
}
