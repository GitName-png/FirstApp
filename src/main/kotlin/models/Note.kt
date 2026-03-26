package models

import java.time.Instant

data class Note(
    val text: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)
