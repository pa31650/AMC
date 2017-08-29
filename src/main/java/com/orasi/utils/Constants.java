package com.orasi.utils;

import java.io.File;

public class Constants {

	final static public int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    final static public int CURRENT_MONTH = Calendar.getInstance().get(Calendar.MONTH);
    final static public int CURRENT_DAY = Calendar.getInstance().get(Calendar.DATE);
	
    /** Location of the environment URLs properties file */
    final static public String ENVIRONMENT_URL_PATH = "EnvironmentURLs";
    
    /** Location of the user credentials properties file */
    final static public String USER_CREDENTIALS_PATH = "UserCredentials";
    
    final static public String SANDBOX_PATH = "/sandbox/";
    
    /** Location of drivers in project */
    final static public String DRIVERS_PATH_LOCAL = "/drivers/";
    final static public String DRIVERS_PATH_REMOTE = "C:\\Selenium\\WebDrivers\\";
    
    /** Location of tnsnames in project */
    final static public String TNSNAMES_PATH = "/database/";
    		
    /** The location screenshots are to be stored */
    final static public String SCREENSHOT_FOLDER = CURRENT_DIR + "selenium-reports" + DIR_SEPARATOR + "html" + DIR_SEPARATOR + "screenshots"  ;
    
    /** The global system property line.separator */
    final static public String LINE_SEPARATOR = System.getProperty("line.separator", "\n");
    
    /** An alias for the global system property line.separator */
    final static public String NEW_LINE = LINE_SEPARATOR;
    
    /** The default timeout in seconds, should be a generous default time */
    final static public int DEFAULT_GLOBAL_DRIVER_TIMEOUT = 10;
    /*
     * File system info
     */
    public final static String DIR_SEPARATOR = File.separator;
    public final static String CURRENT_DIR = determineCurrentPath()

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

    /*
     * Test constants
     */
    public final static String ENVIRONMENT_URL_PATH = "EnvironmentURLs";
    public final static String USER_CREDENTIALS_PATH = "UserCredentials";
    public final static String SANDBOX_PATH = "/sandbox/";
    public final static String TNSNAMES_PATH = "/database/";

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
