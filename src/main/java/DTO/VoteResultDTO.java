package DTO;

import entity.Teacher;
import util.IConst;

import java.util.ArrayList;
import java.util.List;

public class VoteResultDTO {

    private int end;

    private List<TmpTeacher> teaList;

    public VoteResultDTO() {
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<TmpTeacher> getTeaList() {
        return teaList;
    }

    public void setTeaList(List<TmpTeacher> teaList) {
        this.teaList = teaList;
    }

    public static VoteResultDTO convert(int end, List<Teacher> teachers) {
        VoteResultDTO dto = new VoteResultDTO();
        dto.setEnd(end);
        List<TmpTeacher> teaList = new ArrayList<TmpTeacher>();
        dto.setTeaList(teaList);
        if (end == 0) {
            return dto;
        }
        TmpTeacher tmpTeacher;
        for (Teacher t : teachers) {
            tmpTeacher = new TmpTeacher();
            tmpTeacher.setId(t.getTeacherNo());
            tmpTeacher.setName(t.getTeacherName());
            tmpTeacher.setAcademy(t.getInstitute().getInsName());
            tmpTeacher.setImgSrc(t.getIcon());
            tmpTeacher.setVotes(t.getVotes());
            teaList.add(tmpTeacher);
        }
        return dto;
    }

    static class TmpTeacher{
        private int id;

        private String name;

        private String academy;

        private String imgSrc;

        private int votes;

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

        public String getAcademy() {
            return academy;
        }

        public void setAcademy(String academy) {
            this.academy = academy;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        public int getVotes() {
            return votes;
        }

        public void setVotes(int votes) {
            this.votes = votes;
        }
    }
}
