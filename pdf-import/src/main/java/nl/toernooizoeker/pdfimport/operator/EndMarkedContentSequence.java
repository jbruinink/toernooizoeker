package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.TableCellIterator;
import org.apache.pdfbox.cos.COSBase;

import java.util.List;

public class EndMarkedContentSequence extends OperatorProcessor {
    public EndMarkedContentSequence(TableCellIterator processor) {
        super(processor);
    }

    @Override
    public void process(List<COSBase> operands) {
        processor.endMarkedContentSequence();
    }
}
