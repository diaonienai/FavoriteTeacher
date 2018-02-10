package entity;

import java.util.Date;

public class Teacher {
    //导师号
    private int teacherNo;
    //导师名
    private String teacherName;
    //性别
    private String gender;
    //头像
    private String icon;
    //职称
    private String title;
    //最新更新时间
    private Date latestUpdateTime;
    //投票数
    private int votes;

    //个人简介
    private String introduction;

    //推荐语
    private String recommendation;

    //点评
    private String comment;

    //导师所属学院
    private Institute institute;

    public Teacher() {

    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLatestUpdateTime() {
        return latestUpdateTime;
    }

    public void setLatestUpdateTime(Date latestUpdateTime) {
        this.latestUpdateTime = latestUpdateTime;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("teacherNo: ");
        sb.append(teacherNo);
        sb.append(", ");
        sb.append("teacherName: ");
        sb.append(teacherName);
        sb.append(", ");
        sb.append("title: ");
        sb.append(title);
        sb.append(", ");
        sb.append("icon: ");
        sb.append(icon);
        sb.append(", ");
        sb.append("votes: ");
        sb.append(votes);
        sb.append(", ");
        sb.append("introduction: ");
        sb.append(introduction);
        sb.append(", ");
        sb.append("recommendation: ");
        sb.append(recommendation);
        sb.append(", ");
        sb.append("comment: ");
        sb.append(comment);
        sb.append("\n");
        return sb.toString();
    }
}
