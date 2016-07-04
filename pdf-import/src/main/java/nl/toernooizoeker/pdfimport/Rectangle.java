package nl.toernooizoeker.pdfimport;

import org.immutables.value.Value;

@Value.Immutable
public interface Rectangle {
    @Value.Parameter
    int x();
    @Value.Parameter
    int y();
    @Value.Parameter
    int width();
    @Value.Parameter
    int height();

    static Rectangle of(int x, int y, int width, int height) {
        return ImmutableRectangle.of(x, y, width, height);
    }
}
