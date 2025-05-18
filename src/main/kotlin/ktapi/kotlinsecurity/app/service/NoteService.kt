package ktapi.kotlinsecurity.app.service

import ktapi.kotlinsecurity.domain.model.Note
import ktapi.kotlinsecurity.domain.repository.NotesRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteRepository: NotesRepository
) {
    fun findByOwnerId(ownerId: String): List<Note> {
        return noteRepository.findByOwnerId(ownerId)
    }

    fun findById(noteId: String): Note? {
        validateHasNoteIdIsValid(noteId)
        return noteRepository.findById(noteId)
    }

    fun deleteById(noteId: String) {
        validateHasNoteIdIsValid(noteId)
        noteRepository.deleteById(noteId)
    }

    private fun validateHasNoteIdIsValid(noteId: String) {
        if (!ObjectId.isValid(noteId)) {
            throw IllegalArgumentException("Note ID is not valid")
        }
    }
}