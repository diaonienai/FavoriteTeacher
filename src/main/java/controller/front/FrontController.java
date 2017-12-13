package controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "forward")
public class FrontController {

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.GET)
    public String updateTeacherInfo() {
        return "updateTeacher";
    }

}
