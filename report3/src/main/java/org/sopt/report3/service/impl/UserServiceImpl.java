package org.sopt.report3.service.impl;

import org.sopt.report3.model.DefaultRes;
import org.sopt.report3.model.User;
import org.sopt.report3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by bomi on 2018-11-01.
 */

@Service
public class UserServiceImpl implements UserService {

    private final static List<User> userList = new LinkedList<>();

    /**
     * 현재 시간과 날짜 조회
     * @return 현재 시간과 날짜
     */
    @Override
    public DefaultRes getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String current = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return DefaultRes.res(HttpStatus.OK.value(), "현재 시간", current);
    }

    /**
     * 모든 회원 리스트 조회
     * 현재 리스트에서 같은 이름의 회원 조회
     * 현재 리스트에서 같은 파트의 회원 조회
     * @param name
     *          회원의 이름
     * @param part
     *          회원의 파트
     * @return 회원 존재 유무에 따라 회원 데이터 혹은 안내문 반환
     */
    @Override
    public DefaultRes getUsers(String name, String part) {
        if(!StringUtils.isEmpty(name)) {
            Iterator<User> it = userList.iterator();
            List<User> list = new ArrayList<>();
            while(it.hasNext()) {
                User user = it.next();
                if(name.equals(user.getName())) {
                    list.add(user);
                }
            }
            if(list.size() > 0) {
                return DefaultRes.res(HttpStatus.OK.value(), "회원 찾기 성공!", list);
            } else {
                return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "같은 이름의 회원이 없습니다.");
            }
        } else if(!StringUtils.isEmpty(part)) {
            Iterator<User> it = userList.iterator();
            List<User> list = new ArrayList<>();
            while(it.hasNext()) {
                User user = it.next();
                if(part.equals(user.getPart())) {
                    list.add(user);
                }
            }
            if(list.size() > 0) {
                return DefaultRes.res(HttpStatus.OK.value(), "회원 찾기 성공!", list);
            } else {
                return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "같은 이름의 회원이 없습니다.");
            }
        }
        return DefaultRes.res(HttpStatus.OK.value(), "리스트에 등록된 모든 회원 데이터", userList);
    }

    /**
     * 현재 리스트에서 회원 id값으로 회원 검색
     * @param userIdx
     *          검색할 회원 id값
     * @return  회원 존재 유무에 따라 회원 데이터 혹은 안내문 반환
     */
    @Override
    public DefaultRes getUserByIdx(int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                return DefaultRes.res(HttpStatus.OK.value(), "해당 ID의 회원 검색 성공!", user);
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 ID의 회원이 없습니다.");
    }

    /**
     * 회원 저장
     * @param user 저장할 회원 객체
     * @return 저장 완료 메세지
     */
    @Override
    public DefaultRes addUser(User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.OK.value(), "회원 저장 성공!");
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 수정 혹은 안내문 반환
     */
    @Override
    public DefaultRes updateUser(int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                // 회원 정보 수정
                userList.set(userList.indexOf(user), new User(userIdx));
                return DefaultRes.res(HttpStatus.OK.value(), "회원 정보 수정 성공!");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "일치하는 ID의 회원이 없습니다.");
    }

    /**
     * 회원 삭제
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 삭제 혹은 안내문 반환
     */
    @Override
    public DefaultRes deleteUser(int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                userList.remove(user);
                return DefaultRes.res(HttpStatus.OK.value(), "회원 삭제 성공!");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "일치하는 ID의 회원이 없습니다.");
    }
}
