package ktapi.kotlinsecurity.infra.usecase

import ktapi.kotlinsecurity.domain.model.Note

interface CreateNoteUseCase {
    fun createNote(note: Note): Note
}