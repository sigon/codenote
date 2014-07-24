package net.sigon.codenote.domain.json.base;


import net.sigon.codenote.domain.constant.Constant;

public class BaseResult {
    private String code = Constant.RESULT_SUCCESS;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
