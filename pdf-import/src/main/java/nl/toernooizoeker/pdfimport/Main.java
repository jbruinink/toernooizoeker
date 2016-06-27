package nl.toernooizoeker.pdfimport;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new PDFTableProcessor(new File("src/main/resources/knltb-zomerkalender-district-rotterdam-2016.pdf")).initColumns();
    }
}
