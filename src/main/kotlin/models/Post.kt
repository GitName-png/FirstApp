package models

import com.eltex.models.Attachment
import com.eltex.models.Coordinates
import java.time.LocalDateTime

@JvmRecord
data class Post(
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String?,
    val authorAvatar: String?,
    val content: String,
    val published: LocalDateTime,
    val coords: Coordinates?,
    val link: String?,
    val mentionedMe: Boolean,
    val likedByMe: Boolean,
    val attachment: Attachment?,
    val likes: Int,
    val original: Post?
) {
    fun isOriginal(): Boolean {
        return original == null
    }

    fun builder(): Builder {
        return Builder()
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
            .setOriginal(original)
    }

    class Builder {
        private var id: Long = 0
        private var authorId: Long = 0

        private var author = ""

        private var authorJob: String? = null

        private var authorAvatar: String? = null

        private var content = ""

        private var published: LocalDateTime = LocalDateTime.now()

        private var coords: Coordinates? = null

        private var link: String? = null

        private var mentionedMe = false
        private var likedByMe = false

        private var attachment: Attachment? = null

        private var likes = 0

        private var original: Post? = null

        fun setId(id: Long): Builder {
            this.id = id
            return this
        }

        fun setAuthorId(authorId: Long): Builder {
            this.authorId = authorId
            return this
        }

        fun setAuthor(author: String): Builder {
            this.author = author
            return this
        }

        fun setAuthorJob(authorJob: String?): Builder {
            this.authorJob = authorJob
            return this
        }

        fun setAuthorAvatar(authorAvatar: String?): Builder {
            this.authorAvatar = authorAvatar
            return this
        }

        fun setContent(content: String): Builder {
            require(!(content == null || content.trim { it <= ' ' }.isEmpty())) { "Content cannot be null or empty" }
            this.content = content
            return this
        }

        fun setPublished(published: LocalDateTime): Builder {
            this.published = published
            return this
        }

        fun setCoords(coords: Coordinates?): Builder {
            this.coords = coords
            return this
        }

        fun setLink(link: String?): Builder {
            this.link = link
            return this
        }

        fun setMentionedMe(mentionedMe: Boolean): Builder {
            this.mentionedMe = mentionedMe
            return this
        }

        fun setLikedByMe(likedByMe: Boolean): Builder {
            this.likedByMe = likedByMe
            return this
        }

        fun setAttachment(attachment: Attachment?): Builder {
            this.attachment = attachment
            return this
        }

        fun setLikes(likes: Int): Builder {
            this.likes = likes
            return this
        }

        fun setOriginal(original: Post?): Builder {
            this.original = original
            return this
        }

        fun build(): Post {
            return Post(
                id, authorId, author, authorJob, authorAvatar,
                content, published, coords, link, mentionedMe, likedByMe,
                attachment, likes, original
            )
        }
    }

    init {
        require(!(content == null || content.trim { it <= ' ' }.isEmpty())) { "Content cannot be null or empty" }
    }
}