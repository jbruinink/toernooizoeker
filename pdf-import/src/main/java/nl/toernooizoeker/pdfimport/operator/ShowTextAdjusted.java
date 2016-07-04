package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.TableCellIterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;

import java.util.List;

public class ShowTextAdjusted extends OperatorProcessor {
    public ShowTextAdjusted(TableCellIterator processor) {
        super(processor);
    }

    @Override
    public void process(List<COSBase> operands) {
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
