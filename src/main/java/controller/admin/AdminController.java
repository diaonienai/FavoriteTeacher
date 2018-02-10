package controller.admin;

import bean.Page;
import entity.Institute;
import entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.TeacherService;
import util.IConst;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String add(Teacher teacher, Institute institute,
                      @RequestParam("tIcon") CommonsMultipartFile multipartFile) {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = date + "."
                + multipartFile.getContentType().split("/")[1];
        String path = IConst.ICON_PATH + fileName;
        System.out.println(path);
        File file = new File(path);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        teacher.setIcon(IConst.ICON_ADDRESS + fileName);
        int result = teacherService.insertOne(teacher, institute);
        return "redirect:/admin/teachers";
    }

    /**
     * 删除导师接口
     */
    @RequestMapping(value = "/teachers/delete", method = RequestMethod.POST)
    public String deleteTeacher(int[] ids) {
        teacherService.deleteBatch(ids);
        return "redirect:/admin/teachers";

    }

    /**
     * 编辑导师页面
     */
    @RequestMapping(value = "/teachers/editPage", method = RequestMethod.POST)
    public String editPage(Model model, int editTeacherId) {
        Teacher teacher = teacherService.getTeacherById(editTeacherId);
        model.addAttribute("teacher", teacher);
        return "editTeacher";
    }

    /**
     * 编辑导师接口
     */
    @RequestMapping(value = "/teachers/edit", method = RequestMethod.POST)
    public String edit(Teacher teacher, Institute institute,
                       @RequestParam("teacherIcon") String teacherIcon,
                       @RequestParam("tIcon") CommonsMultipartFile multipartFile) {
        String[] arr = teacherIcon.split("/");
        File oldIcon = new File(IConst.ICON_PATH + arr[arr.length - 1]);
        if (oldIcon.exists()) {
            oldIcon.delete();
        }
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = date + "."
                + multipartFile.getContentType().split("/")[1];
        String path = IConst.ICON_PATH + fileName;
        File file = new File(path);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        teacher.setIcon(IConst.ICON_ADDRESS + fileName);
        teacher.setInstitute(institute);
        teacherService.updateTeacher(teacher);
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
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test() {
        return "llll";
    }

}
