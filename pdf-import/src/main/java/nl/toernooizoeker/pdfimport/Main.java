package nl.toernooizoeker.pdfimport;

import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/knltb-zomerkalender-district-rotterdam-2016.pdf");
        PDDocument pdDocument = PDDocument.load(file);

        List<Column> columns = new ArrayList<>();
        MultiPageTableCellIterator tableCellIterator = new MultiPageTableCellIterator(pdDocument.getPages().iterator());
        while(tableCellIterator.hasNext()) {
            System.out.println(tableCellIterator.next());
        }
    }
}
