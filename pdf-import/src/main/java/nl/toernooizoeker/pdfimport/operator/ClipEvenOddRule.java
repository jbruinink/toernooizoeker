package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.TableCellIterator;
import org.apache.pdfbox.cos.COSBase;

import java.util.List;

public class ClipEvenOddRule extends OperatorProcessor {
    public ClipEvenOddRule(TableCellIterator processor) {
        super(processor);
    }

    @Override
    public void process(List<COSBase> operands) {
        processor.clipEvenOddRule();
    }
}
