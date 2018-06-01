package com.assurity.util;

public class EnvironmentSetup {

    public static String getCurrentEnvironment() {
        return System.getenv("ENVIRONMENT");
    }

    /*
     * This method gets the base address according to environment
     * ENVIRONMENT is mentioned in assuirty_Base.properties file in env/default directory
     * BaseApiUrlTest is mentioned in apiEndPoints.properties
     */
    public static String getBaseAddress(String apiName) {

        String currentTestEnv = getCurrentEnvironment() + ".";
        String baseUrl = "";

        if (currentTestEnv.equalsIgnoreCase("production")) {
            currentTestEnv = "";
        }

        switch(apiName){
            case "BaseApiUrlTest" :
                baseUrl = System.getenv("BaseApiUrlTest");
                break;
            default:
                return null;
        }

        return baseUrl.replace("ENVIRONMENT.", currentTestEnv);
    }
}
