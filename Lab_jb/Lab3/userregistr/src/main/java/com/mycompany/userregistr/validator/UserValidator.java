package com.mycompany.userregistr.validator;

import com.mycompany.userregistr.web.dto.AppUserCreateDto;

public interface UserValidator {
    void validateUserCredentials(String email, String password);
    void validateNewUser(AppUserCreateDto createDto);
}
