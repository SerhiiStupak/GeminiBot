package com.mycompany.userregistr.dao;

import com.mycompany.userregistr.model.AppUser;

public interface AppUserDao {
    AppUser create(AppUser user);
    AppUser getByEmail(String email);
    AppUser findByEmailAndPassword(String email, String password);
}
