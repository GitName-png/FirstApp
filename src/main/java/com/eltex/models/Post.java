package com.eltex.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

public record Post(long id, long authorId, @NotNull String author,
                   @Nullable String authorJob, @Nullable String authorAvatar,
                   @NotNull String content, @NotNull LocalDateTime published,
                   @Nullable Coordinates coords, @Nullable String link,
                   boolean mentionedMe, boolean likedByMe,
                   @Nullable Attachment attachment, int likes,
                   @Nullable Post original) {

    public boolean isOriginal() {
        return original == null;
    }

    public Post {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
    }

    public Builder builder() {
        return new Builder()
                .setId(id)
                .setAuthorId(authorId)
                .setAuthor(author)
                .setAuthorJob(authorJob)
                .setAuthorAvatar(authorAvatar)
                .setContent(content)
                .setPublished(published)
                .setCoords(coords)
                .setLink(link)
                .setMentionedMe(mentionedMe)
                .setLikedByMe(likedByMe)
                .setAttachment(attachment)
                .setLikes(likes)
                .setOriginal(original);
    }

    public static class Builder {
        private long id = 0;
        private long authorId = 0;

        @NotNull
        private String author = "";

        @Nullable
        private String authorJob;

        @Nullable
        private String authorAvatar;

        @NotNull
        private String content = "";

        @NotNull
        private LocalDateTime published = LocalDateTime.now();

        @Nullable
        private Coordinates coords;

        @Nullable
        private String link;

        private boolean mentionedMe = false;
        private boolean likedByMe = false;

        @Nullable
        private Attachment attachment;

        private int likes = 0;

        @Nullable
        private Post original = null;

        public Builder setId(final long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(final long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthor(@NotNull final String author) {
            this.author = author;
            return this;
        }

        public Builder setAuthorJob(@Nullable final String authorJob) {
            this.authorJob = authorJob;
            return this;
        }

        public Builder setAuthorAvatar(@Nullable final String authorAvatar) {
            this.authorAvatar = authorAvatar;
            return this;
        }

        public Builder setContent(@NotNull final String content) {
            if (content == null || content.trim().isEmpty()) {
                throw new IllegalArgumentException("Content cannot be null or empty");
            }
            this.content = content;
            return this;
        }

        public Builder setPublished(@NotNull final LocalDateTime published) {
            this.published = published;
            return this;
        }

        public Builder setCoords(@Nullable final Coordinates coords) {
            this.coords = coords;
            return this;
        }

        public Builder setLink(@Nullable final String link) {
            this.link = link;
            return this;
        }

        public Builder setMentionedMe(final boolean mentionedMe) {
            this.mentionedMe = mentionedMe;
            return this;
        }

        public Builder setLikedByMe(final boolean likedByMe) {
            this.likedByMe = likedByMe;
            return this;
        }

        public Builder setAttachment(@Nullable final Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder setLikes(final int likes) {
            this.likes = likes;
            return this;
        }

        public Builder setOriginal(@Nullable final Post original) {
            this.original = original;
            return this;
        }

        public Post build() {
            return new Post(id, authorId, author, authorJob, authorAvatar,
                    content, published, coords, link, mentionedMe, likedByMe,
                    attachment, likes, original);
        }
    }
}