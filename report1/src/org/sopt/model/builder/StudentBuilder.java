package org.sopt.model.builder;

import org.sopt.model.Student;

public class StudentBuilder {
    private int idx; // 학번
    private String name; // 이름
    private int grade; // 학년
    private String department; // 학과
    private String email; // 이메일
    private String address; // 주소
    private int age; // 나이
    private String currentState; // 현재 삳태(휴학, 재학, 군휴학, 취업계)

    public StudentBuilder setIdx(final int idx) {
        this.idx = idx;
        return this;
    }

    public StudentBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setGrade(final int grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder setDepartment(final String department) {
        this.department = department;
        return this;
    }

    public StudentBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setAddress(final String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setAge(final int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setCurrentState(final String currentState) {
        this.currentState = currentState;
        return this;
    }

    public Student build() {
        return new Student(this.idx, this.name, this.grade, this.department, this.email, this.address, this.age, this.currentState);
    }
}
