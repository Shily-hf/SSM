package edu.shily.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.shily.crud.bean.Employee;
import edu.shily.crud.bean.Msg;
import edu.shily.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Shily-zhang
 * @Description 处理员工CRUD请求
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps,5);

        return Msg.success().add("pageInfo",page);
    }

    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                          Model model){

        PageHelper.startPage(pn,5);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);

        return "list";
    }
}
