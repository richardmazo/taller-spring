package com.ms.user.controller.v1;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody @Valid UserDto userDto){
        return this.iUserService.save(userDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserEntity> getByEmail(@PathVariable String email){
        return this.iUserService.getByEmail(email);
    }

}
