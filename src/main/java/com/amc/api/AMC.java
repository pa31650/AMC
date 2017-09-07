package com.amc.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.amc.api.v2.showtimes.Showtimes;
import com.amc.api.v2.theatres.Theatres;
import com.amc.api.v2.theatres.showtimes.TheatreShowtimes;
import com.amc.api.v2.common.objects.TicketPrice;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AMC {
    public final static String URL = "https://api.amctheatres.com/";
    public final static String URLv1 = URL + "v1/";
    public final static String URLv2 = URL + "v2/";
    public final static String URLv3 = URL + "v3/";
    
    public static Showtimes showtimes() {
        return new Showtimes();
    }
   
    public static Theatres theatres() {
        return new Theatres();
    }
    
    public static TheatreShowtimes theatreShowtimes() {
        return new TheatreShowtimes();
    }

}