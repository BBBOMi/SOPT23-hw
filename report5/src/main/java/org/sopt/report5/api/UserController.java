package org.sopt.report5.api;

import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.dto.User;
import org.sopt.report5.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    /**
     * 생성자가 1개일 경우 @Autowired 생략 가능
     * @param userService user 서비스
     */
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * 현재 시간과 날짜 조회
     * @return 현재 시간과 날짜
     */
    @GetMapping("")
    public ResponseEntity getCurrentTime() {
        DefaultRes defaultRes = userService.getCurrentTime();
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
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
    public ResponseEntity getUsers(@RequestParam(value = "name", required = false)String name, @RequestParam(value = "part", required = false)String part) {
        DefaultRes defaultRes = userService.getUsers(name, part);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }

    /**
     * 현재 리스트에서 회원 id값으로 회원 검색
     * @param userIdx
     *          검색할 회원 id값
     * @return  회원 존재 유무에 따라 회원 데이터 혹은 안내문 반환
     */
    @GetMapping("users/{user_idx}")
    public ResponseEntity getUserByIdx(@PathVariable(name="user_idx")int userIdx) {
        DefaultRes defaultRes =  userService.getUserByIdx(userIdx);
        return new ResponseEntity(defaultRes, HttpStatus.OK);
    }

    /**
     * 회원 저장
     * @param user 저장할 회원 객체
     * @return 저장 완료 메세지
     */
    @PostMapping("users")
    public ResponseEntity addUser(@RequestBody final User user) {
        DefaultRes defaultRes = userService.addUser(user);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 수정 혹은 안내문 반환
     */
    @PutMapping("users/{user_idx}")
    public ResponseEntity updateUser(@PathVariable(name="user_idx")int userIdx) {
        DefaultRes defaultRes =  userService.updateUser(userIdx);
        return new ResponseEntity(defaultRes, HttpStatus.OK);
    }

    /**
     * 회원 삭제
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 삭제 혹은 안내문 반환
     */
    @DeleteMapping("users/{user_idx}")
    public ResponseEntity deleteUser(@PathVariable(name="user_idx")int userIdx) {
        DefaultRes defaultRes =  userService.deleteUser(userIdx);
        return new ResponseEntity<>(defaultRes, HttpStatus.OK);
    }
}
