package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.TableCellIterator;
import org.apache.pdfbox.cos.COSBase;

import java.util.List;

public abstract class OperatorProcessor {
    protected final TableCellIterator processor;

    protected OperatorProcessor(TableCellIterator processor) {
        this.processor = processor;
    }

    public abstract void process(List<COSBase> operands);
}
