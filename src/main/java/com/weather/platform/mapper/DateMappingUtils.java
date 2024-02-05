package com.weather.platform.mapper;

import static java.time.ZoneOffset.UTC;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

public class DateMappingUtils {

    public static LocalDateTime toLocalDate(final ZonedDateTime zonedDateTime) {
        if (Optional.ofNullable(zonedDateTime).isEmpty()) {
            return null;
        }
        return zonedDateTime.toLocalDateTime();
    }

    public static ZonedDateTime toZonedDateTime(final LocalDateTime localDateTime) {
        if (Optional.ofNullable(localDateTime).isEmpty()) {
            return null;
        }
        return localDateTime.atZone(UTC);
    }
}
