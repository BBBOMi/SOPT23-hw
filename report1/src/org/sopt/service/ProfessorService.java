package org.sopt.service;

import org.sopt.model.Professor;

public interface ProfessorService {
    // 교수 소유 번호로 조회
    Professor getByProfessorIdx(final int professorIdx);
}
