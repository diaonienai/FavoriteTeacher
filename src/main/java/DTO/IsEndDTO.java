package DTO;

public class IsEndDTO {

    private boolean result;

    private String msg;

    public IsEndDTO() {
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

    public static IsEndDTO convert(boolean b) {
        IsEndDTO dto = new IsEndDTO();
        dto.setResult(b);
        if (b) {
            dto.setMsg("已经结束");
        } else {
            dto.setMsg("投票正在进行中");
        }
        return dto;
    }
}
