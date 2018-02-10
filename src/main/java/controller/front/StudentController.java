package controller.front;

import DTO.*;
import entity.Student;
import entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;
import service.TeacherService;
import service.VotesService;
import util.IConst;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;


    /**
     * 登录接口
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result login(String username, String password, HttpSession session) {
        //判断学号，密码是否正确
        if (studentService.checkIfExisted(username,password)) {
            session.setAttribute(IConst.SESSION_USER, username);
            return new Result(100, "登录成功");
        }
        return new Result(101, "登录失败");
    }

    /**
     * 判断是否登录接口
     */
    @RequestMapping(value = "/isLogin", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result isLogin(String username, HttpSession session) {
        //判断学号，密码是否正确
        if (session.getAttribute(IConst.SESSION_USER) != null
                && session.getAttribute(IConst.SESSION_USER).equals(username)) {
            return new Result<LoginDTO>(110, "已经登录");
        }
        return new Result(111, "未登录");
    }


    /**
     * 返回所有学生信息
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<List<Student>> list() {
        List<Student> students = studentService.getAllStudents();
        Result<List<Student>> result = new Result<List<Student>>(200, "");
        result.setData(students);
        return result;
    }

    /**
     * 根据id返回某个学生的信息
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<Student> detail(String id) {
        Student student = studentService.getStudentById(id);
        return new Result<Student>(201, "", student);
    }

}
