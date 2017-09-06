package com.amc.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.amc.api.showtimes.Showtimes;
import com.amc.api.theatres.Theatres;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AMC {
    public final static String URL = "https://api.amctheatres.com/v2";

    public static Showtimes showtimes() {
        return new Showtimes();
    }

    public static Theatres theatres() {
        return new Theatres();
    }

}