package com.orasi.utils.io;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orasi.api.restServices.helpers.TestDataInput;
import com.orasi.api.restServices.helpers.testData.TestData;
import com.orasi.utils.exceptions.DataProviderInputFileNotFoundException;
import com.orasi.utils.exceptions.FailedToMapJsonException;
import com.orasi.utils.exceptions.InvalidFileException;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class TestJsonHelper {
    @Features("Utils")
    @Stories("JsonHelper")
    @Title("readJsonFromFile")
    @Test
    public void readJsonFromFile() {
        Assert.assertNotNull(JsonHelper.readJsonFromFile("/json/sample.json", TestDataInput.class));
    }

    @Features("Utils")
    @Stories("readJsonFromFile")
    @Title("readJsonFromFile")
    @Test(expectedExceptions = DataProviderInputFileNotFoundException.class)
    public void readJsonFromFileMissingJson() {
        Assert.assertNotNull(JsonHelper.readJsonFromFile("/json/blah.json", TestDataInput.class));
    }

    @Features("Utils")
    @Stories("readJsonFromFile")
    @Title("readJsonFromFile")
    @Test(expectedExceptions = InvalidFileException.class)
    public void readJsonFromFileInvalidJson() {
        Assert.assertNotNull(JsonHelper.readJsonFromFile("/excelsheets/TestData_xls.xls", TestDataInput.class));
    }

    @Features("Utils")
    @Stories("readJsonFromFile")
    @Title("readJsonFromFile")
    @Test(expectedExceptions = FailedToMapJsonException.class)
    public void readJsonFromFileFailedtoMapJson() {
        Assert.assertNotNull(JsonHelper.readJsonFromFile("/json/sample.json", TestData.class));
    }
}
