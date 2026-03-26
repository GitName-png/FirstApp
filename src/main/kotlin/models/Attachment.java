package models;

import com.eltex.models.AttachmentType;
import org.jetbrains.annotations.Nullable;

public record Attachment(@Nullable String url, @Nullable AttachmentType type) {
}