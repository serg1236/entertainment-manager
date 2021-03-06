package com.epam.spring.core.service.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.spring.core.model.User;
import com.epam.spring.core.service.UserService;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    private static User user;

    @BeforeClass
    public static void init() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        user = new User("Jon Snow", "wall@westeros.com", cal.getTime());
    }

    @Test
    public void registerUser() {
        userService.register(user);
        assertEquals(user.getName(), userService.getUserByEmail(user.getEmail()).getName());
    }

    @Test
    public void getById() {
        userService.register(user);
        User user1 = userService.getUserByEmail(user.getEmail());
        assertEquals(user1.getName(), userService.getById(user1.getId()).getName());
    }

    @Test
    public void getByName() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        User user2 = new User("Jon Snow", "wall@westeros.com", cal.getTime());
        userService.register(user);
        userService.register(user2);
        assertEquals(2, userService.getUsersByName("Jon Snow").size());
    }


}
