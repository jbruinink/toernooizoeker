package nl.toernooizoeker.pdfimport;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface TableCell {
    @Value.Parameter
    Rectangle rectangle();

    @Value.Parameter
    List<String> content();

    static TableCell of(Rectangle rectangle, List<String> content) {
        return ImmutableTableCell.of(rectangle, content);

    }
}
