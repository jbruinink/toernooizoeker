package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.PDFTableProcessor;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

import java.util.List;

public class BeginMarkedContentSequenceWithProperties extends OperatorProcessor {


    public BeginMarkedContentSequenceWithProperties(PDFTableProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Operator operator, List<COSBase> operands) {
        COSName tag = (COSName) operands.get(0);
        COSDictionary dictionary = (COSDictionary) operands.get(1);
        processor.beginMarkedContent(tag, dictionary);
    }
}
