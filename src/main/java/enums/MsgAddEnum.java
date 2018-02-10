package enums;


public enum MsgAddEnum {

    SUCCESS(0, "添加留言成功"),
    STU_NOT_FOUND(-1, "不存在该学生"),
    TEA_NOT_FOUND(-2, "不存在该导师"),
    INSERT_ERROR(-3, "插入异常"),
    MSG_LENGTH_ERROR(-4, "留言长度不符合规范，长度为0或者超过了300字"),
    MSG_REPEAT(-5, "重复评论"),
    INNER_ERROR(-6,"系统内部出错");


    private int state;

    private String stateInfo;

    MsgAddEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
