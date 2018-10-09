package org.sopt.service.impl;

import org.sopt.model.Student;
import org.sopt.model.builder.StudentBuilder;
import org.sopt.service.StudentService;

public class StudentServiceImpl implements StudentService {

    // 빈 객체만 만들어서 반환(Builder 사용)
    @Override
    public Student getByStudentIdx(int studentIdx) {
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.build();
        return student;
    }
}
