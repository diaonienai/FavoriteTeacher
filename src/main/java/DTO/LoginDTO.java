package DTO;

public class LoginDTO {

    private boolean result;

    private String msg;

    public LoginDTO() {
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

    public static LoginDTO convert(boolean b) {
        LoginDTO dto = new LoginDTO();
        dto.setResult(b);
        if (b) {
            dto.setMsg("已登录或者登录成功");
        } else {
            dto.setMsg("未登录或登录失败");
        }
        return dto;
    }
}
