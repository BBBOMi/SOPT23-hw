package org.sopt.service.impl;

import org.sopt.model.University;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {

    // 빈 객체만 만들어서 반환(Builder 사용)
    @Override
    public University getByUniversityName(String universityName) {
        UniversityBuilder builder = new UniversityBuilder();
        University university = builder.build();
        return university;
    }
}
