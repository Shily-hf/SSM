package edu.shily.crud.service;

import edu.shily.crud.bean.Department;
import edu.shily.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shily-zhang
 * @Description
 */
@Service
public class DepartmentServiece {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {

        List<Department> list = departmentMapper.selectByExample(null);

        return list;
    }
}
