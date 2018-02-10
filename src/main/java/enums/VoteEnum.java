package enums;


public enum VoteEnum {

    SUCCESS(0, "投票成功"),
    VOTE_TWICE(-1, "该学生已经投过票"),
    STU_NOT_FOUND(-2, "不存在该学生"),
    WRONG_NUMBER(-3, "不够15个投票"),
    INSERT_ERROR(-4, "插入异常"),
    UPDATE_ERROR(-5,"更新学生投票状态出错"),
    INNER_ERROR(-6,"系统内部出错");


    private int state;

    private String stateInfo;

    VoteEnum(int state, String stateInfo) {
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
