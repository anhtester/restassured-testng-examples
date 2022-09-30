package anhtester.com.constants;

import java.io.File;

public class Constants {

    public static final String YES = "yes";
    public static final String NO = "no";

    public static final String PROJECT_PATH = System.getProperty("user.dir") + File.separator;
    public static final String OPEN_REPORTS_AFTER_EXECUTION = YES;
    public static final String OVERRIDE_REPORTS = YES;
    public static final String PROJECT_NAME = "REST Assured Examples | Anh Tester";
    public static final String REPORT_TITLE = "REST Assured Examples | Anh Tester";
    public static final String EXTENT_REPORT_NAME = "ExtentReports";
    public static final String EXTENT_REPORT_FOLDER = "reports";
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static final String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;
}
