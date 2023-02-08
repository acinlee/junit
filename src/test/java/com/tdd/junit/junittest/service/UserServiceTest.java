package com.tdd.junit.junittest.service;

import com.tdd.junit.junittest.model.dao.UserMapper;
import com.tdd.junit.junittest.model.vo.ActorVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Spy
    @InjectMocks
    private UserService userService;

    @Test
    void findAll() {
    }

    @Test
    @DisplayName("findActor Mock 주입 테스트")
    void findActorByMock() {
        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        // mock 객체인 userMapper에 대해 객체 생성 요청시 동작을 미리 선언
//        given(userMapper.findActor("1")).willReturn(ActorVO.builder()
//                        .actorId("1")
//                        .firstName("PENELOPE")
//                        .lastName("GUINESS")
//                        .lastUpdate("2006-02-15 04:34:33").build());
//
//        // when
//        ActorVO actor = userService.findActor("1");
//
//        // then
//        Mockito.verify(userMapper, Mockito.times(1)).findActor("1");
//        assertEquals(actor.getFirstName(), "PENELOPE");
    }

    @Test
    @DisplayName("findActor Spy 주입 테스트")
    void findActorBySpy() {
        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        // mock 객체인 userMapper에 대해 객체 생성 요청시 동작을 미리 선언

        // when
        ActorVO actor = userService.findActor("1");

        // then
        Mockito.verify(userService, Mockito.times(1)).findActor("1");
        assertEquals(actor.getFirstName(), "PENELOPE");
    }
}
