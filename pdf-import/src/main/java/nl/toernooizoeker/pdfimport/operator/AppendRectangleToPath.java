package nl.toernooizoeker.pdfimport.operator;

import nl.toernooizoeker.pdfimport.COSRectangle;
import nl.toernooizoeker.pdfimport.PDFTableProcessor;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

import java.util.List;

public class AppendRectangleToPath extends OperatorProcessor {
    public AppendRectangleToPath(PDFTableProcessor processor) {
        super(processor);
    }

    @Override
    public void process(Operator operator, List<COSBase> operands) {
        COSNumber x = (COSNumber) operands.get(0);
        COSNumber y = (COSNumber) operands.get(1);
        COSNumber width = (COSNumber) operands.get(2);
        COSNumber height = (COSNumber) operands.get(3);
        processor.appendRectangleToPath(new COSRectangle(x, y, width, height));
    }
}
