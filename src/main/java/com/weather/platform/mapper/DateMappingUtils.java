package com.weather.platform.mapper;

import static java.time.ZoneOffset.UTC;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Optional;

public class DateMappingUtils {

    public static Instant toLocalDate(final ZonedDateTime zonedDateTime) {
        if (Optional.ofNullable(zonedDateTime).isEmpty()) {
            return null;
        }
        return zonedDateTime.toInstant();
    }

    public static ZonedDateTime toZonedDateTime(final Instant instant) {
        if (Optional.ofNullable(instant).isEmpty()) {
            return null;
        }
        return instant.atZone(UTC);
    }
}
