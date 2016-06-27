package nl.toernooizoeker.pdfimport;

import nl.toernooizoeker.pdfimport.operator.*;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PDFTableProcessor {

    private final HashMap<String, OperatorProcessor> operators;
    private PDFStreamParser parser;
    private final Iterator<PDPage> pageIterator;
    private boolean record;
    private StringBuilder builder;
    private COSRectangle rectangle;
    private COSRectangle clippingRectangle;

    public PDFTableProcessor(File pdfFile) throws IOException {
        operators = new HashMap<>();
        builder = new StringBuilder();
        operators.put("BDC", new BeginMarkedContentSequenceWithProperties(this));
        operators.put("EMC", new EndMarkedContentSequence(this));
        operators.put("re", new AppendRectangleToPath(this));
        operators.put("TJ", new ShowTextAdjusted(this));
        operators.put("W*", new ClipEvenOddRule(this));

        pageIterator = PDDocument.load(pdfFile).getPages().iterator();
        if(!pageIterator.hasNext()) {
            throw new PdfReaderException("There are no pages in this PDF document");
        }
        parser = new PDFStreamParser(pageIterator.next());
        initColumns();
    }

    public void initColumns() throws IOException {
        processOperators();
    }

    public void processOperators() throws IOException {
        List<COSBase> operands = new ArrayList<>();
        for(Object token = parser.parseNextToken(); token != null; token = parser.parseNextToken()) {
            if (token instanceof COSObject)
            {
                operands.add(((COSObject) token).getObject());
            }
            else if (token instanceof Operator)
            {
                processOperator((Operator) token, operands);
                operands.clear();
            }
            else
            {
                operands.add((COSBase) token);
            }
        }
    }

    private void processOperator(Operator operator, List<COSBase> operands) {
        OperatorProcessor processor = operators.get(operator.getName());
        if(processor != null) {
            processor.process(operator, operands);
        } else {
            //System.out.printf("Unsupported: %s%n", operator.getName());
        }
    }

    public void beginMarkedContent(COSName tag, COSDictionary properties) {
        if(tag.getName().equals("P")) {
            record = true;
        }
    }

    public void endMarkedContentSequence() {
        String recorded = builder.toString().trim();
        if(recorded.length() > 0) {
            System.out.printf(" ClipRect: %d, %d, %d, %d: ", clippingRectangle.getX().intValue(), clippingRectangle.getY().intValue(),
                    clippingRectangle.getWidth().intValue(), clippingRectangle.getHeight().intValue());
            System.out.println(recorded);
            builder.setLength(0);
        }
    }

    public void showText(String text) {
        if(record) {
            builder.append(text);
        }
    }

    public void appendRectangleToPath(COSRectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void clipEvenOddRule() {
        this.clippingRectangle = rectangle;
    }
}
