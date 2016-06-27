package nl.toernooizoeker.pdfimport;

import org.apache.pdfbox.cos.COSNumber;

public class COSRectangle {
    private final COSNumber x;
    private final COSNumber y;
    private final COSNumber width;
    private final COSNumber height;

    public COSRectangle(COSNumber x, COSNumber y, COSNumber width, COSNumber height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public COSNumber getX() {
        return x;
    }

    public COSNumber getY() {
        return y;
    }

    public COSNumber getWidth() {
        return width;
    }

    public COSNumber getHeight() {
        return height;
    }
}
