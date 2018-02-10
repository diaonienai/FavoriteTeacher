package DTO;

import bean.Page;
import entity.Message;
import util.IConst;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageDTO {

    private int totalNum;

    private int totalPage;

    private List<InnerMessage> msgs;

    public MessageDTO() {
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<InnerMessage> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<InnerMessage> msgs) {
        this.msgs = msgs;
    }

    public static MessageDTO convert(List<Message> messages, Page page) {
        MessageDTO dto = new MessageDTO();
        dto.setTotalNum(page.getTotalNumber());
        dto.setTotalPage(page.getTotalPage());
        List<InnerMessage> list = new ArrayList<InnerMessage>();
        dto.setMsgs(list);
        InnerMessage innerMessage;
        for (Message message : messages) {
            innerMessage = new InnerMessage();
            innerMessage.setId(message.getMessageNo());
            innerMessage.settImgSrc(message.getTeacher().getIcon());
            innerMessage.settName(message.getTeacher().getTeacherName());
            innerMessage.setsImgSrc(IConst.IP_CONTEXT + "resources/image/test.png");
            if (message.isAnonymous()) {
                innerMessage.setsName("匿名");
            } else {
                innerMessage.setsName(message.getStudent().getStuNo() + " " + message.getStudent().getStuName());
            }
            innerMessage.setMsg(message.getContent());
            innerMessage.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(message.getTime()));
            list.add(innerMessage);
        }
        return dto;
    }

    static class InnerMessage {
        //留言id
        private int id;

        //导师头像
        private String tImgSrc;

        //导师名字
        private String tName;

        //学生头像
        private String sImgSrc;

        //学号+空格+姓名
        private String sName;

        //留言内容
        private String msg;

        //留言时间
        private String time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String gettImgSrc() {
            return tImgSrc;
        }

        public void settImgSrc(String tImgSrc) {
            this.tImgSrc = tImgSrc;
        }

        public String gettName() {
            return tName;
        }

        public void settName(String tName) {
            this.tName = tName;
        }

        public String getsImgSrc() {
            return sImgSrc;
        }

        public void setsImgSrc(String sImgSrc) {
            this.sImgSrc = sImgSrc;
        }

        public String getsName() {
            return sName;
        }

        public void setsName(String sName) {
            this.sName = sName;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

}
