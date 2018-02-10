package DTO;

import bean.Page;
import entity.Message;
import util.IConst;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MsgOfOneDTO {

    private int totalNum;

    private int totalPage;

    private List<InnerMessage> msgs;

    public MsgOfOneDTO() {
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

    public static MsgOfOneDTO convert(List<Message> messages, Page page) {
        MsgOfOneDTO dto = new MsgOfOneDTO();
        dto.setTotalNum(page.getTotalNumber());
        dto.setTotalPage(page.getTotalPage());
        List<InnerMessage> list = new ArrayList<InnerMessage>();
        dto.setMsgs(list);
        InnerMessage innerMessage;
        for (Message message : messages) {
            innerMessage = new InnerMessage();
            innerMessage.setId(message.getMessageNo());
            innerMessage.setImgSrc(IConst.IP_CONTEXT + "resources/image/test.png");
            if (message.isAnonymous()) {
                innerMessage.setName("匿名");
            } else {
                innerMessage.setName(message.getStudent().getStuNo() + " " + message.getStudent().getStuName());
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

        //学生头像
        private String imgSrc;

        //学号+空格+姓名
        private String name;

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
