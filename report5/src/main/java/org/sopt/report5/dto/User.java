package org.sopt.report5.dto;

public class User {
    private int userIdx; // 회원 고유번호
    private String name; // 회원 이름
    private String part; // 회원 파트
    private String profileUrl; // 회원 프로필 사진

    public User() {
    }

    public User(int userIdx) {
        this.userIdx = userIdx;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(final int userIdx) {
        this.userIdx = userIdx;
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

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userIdx=" + userIdx +
                ", name='" + name + '\'' +
                ", part='" + part + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }
}
