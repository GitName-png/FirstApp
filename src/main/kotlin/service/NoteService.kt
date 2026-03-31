package service

import models.Note

interface NoteService {
    fun save(note: Note): Note
    fun getAll(): List<Note>
    fun getAllUniqueTexts(): List<String>
    fun getBefore(count: Int, id: Long): List<Note>
    fun getAfter(count: Int, id: Long): List<Note>
}