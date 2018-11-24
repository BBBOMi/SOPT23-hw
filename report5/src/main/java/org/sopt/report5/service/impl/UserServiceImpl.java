package org.sopt.report5.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report5.mapper.UserMapper;
import org.sopt.report5.model.DefaultRes;
import org.sopt.report5.dto.User;
import org.sopt.report5.model.SignUpReq;
import org.sopt.report5.service.S3FileUploadService;
import org.sopt.report5.service.UserService;
import org.sopt.report5.utils.ResponseMessage;
import org.sopt.report5.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by bomi on 2018-11-01.
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final S3FileUploadService s3FileUploadService;

    public UserServiceImpl(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.userMapper = userMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    /**
     * 현재 시간과 날짜 조회
     * @return 현재 시간과 날짜
     */
    @Override
    public DefaultRes getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String current = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return DefaultRes.res(StatusCode.OK, ResponseMessage.TIME_SUCCESS, current);
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
    public DefaultRes getUsers(final String name, final String part) {
        List<User> list;
        if(!StringUtils.isEmpty(name)) {
            list = userMapper.findUserByName(name);
        } else if(!StringUtils.isEmpty(part)) {
           list = userMapper.findUserByPart(part);
        } else {
            list = userMapper.findAll();
        }

        if(list.isEmpty()) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, list);
        }
    }

    /**
     * 현재 리스트에서 회원 id값으로 회원 검색
     * @param userIdx
     *          검색할 회원 id값
     * @return  회원 존재 유무에 따라 회원 데이터 혹은 안내문 반환
     */
    @Override
    public DefaultRes getUserByIdx(final int userIdx) {
       User user = userMapper.findByUserIdx(userIdx);
       if(user != null) {
           return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_USER, user);
       } else {
           return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
       }
    }

    /**
     * 회원 가입
     * @param signUpReq
     *      가입할 회원 데이터
     * @return 상태코드와 메세지, 결과 데이터를 가지고 있는 DefaultRes
     */
    @Override
    @Transactional
    public DefaultRes addUser(final SignUpReq signUpReq) {
        try {
            if(signUpReq.getProfile() != null) {
                signUpReq.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
            }
            userMapper.save(signUpReq);
            return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    /**
     * 회원 정보 수정
     * @param userIdx
     *          회원 아이디
     * @return 회원 존재 유무에 따라 수정 혹은 안내문 반환
     */
    @Override
    @Transactional
    public DefaultRes updateUser(int userIdx, final SignUpReq signUpReq) {
        final User user = userMapper.findByUserIdx(userIdx);
        if(user == null) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            try {
                if(signUpReq.getProfile() != null) {
                    // 확인 해보기
                    user.setProfileUrl(s3FileUploadService.upload(signUpReq.getProfile()));
                }
                if(signUpReq.getName() != null) {
                    user.setName(signUpReq.getName());
                }
                if(signUpReq.getPart() != null) {
                    user.setPart(signUpReq.getPart());
                }

                userMapper.update(userIdx, signUpReq);
                return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.UPDATE_USER);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error(e.getMessage());
                return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
            }
        }
    }

    /**
     * 회원 삭제
     * @param userIdx
     *          회원 아이디
     * @return DefaultRes 객체
     */
    @Override
    @Transactional
    public DefaultRes deleteUser(final int userIdx) {
        final User user = userMapper.findByUserIdx(userIdx);
        if(user == null) {
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);
        } else {
            try {
                userMapper.delete(userIdx);
                return DefaultRes.res(StatusCode.NO_CONTENT, ResponseMessage.DELETE_USER);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error(e.getMessage());
                return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
            }
        }
    }
}
