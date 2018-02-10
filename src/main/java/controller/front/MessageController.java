package controller.front;

import DTO.*;
import entity.Message;
import enums.MsgAddEnum;
import exception.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MessageService;
import util.IConst;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    /**
     * 添加留言
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result<MsgAddDTO> addMessage(int id, String msg, int anonymous,
                                        HttpSession session) {
        Result<MsgAddDTO> result;
        if (session.getAttribute(IConst.SESSION_USER) == null) {
            return new Result<MsgAddDTO>(999, "未登录");
        }
        try {
            messageService.insertOne(id,
                    (String) session.getAttribute(IConst.SESSION_USER), msg, anonymous);
            result = new Result<MsgAddDTO>(600, MsgAddEnum.SUCCESS.getStateInfo());
        } catch (TeaNotFoundException e) {
            result = new Result<MsgAddDTO>(601, MsgAddEnum.TEA_NOT_FOUND.getStateInfo());
        } catch (StuNotFoundException e) {
            result = new Result<MsgAddDTO>(602, MsgAddEnum.STU_NOT_FOUND.getStateInfo());
        } catch (MsgRepeatException e){
            result = new Result<MsgAddDTO>(603, MsgAddEnum.MSG_REPEAT.getStateInfo());
        } catch (MsgLengthException e) {
            result = new Result<MsgAddDTO>(604, MsgAddEnum.MSG_LENGTH_ERROR.getStateInfo());
        } catch (InsertException e) {
            result = new Result<MsgAddDTO>(605, MsgAddEnum.INSERT_ERROR.getStateInfo());
        } catch (Exception e) {
            result = new Result<MsgAddDTO>(606, MsgAddEnum.INNER_ERROR.getStateInfo());
        }
        return result;
    }

    /**
     * 返回所有留言信息，分页
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<MessageDTO> list(int page) {
        Result<MessageDTO> result = new Result<MessageDTO>(610, "成功获取所有留言");
        result.setData(messageService.getAllMsgByPage(page));
        return result;
    }

    /**
     * 根据导师id返回留言，分页
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<MsgOfOneDTO> detail(int id, int page) {
        return new Result<MsgOfOneDTO>(620, "成功获取导师留言",
                messageService.getMsgOfOneByPage(id, page));
    }

}
