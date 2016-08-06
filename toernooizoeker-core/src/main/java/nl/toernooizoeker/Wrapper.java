package nl.toernooizoeker;

import org.immutables.value.Value;

public interface Wrapper<T> {
    @Value.Parameter
    T value();
}
