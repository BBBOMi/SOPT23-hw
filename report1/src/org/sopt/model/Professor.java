package org.sopt.model;

public class Professor {
    private int id; // 교수 고유 번호
    private String name; // 교수 이름
    private String department; // 교수 학과
    private String tel; // 교수 전화번호
    private String subject; // 담당 과목

    public Professor() {
    }

    public Professor(int id, String name, String department, String tel, String subject) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.tel = tel;
        this.subject = subject;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
