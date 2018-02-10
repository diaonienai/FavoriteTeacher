package DTO;

import enums.VoteEnum;

public class VoteDTO {

    private boolean result;

    private String msg;

    public VoteDTO() {
    }

    public VoteDTO(boolean result, VoteEnum voteEnum) {
        this.result = result;
        this.msg = voteEnum.getStateInfo();
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

//    public static VoteDTO convert(boolean b) {
//        VoteDTO dto = new VoteDTO();
//        dto.setResult(b);
//        if (b) {
//            dto.setMsg("投票成功");
//        } else {
//            dto.setMsg("投票失败");
//        }
//        return dto;
//    }
}
