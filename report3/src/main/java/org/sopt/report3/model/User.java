package org.sopt.report3.model;

public class User {
    private int user_idx; // 회원 고유번호
    private String name; // 회원 이름
    private String part; // 회원 파트

    public User() {
    }

    public User(int user_idx) {
        this.user_idx = user_idx;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(final int user_idx) {
        this.user_idx = user_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(final String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_idx=" + user_idx +
                ", name='" + name + '\'' +
                ", part='" + part + '\'' +
                '}';
    }
}
