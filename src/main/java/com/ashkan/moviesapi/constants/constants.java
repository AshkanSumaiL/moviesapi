package com.ashkan.moviesapi.constants;

import java.util.Arrays;
import java.util.List;

public final class constants {
    public static final Long DAYS = (long) 3;
    public static final Long DAYS_TO_ADD = (long) (DAYS * 24 * 60 * 60 * 1000);
    public static final List<String> Rates = Arrays.asList(
            "G",
            "PG",
            "PG-13",
            "R",
            "NC-17"
    );
}
