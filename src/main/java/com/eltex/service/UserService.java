package com.eltex.service;

import com.eltex.exceptions.NotFoundException;
import com.eltex.models.User;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private long nextId = 1L;
    private final List<User> users = new ArrayList<>();

    public void save(final User user) {
        if (user.id() == 0) {
            final User newUser = new User(
                    nextId++,
                    user.login(),
                    user.name(),
                    user.avatar()
            );
            users.add(newUser);
        } else {
            for (int i = 0; i < users.size(); i++) {
                final User currentUser = users.get(i);
                if (currentUser.id() == user.id()) {
                    users.set(i, user);
                    break;
                }
            }
        }
    }

    public void removeById(final long userId) {
        boolean removed = users.removeIf(user -> user.id() == userId);

        if (!removed) {
            throw new NotFoundException("User not found");
        }
    }

    public User getById(final long userId) {
        for (final User user : users) {
            if (user.id() == userId) {
                return user;
            }
        }
        throw new NotFoundException("User not found");
    }

    @NotNull
    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}