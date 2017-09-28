package com.amc.api;

import com.orasi.api.restServices.BaseRestTest;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class BaseAPI extends BaseRestTest{

    public RestResponse sendGet(String url) {
        RestService rest = new RestService();
        return rest.sendGetRequest(url, HeaderType.AMC);
    }
	
}
