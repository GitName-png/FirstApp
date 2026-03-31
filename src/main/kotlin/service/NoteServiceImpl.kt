package service

import models.Note
import java.time.Instant
import java.util.*

class NoteServiceImpl() : NoteService {
    var notes = mutableListOf<Note>(Note(id = 1, text = "Text"), Note(id = 2, text = "Old"), Note(id = 3))

    override fun save(note: Note): Note {
        if (note.id == 0L) {
            notes += note
            return note
        }

        val index = notes.indexOfFirst { it.id == note.id }

        if (index == -1) {
            throw IllegalArgumentException("Incorrect id")
        }

        val newNote = note.copy(createdAt = notes[index].createdAt)
        notes[index] = newNote
        return newNote
    }

    override fun getAll(): List<Note> {
        return notes.toList()
    }

    override fun getAllUniqueTexts(): List<String> {
        return notes.asSequence()
            .map { it.text }
            .distinct()
            .toList()
    }

    override fun getBefore(count: Int, id: Long): List<Note> {
        return notes.filter { it.id < id }.sortedBy { it.id }.drop(count).toList()
    }

    override fun getAfter(count: Int, id: Long): List<Note> {
        return notes.filter { it.id > id }.sortedBy { it.id }.drop(count).toList()
    }

}