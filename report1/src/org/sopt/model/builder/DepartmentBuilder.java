package org.sopt.model.builder;

import org.sopt.model.Department;

public class DepartmentBuilder {
    private int idx; // 학과 고유 번호
    private String name; // 학과 이름
    private String tel; // 학과 전화번호
    private String type; // 학과 타입(공대, 자연대, 사범대, 치대..)

    public DepartmentBuilder setIdx(final int idx) {
        this.idx = idx;
        return this;
    }

    public DepartmentBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public DepartmentBuilder setTel(final String tel) {
        this.tel = tel;
        return this;
    }

    public DepartmentBuilder setType(final String type) {
        this.type = type;
        return this;
    }

    public Department build() {
        return new Department(this.idx, this.name, this.tel, this.type);
    }
}
