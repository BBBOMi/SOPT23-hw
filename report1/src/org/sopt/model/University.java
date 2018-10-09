package org.sopt.model;

public class University {
    private int idx; // 대학 고유 번호
    private String name; // 대학 이름
    private String tel; // 대학 전화번호
    private String address; // 대학 주소

    public University() {
    }

    public University(final int idx, final String name, final String tel, final String address) {
        this.idx = idx;
        this.name = name;
        this.tel = tel;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
