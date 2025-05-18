package ktapi.kotlinsecurity.app.service

import ktapi.kotlinsecurity.domain.model.Note
import ktapi.kotlinsecurity.domain.repository.NotesRepository
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NotesRepository
) {
    fun findByOwnerId(ownerId: String): List<Note> {
        return noteRepository.findByOwnerId(ownerId)
    }
}