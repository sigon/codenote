package net.sigon.codenote.domain.enumtype;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-3-30
 * Time: 下午6:22
 * To change this template use File | Settings | File Templates.
 */
public enum ConfigTypeEnum {
    
//类别 1native 2m 3纯字（消息）

    
    NATIVE(1, "native"),
    M(2, "m"),
    WORD(3, "word");



    
    ConfigTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
