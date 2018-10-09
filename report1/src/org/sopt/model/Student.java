package org.sopt.model;

public class Student extends Department {
    private int idx; // 학번
    private String name; // 이름
    private int grade; // 학년
    private String department; // 학과
    private String email; // 이메일
    private String address; // 주소
    private int age; // 나이
    private String currentState; // 현재 삳태(휴학, 재학, 군휴학, 취업계)

    public Student() {

    }

    public Student(final int idx, final String name, final int grade, final String department, final String email, final String address, final int age, final String currentState) {
        this.idx = idx;
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.email = email;
        this.address = address;
        this.age = age;
        this.currentState = currentState;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(final int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(final int grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(final String currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", currentState='" + currentState + '\'' +
                '}';
    }
}
