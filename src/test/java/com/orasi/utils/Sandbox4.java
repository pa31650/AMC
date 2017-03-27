package com.orasi.utils;

import java.net.MalformedURLException;

import com.versionone.Oid;
import com.versionone.apiclient.Asset;
import com.versionone.apiclient.Attribute;
import com.versionone.apiclient.Query;
import com.versionone.apiclient.Services;
import com.versionone.apiclient.V1Connector;
import com.versionone.apiclient.exceptions.V1Exception;
import com.versionone.apiclient.interfaces.IAssetType;
import com.versionone.apiclient.interfaces.IAttributeDefinition;
import com.versionone.apiclient.interfaces.IServices;
import com.versionone.apiclient.services.QueryResult;

/**
 * Created by Adam on 12/22/2015.
 */
public class Sandbox4 {

    public static void main(String[] args) throws MalformedURLException, V1Exception {
	V1Connector connector = V1Connector
		.withInstanceUrl("https://www16.v1host.com/api-examples")
		.withUserAgentHeader("AppName", "1.0")
		.withAccessToken("1.aBg7sVXSZeEsf3cwvQFEdkkt384=")
		.build();
	IServices services = new Services(connector);

	Oid testId = services.getOid("Test:1056"); // Will be test ID
	Query query = new Query(testId);
	IAssetType testType = services.getMeta().getAssetType("Test");
	IAttributeDefinition nameAttribute = testType.getAttributeDefinition("Status");
	query.getSelection().add(nameAttribute);
	QueryResult result = services.retrieve(query);
	Asset test = result.getAssets()[0];
	String oldName = test.getAttribute(nameAttribute).getValue().toString();
	//test.setAttributeValue(nameAttribute, "TestStatus:155");   // = Failed
	test.setAttributeValue(nameAttribute, "TestStatus:129");   // = Passed
	services.save(test);

	System.out.println(test.getOid().getToken());
	System.out.println(oldName);
	System.out.println(test.getAttribute(nameAttribute).getValue());
    }
    
   
}