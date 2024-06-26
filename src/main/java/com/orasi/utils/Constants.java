package com.orasi.utils;

import java.io.File;

import org.slf4j.impl.StaticMDCBinder;

public class Constants {

    /*
     * File system info
     */
    public final static String DIR_SEPARATOR = File.separator;
    public final static String CURRENT_DIR = determineCurrentPath();

    /*
     * Selenium Constants
     */
    public final static String DRIVERS_PATH_LOCAL = "/drivers/";
    public final static String DRIVERS_PATH_REMOTE = "C:\\Selenium\\WebDrivers\\";
    public final static String SCREENSHOT_FOLDER = CURRENT_DIR + "selenium-reports" + DIR_SEPARATOR + "html" + DIR_SEPARATOR + "screenshots";
    public final static int DEFAULT_GLOBAL_DRIVER_TIMEOUT = 10;
    public final static int ELEMENT_TIMEOUT = 3;
    public final static int PAGE_TIMEOUT = 10;
    public final static int MILLISECONDS_TO_POLL_FOR_ELEMENT = 250;
    public final static int MOBILE_ELEMENT_TIMEOUT = 10;
    public final static int MOBILE_PAGE_TIMEOUT = 20;

    /*
     * Test constants
     */
    public final static String ENVIRONMENT_URL_PATH = "EnvironmentURLs";
    public final static String USER_CREDENTIALS_PATH = "UserCredentials";
    public final static String SANDBOX_PATH = "/sandbox/";
    public final static String TNSNAMES_PATH = "/database/";

    /*
     * Mobile Device Constants
     */
    public final static String GALAXY_S5_02 = "e9064b6c";
    public final static String GALAXY_S4_02 = "1826b7bc";
    
    /**
     * Defaults to "./" if there's an exception of any sort.
     *
     * @warning Exceptions are swallowed.
     * @return Constants.DIR_SEPARATOR
     */
    final private static String determineCurrentPath() {
        try {
            return (new File(".").getCanonicalPath()) + Constants.DIR_SEPARATOR;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "." + Constants.DIR_SEPARATOR;
    }

}