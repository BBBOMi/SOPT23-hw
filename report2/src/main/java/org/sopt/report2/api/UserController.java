package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public String getUsers(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "part", defaultValue = "") String part) {
        if(!("".equals(name))) {
            Iterator<User> it = userList.iterator();
            while(it.hasNext()) {
                User user = it.next();
                if(name.equals(user.getName())) {
                    return user.toString();
                }
            }
            return "같은 이름의 회원이 없습니다";
        }
        //return ;
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
}
