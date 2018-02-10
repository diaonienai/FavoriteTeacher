package DTO;

import entity.Teacher;
import util.IConst;

public class TeacherDetailDTO {

    private int id;
    private String imgSrc;
    private String name;
    private String sexual;
    private String academy;
    private String rank;
    private String intro;
    private String recommend;
    private String evaluate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexual() {
        return sexual;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public static TeacherDetailDTO convertTeacher(Teacher teacher) {
        TeacherDetailDTO dto = new TeacherDetailDTO();
        dto.setId(teacher.getTeacherNo());
        dto.setName(teacher.getTeacherName());
        dto.setImgSrc(teacher.getIcon());
        dto.setSexual(teacher.getGender());
        dto.setAcademy(teacher.getInstitute().getInsName());
        dto.setRank(teacher.getTitle());
        dto.setIntro(teacher.getIntroduction());
        dto.setRecommend(teacher.getRecommendation());
        dto.setEvaluate(teacher.getComment());
        return dto;
    }


}
