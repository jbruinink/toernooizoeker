package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.PDFTableProcessor;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

import java.util.List;

public abstract class OperatorProcessor {
    protected final PDFTableProcessor processor;

    protected OperatorProcessor(PDFTableProcessor processor) {
        this.processor = processor;
    }

    public abstract void process(Operator operator, List<COSBase> operands);
}
