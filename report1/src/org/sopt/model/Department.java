package org.sopt.model;

public class Department extends University {
    private int idx; // 학과 고유 번호
    private String name; // 학과 이름
    private String tel; // 학과 전화번호
    private String type; // 학과 타입(공대, 자연대, 사범대, 치대..)

    public Department() {
    }

    public Department(final int idx, final String name, final String tel, final String type) {
        this.idx = idx;
        this.name = name;
        this.tel = tel;
        this.type = type;
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

    public String getTel() {
        return tel;
    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                '}';
    }
}
