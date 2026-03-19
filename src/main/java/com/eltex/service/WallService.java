package com.eltex.service;

import com.eltex.models.Post;
import com.eltex.models.Coordinates;
import com.eltex.models.Attachment;

import java.time.LocalDateTime;

public class WallService {
    private Post post = new Post.Builder()
            .setId(0)
            .setAuthorId(0)
            .setAuthor("")
            .setAuthorJob(null)
            .setAuthorAvatar(null)
            .setContent("Content")
            .setPublished(LocalDateTime.now())
            .setCoords(null)
            .setLink(null)
            .setMentionedMe(false)
            .setLikedByMe(false)
            .setAttachment(null)
            .setLikes(0)
            .setOriginal(null)
            .build();

    public void like() {
        final int likes = post.likes() + 1;
        post = post.builder()
                .setLikes(likes)
                .build();
    }

    public void setId(final long id) {
        post = post.builder()
                .setId(id)
                .build();
    }

    public void setAuthorId(final long authorId) {
        post = post.builder()
                .setAuthorId(authorId)
                .build();
    }

    public void setAuthor(final String author) {
        post = post.builder()
                .setAuthor(author)
                .build();
    }

    public void setAuthorJob(final String authorJob) {
        post = post.builder()
                .setAuthorJob(authorJob)
                .build();
    }

    public void setAuthorAvatar(final String authorAvatar) {
        post = post.builder()
                .setAuthorAvatar(authorAvatar)
                .build();
    }

    public void setContent(final String content) {
        post = post.builder()
                .setContent(content)
                .build();
    }

    public void setPublished(final LocalDateTime published) {
        post = post.builder()
                .setPublished(published)
                .build();
    }

    public void setCoords(final Coordinates coords) {
        post = post.builder()
                .setCoords(coords)
                .build();
    }

    public void setLink(final String link) {
        post = post.builder()
                .setLink(link)
                .build();
    }

    public void setMentionedMe(final boolean mentionedMe) {
        post = post.builder()
                .setMentionedMe(mentionedMe)
                .build();
    }

    public void setLikedByMe(final boolean likedByMe) {
        post = post.builder()
                .setLikedByMe(likedByMe)
                .build();
    }

    public void setAttachment(final Attachment attachment) {
        post = post.builder()
                .setAttachment(attachment)
                .build();
    }

    public void setLikes(final int likes) {
        post = post.builder()
                .setLikes(likes)
                .build();
    }

    public void setOriginal(final Post original) {
        post = post.builder()
                .setOriginal(original)
                .build();
    }

    public Post getPost() {
        return post;
    }
}