package com.eltex.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record User(long id, @NotNull String login,
                   @NotNull String name, @Nullable String avatar) {
}
