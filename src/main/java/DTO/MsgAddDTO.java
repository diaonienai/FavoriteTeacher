package DTO;

import enums.MsgAddEnum;

public class MsgAddDTO {

    private boolean result;

    private String msg;

    public MsgAddDTO() {
    }

    public MsgAddDTO(boolean result, MsgAddEnum msgAddEnum) {
        this.result = result;
        this.msg = msgAddEnum.getStateInfo();
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public static MsgAddDTO convert(boolean b) {
//        MsgAddDTO dto = new MsgAddDTO();
//        dto.setResult(b);
//        dto.setMsg(b ? "成功添加留言" : "添加留言失败");
//        return dto;
//    }
}
