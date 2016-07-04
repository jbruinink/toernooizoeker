package nl.toernooizoeker.pdfimport;

import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class MultiPageTableCellIterator implements Iterator<TableCell> {

    private final Iterator<PDPage> pageIterator;
    private Iterator<TableCell> iterator;

    public MultiPageTableCellIterator(Iterable<PDPage> pageIterable) throws IOException {
        this.pageIterator = pageIterable.iterator();
        nextPage();
    }

    private void nextPage() throws IOException {
        if(pageIterator.hasNext()) {
            iterator = new TableCellIterator(new PDFStreamParser(pageIterator.next()));
        } else {
            iterator = Collections.emptyIterator();
        }
    }

    @Override
    public boolean hasNext() {
        if(iterator.hasNext()) {
            return true;
        }
        try {
            nextPage();
        } catch (IOException e) {
            return false;
        }
        return hasNext();
    }

    @Override
    public TableCell next() {
        return null;
    }
}
