package org.sopt.model;

public class Student {
    private int id; // 학번
    private String name; // 이름
    private int grade; // 학년
    private String department; // 학과
    private String email; // 이메일
    private String address; // 주소
    private int age; // 나이
    private String currentState; // 현재 삳태(휴학, 재학, 군휴학, 취업계)

    public Student() {

    }

    public Student(int id, String name, int grade, String department, String email, String address, int age, String currentState) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.email = email;
        this.address = address;
        this.age = age;
        this.currentState = currentState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
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
