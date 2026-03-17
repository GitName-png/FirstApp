package com.eltex;

import java.time.LocalDateTime;

public record Post(long id, long authorId, String author,
                   String authorJob, String authorAvatar, String content,
                   LocalDateTime published, String link,
                   boolean mentionedMe, boolean likedByMe, int likes) {

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
                .setLink(link)
                .setMentionedMe(mentionedMe)
                .setLikedByMe(likedByMe)
                .setLikes(likes);
    }

    public static class Builder {
        private long id = 0;
        private long authorId = 0;
        private String author = "";
        private String authorJob;
        private String authorAvatar;
        private String content = "";
        private LocalDateTime published = LocalDateTime.now();
        private String link;
        private boolean mentionedMe = false;
        private boolean likedByMe = false;
        private int likes = 0;

        public Builder setId(final long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(final long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthor(final String author) {
            this.author = author;
            return this;
        }

        public Builder setAuthorJob(final String authorJob) {
            this.authorJob = authorJob;
            return this;
        }

        public Builder setAuthorAvatar(final String authorAvatar) {
            this.authorAvatar = authorAvatar;
            return this;
        }

        public Builder setContent(final String content) {
            if (content == null || content.trim().isEmpty()) {
                throw new IllegalArgumentException("Content cannot be null or empty");
            }
            this.content = content;
            return this;
        }

        public Builder setPublished(final LocalDateTime published) {
            this.published = published;
            return this;
        }

        public Builder setLink(final String link) {
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

        public Builder setLikes(final int likes) {
            this.likes = likes;
            return this;
        }

        public Post build() {
            return new Post(id, authorId, author, authorJob, authorAvatar,
                    content, published, link, mentionedMe, likedByMe, likes);
        }
    }
}