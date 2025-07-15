package com.mycompany.userregistr.validator;

import com.mycompany.userregistr.exceptions.ValidationException;
import com.mycompany.userregistr.web.dto.AppUserCreateDto;
import org.apache.commons.lang3.StringUtils;

public class UserValidatorImpl implements UserValidator {
    @Override
    public void validateUserCredentials(String email, String password) {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new ValidationException("Invalid credentials: " + email);
        }
    }
    @Override
    public void validateNewUser(AppUserCreateDto createDto) {
        validateUserCredentials(createDto.getEmail(), createDto.getPassword());
        if (StringUtils.isEmpty(createDto.getName())) {
            throw new ValidationException("Invalid user name: " + createDto.getName());
        }
    }
}
