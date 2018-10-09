package org.sopt.model;

public class Professor extends Department {
    private int idx; // 교수 고유 번호
    private String name; // 교수 이름
    private String department; // 교수 학과
    private String tel; // 교수 전화번호
    private String subject; // 담당 과목

    public Professor() {
    }

    public Professor(final int idx, final String name, final String department, final String tel, final String subject) {
        this.idx = idx;
        this.name = name;
        this.department = department;
        this.tel = tel;
        this.subject = subject;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
