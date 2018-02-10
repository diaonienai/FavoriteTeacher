package entity;

import java.util.Date;

public class Votes {

    private int voteNo;

    private Teacher teacher;

    private Student student;

    private Date voteTime;

    public Votes() {
    }

    public Votes(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    public int getVoteNo() {
        return voteNo;
    }

    public void setVoteNo(int voteNo) {
        this.voteNo = voteNo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Date voteTime) {
        this.voteTime = voteTime;
    }
}
