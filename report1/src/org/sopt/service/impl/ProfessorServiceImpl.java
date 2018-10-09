package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    // 빈 객체만 만들어서 반환(Builder 사용)
    @Override
    public Professor getByProfessorIdx(int professorIdx) {
        ProfessorBuilder builder = new ProfessorBuilder();
        Professor professor = builder.build();
        return professor;
    }
}
