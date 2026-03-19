package com.eltex.models;

import org.jetbrains.annotations.Nullable;

public record Attachment(@Nullable String url, @Nullable AttachmentType type) {
}