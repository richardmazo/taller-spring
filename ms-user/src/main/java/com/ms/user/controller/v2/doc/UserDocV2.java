package com.ms.user.controller.v2.doc;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v2/user")
public interface UserDocV2 {

    @PostMapping
    ResponseEntity<UserEntity> create(@RequestBody @Valid UserDto userDto);

}



