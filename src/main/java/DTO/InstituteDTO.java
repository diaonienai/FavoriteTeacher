package DTO;

import entity.Institute;

import java.util.ArrayList;
import java.util.List;

public class InstituteDTO {

    private int id;

    private String academy;

    private int voteNum;

    public InstituteDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public static InstituteDTO convert(Institute institute) {
        InstituteDTO dto = new InstituteDTO();
        dto.setId(institute.getInsNo());
        dto.setAcademy(institute.getInsName());
        dto.setVoteNum(institute.getInsVotes());
        return dto;
    }

    public static List<InstituteDTO> convert(List<Institute> institutes) {
        List<InstituteDTO> res = new ArrayList<InstituteDTO>();
        for (Institute institute : institutes) {
            res.add(InstituteDTO.convert(institute));
        }
        return res;
    }
}
