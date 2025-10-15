package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src\\test\\resources\\config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Error loading config file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getAppiumServerUrl() {
        return getProperty("appium.server.url");
    }

    public static String getDeviceName() {
        return getProperty("device.name");
    }

    public static String getPlatformVersion() {
        return getProperty("platform.version");
    }

    public static String getAppPackage() {
        return getProperty("app.package");
    }

    public static String getAppActivity() {
        return getProperty("app.activity");
    }

    public static String getAppPath() {
        return getProperty("app.path");
    }

    public static String getMrEmail(){
        return getProperty("mrEmail");
    }

    public static String getMrPassword(){
        return getProperty("mrPassword");
    }

    public static String getAsmEmail(){
        return getProperty("asmEmail");
    }

    public static String getAsmPassword(){
        return getProperty("asmPassword");
    }

    public static String getRsmEmail(){
        return getProperty("rsmEmail");
    }

    public static String getRsmPassword(){
        return getProperty("rsmPassword");
    }

    public static String getCompanyCode(){
        return getProperty("companyCode");
    }

    public static String getNoReset(){
        return getProperty("noReset");
    }

    public static String getFullReset(){
        return getProperty("fullReset");
    }

    public static String getMrName(){
        return getProperty("mrName");
    }

    public static String getAsmName(){
        return getProperty("asmName");
    }

    public static String getRsmName(){
        return getProperty("rsmName");
    }

    // iOS properties
    public static String getIOSDeviceName() {
        return properties.getProperty("ios.device.name");
    }

    public static String getIOSPlatformVersion() {
        return properties.getProperty("ios.platform.version");
    }

    public static String getIOSAutomationName() {
        return properties.getProperty("ios.automation.name");
    }

    public static String getIOSBundleId() {
        return properties.getProperty("ios.bundle.id");
    }

    public static String getIOSAppPath() {
        return properties.getProperty("ios.app.path");
    }

    public static String getIOSUdid() {
        return properties.getProperty("ios.udid");
    }

    public static String getIOSNoReset() {
        return properties.getProperty("ios.no.reset", "false");
    }

    public static String getIOSFullReset() {
        return properties.getProperty("ios.full.reset", "false");
    }

    public static String getDirectorEmail() {
        return properties.getProperty("directorsEmail");
    }

    public static String getDirectorPass() {
        return properties.getProperty("directorsPass");
    }

}