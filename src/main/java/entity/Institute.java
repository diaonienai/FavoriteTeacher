package entity;

import java.util.List;

public class Institute {

    private int insNo;

    private String insName;

    private List<Teacher> teachers;

    public Institute() {

    }

    public int getInsNo() {
        return insNo;
    }

    public void setInsNo(int insNo) {
        this.insNo = insNo;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("insNo: ");
        sb.append(insNo);
        sb.append(", ");
        sb.append("insName: ");
        sb.append(insName);
        sb.append("\n");
        return sb.toString();
    }
}
