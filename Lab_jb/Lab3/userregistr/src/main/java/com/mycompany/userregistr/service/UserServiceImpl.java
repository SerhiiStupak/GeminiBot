package com.mycompany.userregistr.service;

import com.mycompany.userregistr.converter.AppUserConverter;
import com.mycompany.userregistr.dao.AppUserDao;
import com.mycompany.userregistr.dao.AppUserDaoImpl;
import com.mycompany.userregistr.model.AppUser;
import com.mycompany.userregistr.validator.UserValidator;
import com.mycompany.userregistr.validator.UserValidatorImpl;
import com.mycompany.userregistr.web.dto.AppUserCreateDto;
import com.mycompany.userregistr.web.dto.AppUserViewDto;

public class UserServiceImpl implements UserService {
    private AppUserDao appUserDao = new AppUserDaoImpl();

    private AppUserConverter appUserConverter = new AppUserConverter();
    private UserValidator userValidator = new UserValidatorImpl();


    @Override
    public AppUserViewDto registerUser(AppUserCreateDto createDto) {
        userValidator.validateNewUser(createDto);
        AppUser user = appUserConverter.asAppUser(createDto);
        user = appUserDao.create(user);
        return appUserConverter.asUserDto(user);
    }
}
