package controller.admin;

import bean.Page;
import entity.Institute;
import entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TeacherService;
import util.IConst;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource
    private TeacherService teacherService;

    /**
     * 导师列表查询页(第一个tab)
     */
    @RequestMapping(value = "/teachers")
    public String teachers(Model model, Integer currentPage) {
        Page page = new Page();
        //若没有该参数, 从第一页开始显示
        if (currentPage == null) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(currentPage);
        }
        List<Teacher> teachers = teacherService.getTeachersByPage(page);
        model.addAttribute("teachers", teachers);
        model.addAttribute("page", page);
        return "teachers";
    }

    /**
     * 添加导师页面
     */
    @RequestMapping(value = "/teachers/addPage", method = RequestMethod.GET)
    public String addPage() {
        return "addTeacher";
    }

    /**
     * 添加导师接口
     */
    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String add(Teacher teacher, Institute institute) {
        int result = teacherService.insertOne(teacher, institute);
        System.out.println("添加导师结果: " + result);
        return "redirect:/admin/teachers";
    }

    /**
     * 删除导师接口
     */
    @RequestMapping(value = "/teachers/delete", method = RequestMethod.POST)
    public String deleteTeacher(int[] ids){
        teacherService.deleteBatch(ids);
        return "redirect:/admin/teachers";

    }

    /**
     * 更新活动信息页面(第二个tab)
     */
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public String activity(Model model) {
        return "activity";
    }

    /**
     * 根据用户点击的tab跳转页面
     */
    @RequestMapping(value = "/jump", method = RequestMethod.POST)
    public String jump(int pageIndex) {
        if (pageIndex == IConst.PAGE_INDEX_TEACHERS) {
            return "redirect:/admin/teachers";
        } else if (pageIndex == IConst.PAGE_INDEX_Activity) {
            return "redirect:/admin/activity";
        }
        return "redirect:/admin/teachers";
    }

    /**
     * test
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(){

    }

}
