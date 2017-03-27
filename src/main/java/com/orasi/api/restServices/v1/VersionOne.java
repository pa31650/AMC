package com.orasi.api.restServices.v1;

import com.orasi.api.restServices.v1.data.Data;

public class VersionOne {
    public final static String baseUrl = "https://www16.v1host.com/api-examples/rest-1.v1"; 
    public final static String authtoken = "1.aBg7sVXSZeEsf3cwvQFEdkkt384=";
    
    public static Data data(){
	return new Data();
    }
}
