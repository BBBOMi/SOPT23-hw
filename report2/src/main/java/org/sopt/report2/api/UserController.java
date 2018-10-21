package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {
    private final static List<User> userList = new LinkedList<>();

    /**
     * 현재 시간과 날짜 조회
     * @return 현재 시간과 날짜
     */
    @GetMapping("")
    public String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String current = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return "지금은 " + current + " 입니다";
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
    @GetMapping("users")
    public String getUsers(@RequestParam(value = "name", required = false)String name, @RequestParam(value = "part", required = false)String part) {
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
                return list.toString();
            } else {
                return "같은 이름의 회원이 없습니다";
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
                return list.toString();
            } else {
                return "같은 파트의 회원이 없습니다";
            }
        }
        return userList.toString();
    }

    /**
     * 현재 리스트에서 회원 id값으로 회원 검색
     * @param userIdx
     *          검색할 회원 id값
     * @return  회원 존재 유무에 따라 회원 데이터 혹은 안내문 반환
     */
    @GetMapping("users/{user_idx}")
    public String getUserByIdx(@PathVariable(name="user_idx")int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                return user.toString();
            }
        }
        return "해당 id의 회원이 없습니다";
    }

    /**
     * 회원 저장
     * @param user 저장할 회원 객체
     * @return 저장 완료 메세지
     */
    @PostMapping("users")
    public String addUser(@RequestBody final User user) {
        userList.add(user);
        return "저장 완료!";
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 수정 혹은 안내문 반환
     */
    @PutMapping("users/{user_idx}")
    public String updateUser(@PathVariable(name="user_idx")int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                // 회원 정보 수정
                userList.set(userList.indexOf(user), new User());
                return "수정 완료!";
            }
        }
        return "해당 id의 회원이 없습니다";
    }

    /**
     * 회원 삭제
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 삭제 혹은 안내문 반환
     */
    @DeleteMapping("users/{user_idx}")
    public String deleteUser(@PathVariable(name="user_idx")int userIdx) {
        Iterator<User> it = userList.iterator();
        while(it.hasNext()) {
            User user = it.next();
            if(userIdx == user.getUser_idx()) {
                userList.remove(user);
                return "회원이 삭제 되었습니다";
            }
        }
        return "해당 id의 회원이 없습니다";
    }
}
