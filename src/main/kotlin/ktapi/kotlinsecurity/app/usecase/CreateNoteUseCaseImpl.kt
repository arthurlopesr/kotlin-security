package ktapi.kotlinsecurity.app.usecase

import ktapi.kotlinsecurity.domain.exception.DataAlreadyExistsException
import ktapi.kotlinsecurity.domain.model.Note
import ktapi.kotlinsecurity.domain.repository.NotesRepository
import ktapi.kotlinsecurity.infra.usecase.CreateNoteUseCase
import org.springframework.stereotype.Service

@Service
class CreateNoteUseCaseImpl(
    private val notesRepository: NotesRepository
) : CreateNoteUseCase {

    override fun createNote(note: Note): Note {
        val existingNote = notesRepository.findByTitle(note.title)
        if (existingNote != null) {
            throw DataAlreadyExistsException("Note with title ${note.title} already exists")
        }
        return notesRepository.save(note)
    }
}