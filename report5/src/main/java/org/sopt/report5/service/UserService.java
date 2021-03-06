package org.sopt.report5.service;

import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.dto.User;
import org.sopt.report5.model.SignUpReq;

/**
 * Created by bomi on 2018-11-01.
 */

public interface UserService {
    // 현재 시간
    DefaultRes getCurrentTime();
    // 모든 회원 데이터, 같은 이름, 파트의 회원 검색
    DefaultRes getUsers(final String name, final String part);
    // ID로 회원 검색
    DefaultRes<User> getUserByIdx(final int userIdx);
    // 회원 추가
    DefaultRes addUser(final SignUpReq signUpReq);
    // 회원 정보 수정
    DefaultRes updateUser(final int userIdx, final SignUpReq signUpReq);
    // 회원 삭제
    DefaultRes deleteUser(final int userIdx);
}
