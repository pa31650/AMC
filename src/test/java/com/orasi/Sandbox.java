package com.orasi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orasi.utils.dataProviders.JsonDataProvider;

public class Sandbox extends BaseTest {

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return JsonDataProvider.getData("json/sample.json");
    }

    @Test(dataProvider = "dp")
    public void test(String iterationName, String username, String password, String role) {

    }
}
