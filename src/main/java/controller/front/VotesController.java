package controller.front;

import DTO.*;
import enums.VoteEnum;
import exception.InsertException;
import exception.StuNotFoundException;
import exception.UpdateException;
import exception.VoteTwiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeacherService;
import service.VotesService;
import util.IConst;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/vote")
public class VotesController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private VotesService votesService;

    /**
     * 投票接口
     */
    @RequestMapping(value = "/vote", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result vote(int[] ids, HttpSession session) {
        Result<VoteDTO> result;
        if (session.getAttribute(IConst.SESSION_USER) == null) {
            return new Result<VoteDTO>(999, "未登录");
        }
        try {
            votesService.vote(ids, (String) session.getAttribute(IConst.SESSION_USER));
            result = new Result<VoteDTO>(500, VoteEnum.SUCCESS.getStateInfo());
        } catch (StuNotFoundException e) {
            result = new Result<VoteDTO>(501, VoteEnum.STU_NOT_FOUND.getStateInfo());
        } catch (VoteTwiceException e) {
            result = new Result<VoteDTO>(502, VoteEnum.VOTE_TWICE.getStateInfo());
        } catch (InsertException e) {
            result = new Result<VoteDTO>(503, VoteEnum.INSERT_ERROR.getStateInfo());
        } catch (UpdateException e) {
            result = new Result<VoteDTO>(504, VoteEnum.UPDATE_ERROR.getStateInfo());
        } catch (Exception e) {
            result = new Result<VoteDTO>(505, VoteEnum.INNER_ERROR.getStateInfo());
        }
        return result;
    }

    /**
     * 判断是否已经结束接口
     */
    @RequestMapping(value = "/end", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result vote() {
        return new Result<IsEndDTO>(900, "还没结束");
    }

    /**
     * 若投票结束，则返回所有导师投票情况
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<VoteResultDTO> teacherVote() {
        Result<VoteResultDTO> result = new Result<VoteResultDTO>(800, "成功最后的投票结果");
        result.setData(VoteResultDTO.convert(1, teacherService.getAllTeachers()));
        return result;
    }



}
