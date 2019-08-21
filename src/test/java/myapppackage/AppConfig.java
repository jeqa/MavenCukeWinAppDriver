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
}
