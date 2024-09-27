package com.ms.user.controller.v2;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class UserControllerV2Test {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserControllerV2 userControllerV2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateNewUser() {

        UserDto userDto = UserDto
                .builder()
                .email("richard@hotmail.com")
                .name("Richard")
                .document("123456789")
                .status(true)
                .lastname("Mazo")
                .build();

        var newUser = UserEntity
                .builder()
                .id("")
                .email("email@otmail.com")
                .name("Richard")
                .document("123456789")
                .status(true)
                .lastname("Mazo")
                .build();

        var responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        var responseBody = responseEntity.getBody();

        when(userService.save(userDto)).thenReturn(responseEntity);

        userControllerV2.create(userDto);

        assertNotNull(responseBody);
        assertEquals(responseBody.getDocument(), "123456789");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);


    }


}