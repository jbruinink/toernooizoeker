package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.PDFTableProcessor;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;

import java.util.List;

public class ShowTextAdjusted extends OperatorProcessor {
    public ShowTextAdjusted(PDFTableProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Operator operator, List<COSBase> operands) {
        StringBuilder builder = new StringBuilder();
        COSArray array = (COSArray) operands.get(0);
        for(COSBase operand: array) {
            if(operand instanceof COSString) {
                COSString cosString = (COSString) operand;
                builder.append(cosString.getASCII());
            }
        }
        processor.showText(builder.toString());
    }
}
