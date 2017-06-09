package com.orasi.api.restServices.helpers.testData;

import java.util.List;

public class TestData {

    private String iterationName;
    private List<Data> data = null;

    public String getIterationName() {
        return iterationName;
    }

    public void setIterationName(String iterationName) {
        this.iterationName = iterationName;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

}