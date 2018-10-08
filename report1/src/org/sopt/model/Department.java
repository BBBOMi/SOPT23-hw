package org.sopt.model;

public class Department {
    private int id; // 학과 고유 번호
    private String name; // 학과 이름
    private String tel; // 학과 전화번호
    private int type; // 학과 타입(공대, 자연대, 사범대, 치대..)
    
    public Department() {

    }

    public Department(int id, String name, String tel, int type) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.type = type;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                '}';
    }
}
