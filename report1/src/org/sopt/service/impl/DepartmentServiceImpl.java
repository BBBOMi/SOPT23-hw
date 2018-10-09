package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    // 빈 객체만 만들어서 반환(Builder 사용)
    @Override
    public Department getByDepartmentName(String departmentName) {
        DepartmentBuilder builder = new DepartmentBuilder();
        Department department = builder.build();
        return department;
    }
}
