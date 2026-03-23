package com.eltex;


import com.eltex.exceptions.NotFoundException;
import com.eltex.models.Attachment;
import com.eltex.models.AttachmentType;
import com.eltex.models.User;
import com.eltex.service.UserService;
import com.eltex.service.WallService;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = new User(0, "login1", "name1", "avatar1");
        User user2 = new User(1, "login2", "name2", "avatar2");

        userService.save(user1);
        userService.save(user2);
        userService.save(user1);

        try {
            userService.removeById(0);
        } catch (NotFoundException notFoundException) {
            System.out.println(notFoundException);
        }

        System.out.println(userService.getAll());
    }
}