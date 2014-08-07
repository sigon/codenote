package net.sigon.codenote.domain.common;


/**
 * Created with IntelliJ IDEA.
 * User: yf-liulei
 * Date: 14-4-11
 * Time: ����5:17
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private String client;
    private String cv;
    private String env;
    private String flag;
    private String os;
    private String ov;
    private String screen;
    private String uuid;
    //env�ֶ�Ϊdebug��ʾ����2���ֶΣ����������ĵ���ʹ��
    private String sourceResult;
    private String sourceKey;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOv() {
        return ov;
    }

    public void setOv(String ov) {
        this.ov = ov;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSourceResult() {
        return sourceResult;
    }

    public void setSourceResult(String sourceResult) {
        this.sourceResult = sourceResult;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }
}
