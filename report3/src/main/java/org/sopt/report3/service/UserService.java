package org.sopt.report3.service;

import org.sopt.report3.model.DefaultRes;
import org.sopt.report3.model.User;

/**
 * Created by bomi on 2018-11-01.
 */

public interface UserService {
    // 현재 시간
    DefaultRes getCurrentTime();
    // 모든 회원 데이터, 같은 이름, 파트의 회원 검색
    DefaultRes getUsers(String name, String part);
    // ID로 회원 검색
    DefaultRes<User> getUserByIdx(int userIdx);
    // 회원 추가
    DefaultRes addUser(final User user);
    // 회원 정보 수정
    DefaultRes updateUser(int userIdx);
    // 회원 삭제
    DefaultRes deleteUser(int userIdx);
}
