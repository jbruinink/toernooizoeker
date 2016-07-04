package nl.toernooizoeker;

import org.immutables.value.Value;

@Value.Immutable
public interface Locatie {
    @Value.Parameter
    Double lat();
    @Value.Parameter
    Double getLong();
}
