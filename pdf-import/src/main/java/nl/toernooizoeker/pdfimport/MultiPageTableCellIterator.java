package nl.toernooizoeker.pdfimport;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.Iterator;

public class MultiPageTableCellIterator implements Iterator<TableCell> {

    private final Iterator<? extends PDContentStream> pageIterator;
    private Iterator<TableCell> iterator;

    public MultiPageTableCellIterator(Iterator<? extends PDContentStream> pageIterator) throws IOException {
        this.pageIterator = pageIterator;
        if(pageIterator.hasNext()) {
            iterator = new TableCellIterator(new PDFStreamParser(pageIterator.next()));
        }
        findNext();
    }

    private void findNext() {
        while(!iterator.hasNext() && pageIterator.hasNext()) {
            try {
                iterator = new TableCellIterator(new PDFStreamParser(pageIterator.next()));
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public TableCell next() {
        TableCell next = iterator.next();
        findNext();
        return next;
    }
}
