package com.orasi.api.restServices.v1.data;

import com.orasi.api.restServices.v1.data.test.Test;

public class Data {
    private String resource = "/Data";

    public Test test(){
	return new Test(resource);
    }
    
    public Test test(String testId){
	return new Test(resource, testId);
    }
}
