package ktapi.kotlinsecurity.domain.repository

import ktapi.kotlinsecurity.domain.model.Note

interface NotesRepository {
    fun findAll(): List<Note>
    fun findById(id: String): Note?
    fun save(note: Note): Note
    fun deleteById(id: String)
    fun findByOwnerId(ownerId: String): List<Note>
}