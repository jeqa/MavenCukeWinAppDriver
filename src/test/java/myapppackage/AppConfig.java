package myapppackage;

public class AppConfig {

    private String AppId ;
    private String AppArg ;
    private boolean MaximizeFlag;

    String getAppId() {
        return AppId;
    }

    String getAppArg() {
        return AppArg;
    }

    boolean isMaximizeFlag() {
        return MaximizeFlag;
    }

    private AppConfig(String appId, String appArg, boolean maximizeFlag){
        this.AppId = appId;
        this.AppArg = appArg;
        this.MaximizeFlag = maximizeFlag;
    }

    static AppConfig calculator = new AppConfig("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App", "", false);

    static AppConfig edge = new AppConfig("Microsoft.MicrosoftEdge_8wekyb3d8bbwe!MicrosoftEdge", "", true);

    static AppConfig word = new AppConfig("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.exe", "/q", true);

    static AppConfig excel = new AppConfig("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.exe", "/e", true);

    static AppConfig outlook = new AppConfig("C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE", "", false);

    static AppConfig powerpoint = new AppConfig("C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.exe", "/s", true);

    static AppConfig chrome = new AppConfig("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "", true);

    static AppConfig ie11 = new AppConfig("C:\\Program Files\\internet explorer\\iexplore.exe", "", true);

    static AppConfig acrobat = new AppConfig("C:\\Program Files (x86)\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe", "", false);

    static AppConfig notepad = new AppConfig("C:\\Windows\\System32\\notepad.exe", "", true);

    static AppConfig firefox = new AppConfig("C:\\Program Files\\Mozilla Firefox\\firefox.exe", "", true);

    static AppConfig teams = new AppConfig("C:\\Users\\Administrator\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Corporation\\Microsoft Teams",
            "", false);


}
