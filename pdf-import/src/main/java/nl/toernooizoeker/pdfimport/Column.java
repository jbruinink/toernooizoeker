package nl.toernooizoeker.pdfimport;

public class Column {
    private final int x;
    private final int width;

    public Column(int x, int width) {
        this.x = x;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public boolean contains(Rectangle rectangle) {
        return rectangle.x() >= x && (rectangle.x() + rectangle.width() <= (x + width));
    }


}
