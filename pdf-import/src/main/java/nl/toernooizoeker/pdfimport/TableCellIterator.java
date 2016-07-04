package nl.toernooizoeker.pdfimport;

import nl.toernooizoeker.pdfimport.operator.*;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.pdfparser.PDFStreamParser;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class TableCellIterator implements Iterator<TableCell>{

    private final HashMap<String, OperatorProcessor> operators;
    private PDFStreamParser parser;
    private boolean record;
    private StringBuilder markedContent;
    private Rectangle rectangle;
    private Rectangle clippingRectangle;
    private List<String> cellText;
    private TableCell next;

    public TableCellIterator(PDFStreamParser parser) throws IOException {
        this.parser = parser;
        markedContent = new StringBuilder();
        cellText = new ArrayList<>();
        operators = new HashMap<>();
        operators.put("BDC", new BeginMarkedContentSequenceWithProperties(this));
        operators.put("EMC", new EndMarkedContentSequence(this));
        operators.put("re", new AppendRectangleToPath(this));
        operators.put("TJ", new ShowTextAdjusted(this));
        operators.put("W*", new ClipEvenOddRule(this));
        processNext();
    }

    private void processNext() {
        List<COSBase> operands = new ArrayList<>();
        Object token = nextToken();
        while(token != null && next == null) {
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
            token = nextToken();
        }
    }

    private Object nextToken() {
        try {
            return parser.parseNextToken();
        } catch (IOException e) {
            return null;
        }
    }

    private void processOperator(Operator operator, List<COSBase> operands) {
        OperatorProcessor processor = operators.get(operator.getName());
        if(processor != null) {
            processor.process(operands);
        }
    }

    public void beginMarkedContent(COSName tag) {
        if(tag.getName().equals("P")) {
            record = true;
        } else {
            record = false;
        }
    }

    public void endMarkedContentSequence() {
        String recorded = markedContent.toString().trim();
        if (recorded.length() > 0) {
            cellText.add(recorded);
        }
        markedContent.setLength(0);
    }

    public void showText(String text) {
        if(record) {
            markedContent.append(text);
        }
    }

    public void appendRectangleToPath(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void clipEvenOddRule() {
        if(!Objects.equals(clippingRectangle, rectangle) && cellText.size() > 0) {
            next = TableCell.of(clippingRectangle, cellText);
            cellText.clear();
        }
        this.clippingRectangle = rectangle;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public TableCell next() {
        TableCell result = next;
        next = null;
        processNext();
        return result;
    }
}
