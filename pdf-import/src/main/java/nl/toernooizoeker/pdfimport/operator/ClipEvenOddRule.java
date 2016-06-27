package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.PDFTableProcessor;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import java.util.List;

public class ClipEvenOddRule extends OperatorProcessor {
    public ClipEvenOddRule(PDFTableProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Operator operator, List<COSBase> operands) {
        processor.clipEvenOddRule();
    }
}
