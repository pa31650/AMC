package com.orasi;

import static com.orasi.utils.TestReporter.log;
import static com.orasi.utils.TestReporter.logTrace;
import static org.apache.commons.lang3.BooleanUtils.toBooleanObject;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.orasi.utils.TestReporter;

public class BaseTest {
    private String environment;
    private String runLocation;
    private String testName;
    private boolean reportToMustard = false;

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "environment", "runLocation", "logLevel", "reportToMustard" })
    public void beforeSuite(@Optional String environment, @Optional String runLocation, @Optional String logLevel, @Optional String reportToMustard) {

        if (isNotEmpty(logLevel)) {
            log("Setting Test Reporter log level to [ " + logLevel + " ]");
            TestReporter.setDebugLevel(determineLogLevel(logLevel));
        }
        logTrace("Entering BaseTest#setup");

        if (isNotEmpty(environment)) {
            log("Setting parameter [ environment ] to [ " + environment + " ]");
            this.environment = environment;
        } else {
            log("Parameter [ environment ] was not set or empty");
        }

        if (isNotEmpty(runLocation)) {
            log("Setting parameter [ runLocation ] to [ " + runLocation + " ]");
            setRunLocation(runLocation);
        } else {
            log("Parameter [ runLocation ] was not set or empty");
        }

        if (isNotEmpty(reportToMustard)) {
            log("Setting parameter [ reportToMustard ] to [ " + reportToMustard + " ]");
            this.reportToMustard = toBooleanObject(reportToMustard);
        } else {
            log("Parameter [ reportToMustard ] was not set or empty");
        }

        logTrace("Exiting BaseTest#setup");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method testMethod, Object[] testParams) {
        logTrace("Entering BaseTest#beforeMethod");
        testName = testMethod.getDeclaringClass().getSimpleName() + "#" + testMethod.getName();
        log("Starting test [ " + testName + " ]");

        int id = 1;
        for (Object param : Arrays.asList(testParams)) {
            log("Test parameter [ " + id + " ] value [ " + param.toString() + " ]");
            id++;
        }
    }

    protected void setRunLocation(String runLocation) {
        if (runLocation.equalsIgnoreCase("jenkinsParameter")) {
            this.runLocation = System.getProperty("jenkinsRunLocation".trim());
        } else {
            this.runLocation = runLocation;
        }
    }

    public String getRunLocation() {
        return runLocation;
    }

    protected void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    protected void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    protected void setReportToMustard(boolean reportToMustard) {
        this.reportToMustard = reportToMustard;
    }

    public boolean getReportToMustard() {
        return reportToMustard;
    }

    private int determineLogLevel(String level) {
        switch (level.toUpperCase()) {
            case "1":
            case "INFO":
                return 1;

            case "2":
            case "DEBUG":
                return 2;

            case "3":
            case "TRACE":
                return 3;

            default:
                return 0;
        }
    }
}
