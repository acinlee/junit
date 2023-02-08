package com.tdd.junit.junittest.controller;

import com.tdd.junit.junittest.model.dao.UserMapper;
import com.tdd.junit.junittest.model.vo.ActorVO;
import com.tdd.junit.junittest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Slf4j
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    UserMapper userMapper;

    private final ArrayList<ActorVO> actorList = new ArrayList<>();

    private ActorVO actor;

    @BeforeEach
    void setActorList() {
        ActorVO actorVO1 = ActorVO.builder()
                .actorId("1")
                .firstName("PENELOPE")
                .lastName("GUINESS")
                .lastUpdate("2006-02-15 04:34:33")
                .build();
        ActorVO actorVO2 = ActorVO.builder()
                .actorId("2")
                .firstName("NICK")
                .lastName("WAHLBERG")
                .lastUpdate("2006-02-15 04:34:33")
                .build();
        this.actorList.add(actorVO1);
        this.actorList.add(actorVO2);
    }

    @BeforeEach
    void setActor() {
        this.actor = ActorVO.builder()
                .actorId("1")
                .firstName("PENELOPE")
                .lastName("GUINESS")
                .lastUpdate("2006-02-15 04:34:33")
                .build();
    }


    @Test
    @DisplayName("findAll test")
    void findAll() throws Exception {
        log.info("#### controller findAll test start ###");

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        given(userService.findAll()).willReturn(actorList);

        // when
        final ResultActions actions = mockMvc.perform(get("/findAll"))
                .andDo(print());

        // then
        // andExpect : 기대하는 값이 나왔는지 체크해 볼 수 있는 메소드
        actions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$..['actorId']").exists())
                .andExpect(jsonPath("$..['firstName']").exists())
                .andExpect(jsonPath("$..['lastName']").exists())
                .andExpect(jsonPath("$..['lastUpdate']").exists())
                .andDo(print());

        log.info("#### controller findAll test end ###");
    }

    @Test
    @DisplayName("findActor test")
    void findActor() throws Exception {
        log.info("#### controller findActor test start ###");

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
        given(userService.findActor("1")).willReturn(actor);

        // when
        final ResultActions actions = mockMvc.perform(get("/findActor?actorId=1"))
                .andDo(print());

        // then
        // andExpect : 기대하는 값이 나왔는지 체크해 볼 수 있는 메소드
        actions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$..['actorId']").exists())
                .andExpect(jsonPath("$..['firstName']").exists())
                .andExpect(jsonPath("$..['lastName']").exists())
                .andExpect(jsonPath("$..['lastUpdate']").exists())
                .andExpect(jsonPath("$['resultCode']").value("S0001"))
                .andDo(print());

        log.info("#### controller findActor test end ###");
    }
}
