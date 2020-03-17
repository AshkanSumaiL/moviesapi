package com.ashkan.moviesapi.constants;

import java.util.Arrays;
import java.util.List;

public final class Constants {
    private static final Long DAYS = (long) 3;
    public static final Long DAYS_TO_ADD = DAYS * 24 * 60 * 60 * 1000;
    public static final List<String> RATES = Arrays.asList(
            "G",
            "PG",
            "PG-13",
            "R",
            "NC-17"
    );

    public enum RESOURCES {
        MOVIES("api/movies/"),
        MEMBERS("api/members/")
        ;

        private final String resource;

        RESOURCES(final String resource) {
            this.resource = resource;
        }

        @Override
        public String toString() {
            return resource;
        }
    }
}
