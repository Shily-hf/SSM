package edu.shily.crud.controller;

import edu.shily.crud.bean.Department;
import edu.shily.crud.bean.Msg;
import edu.shily.crud.service.DepartmentServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Shily-zhang
 * @Description 处理和部门有关的请求
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentServiece departmentServiece;

    //返回所有的部门信息
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){

        //查出的所有部门信息
        List<Department> list = departmentServiece.getDepts();

        return Msg.success().add("depts",list);
    }

}
