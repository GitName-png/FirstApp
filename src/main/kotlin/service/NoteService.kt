package service

import models.Note
import java.time.Instant

class NoteService() {
    private var note: Note = Note(
        text = "",
        createdAt = Instant.now(),
        updatedAt = Instant.now()
    )

    fun updateText(text: String) {
        note = note.copy(text=text, updatedAt = Instant.now())
    }

    fun getNote(): Note {
        return note
    }
}