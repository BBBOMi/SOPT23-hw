package org.sopt.model.builder;

import org.sopt.model.University;

public class UniversityBuilder {
    private int idx; // 대학 고유 번호
    private String name; // 대학 이름
    private String tel; // 대학 전화번호
    private String address; // 대학 주소

    public UniversityBuilder setIdx(final int idx) {
        this.idx = idx;
        return this;
    }

    public UniversityBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public UniversityBuilder setTel(final String tel) {
        this.tel = tel;
        return this;
    }

    public UniversityBuilder setAddress(final String address) {
        this.address = address;
        return this;
    }

    public University build() {
        return new University(this.idx, this.name, this.tel, this.address);
    }
}
