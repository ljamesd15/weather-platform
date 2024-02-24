package com.weather.platform.utils;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class MongoHelper {

    private static final String PREFIX_SEARCH_FORMAT = "^%s.*";
    private static final long MONGO_OFFSET_MILLIS = 3600000L;
    public static final Instant MIN_MONGO_TIME =
            new Date(Long.MIN_VALUE + MONGO_OFFSET_MILLIS).toInstant();
    public static final Instant MAX_MONGO_TIME =
            new Date(Long.MAX_VALUE - MONGO_OFFSET_MILLIS).toInstant();

    public String prefixSearchForString(final String query) {
        final String sanitizedQuery = Optional.ofNullable(query)
                .map(this::sanitizeQueryForRegex)
                .orElse("");
        return PREFIX_SEARCH_FORMAT.formatted(sanitizedQuery);
    }

    private String sanitizeQueryForRegex(final String query) {
        return query.replaceAll("[-.\\+*?\\[^\\]$(){}=!<>|:\\\\]", "\\\\$0");
    }
}
