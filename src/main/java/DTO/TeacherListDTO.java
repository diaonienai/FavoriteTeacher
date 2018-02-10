package DTO;

import entity.Teacher;
import util.IConst;

import java.util.ArrayList;
import java.util.List;

public class TeacherListDTO {

    private int id;

    private String name;

    private String imgSrc;

    private int voteNum;

    private String academy;

    public TeacherListDTO() {
    }

    public TeacherListDTO(int id, String name, String imgSrc, int voteNum, String academy) {
        this.id = id;
        this.name = name;
        this.imgSrc = imgSrc;
        this.voteNum = voteNum;
        this.academy = academy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public static TeacherListDTO convertTeacher(Teacher teacher) {
        TeacherListDTO dto = new TeacherListDTO();
        dto.setId(teacher.getTeacherNo());
        dto.setName(teacher.getTeacherName());
        dto.setAcademy(teacher.getInstitute().getInsName());
        dto.setImgSrc(teacher.getIcon());
        dto.setVoteNum(teacher.getVotes());
        return dto;
    }

    public static List<TeacherListDTO> convertTeacher(List<Teacher> teachers) {
        List<TeacherListDTO> list = new ArrayList<TeacherListDTO>();
        for (Teacher t : teachers) {
            list.add(convertTeacher(t));
        }
        return list;
    }
}
