package org.sopt.model.builder;

import org.sopt.model.Professor;

public class ProfessorBuilder {
    private int idx; // 교수 고유 번호
    private String name; // 교수 이름
    private String department; // 교수 학과
    private String tel; // 교수 전화번호
    private String subject; // 담당 과목

    public ProfessorBuilder setIdx(final int idx) {
        this.idx = idx;
        return this;
    }

    public ProfessorBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public ProfessorBuilder setDepartment(final String department) {
        this.department = department;
        return this;
    }

    public ProfessorBuilder setTel(final String tel) {
        this.tel = tel;
        return this;
    }

    public ProfessorBuilder setSubject(final String subject) {
        this.subject = subject;
        return this;
    }

    public Professor build() {
        return new Professor(this.idx, this.name, this.department, this.tel, this.subject);
    }
}
