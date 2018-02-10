package controller.front;


import DTO.InstituteDTO;
import DTO.Result;
import entity.Institute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.InstituteService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/institute")
public class InstituteController {

    @Resource
    private InstituteService instituteService;

    @RequestMapping(value = "/list", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result<List<InstituteDTO>> getAll() {
        return new Result<List<InstituteDTO>>(700, "成功获取学院投票信息",
                InstituteDTO.convert(instituteService.getAllInstitute()));
    }
}
