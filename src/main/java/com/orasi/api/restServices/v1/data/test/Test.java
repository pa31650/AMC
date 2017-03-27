package com.orasi.api.restServices.v1.data.test;

import com.orasi.api.restServices.core.Headers.HeaderType;
import com.orasi.api.restServices.core.RestResponse;
import com.orasi.api.restServices.core.RestService;
import com.orasi.api.restServices.v1.VersionOne;

public class Test {
    private String resource = "/Test";
    private String testId = null;
    
    public Test(String parent){
	resource = parent + resource;
    }

    public Test(String parent, String testId){
	this.resource = parent + resource;
	this.testId = testId;
    }
    
    public RestResponse updateStatus(String status){
	String v1Status = null;
	if(status.equalsIgnoreCase("passed")) v1Status = "TestStatus:129" ;
	else v1Status = "TestStatus:155" ;
	
	String xml = "<Asset id=\"Test:" + testId + "\"> <Relation act=\"set\" name=\"Status\">  <Asset idref=\""+v1Status+"\"/>    </Relation></Asset>";
	
	RestService rest = new RestService();
	return rest.sendPostRequest(VersionOne.baseUrl + resource + "/" + testId, HeaderType.V1, xml);	
    }
}
