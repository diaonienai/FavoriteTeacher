package DTO;

import entity.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回教师的投票信息
 */
public class TeacherVoteDTO {

    private int id;

    private String name;

    private int voteNum;

    public TeacherVoteDTO() {
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

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public static TeacherVoteDTO convert(Teacher teacher) {
        TeacherVoteDTO dto = new TeacherVoteDTO();
        dto.setId(teacher.getTeacherNo());
        dto.setName(teacher.getTeacherName());
        dto.setVoteNum(teacher.getVotes());
        return dto;
    }

    public static List<TeacherVoteDTO> convert(List<Teacher> teachers) {
        List<TeacherVoteDTO> res = new ArrayList<TeacherVoteDTO>();
        for (Teacher teacher : teachers) {
            res.add(TeacherVoteDTO.convert(teacher));
        }
        return res;
    }
}
