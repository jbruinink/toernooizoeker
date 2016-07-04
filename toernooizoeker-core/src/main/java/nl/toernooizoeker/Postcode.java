package nl.toernooizoeker;

import org.immutables.value.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Value.Immutable
public abstract class Postcode {
    private static final Pattern POSTCODE_PATTERN = Pattern.compile("^(\\d{4})\\s*([a-zA-Z]{2})$");

    @Value.Parameter
    abstract String value();

    public static Postcode of(String value) {
        Matcher matcher = POSTCODE_PATTERN.matcher(value);
        if(matcher.find()) {
            return ImmutablePostcode.of(matcher.group(0) + " " + matcher.group(1));
        } else {
            throw new IllegalArgumentException("Unable to create Postcode from: '" + value + "'");
        }
    }

    public String toString() {
        return value();
    }
}
