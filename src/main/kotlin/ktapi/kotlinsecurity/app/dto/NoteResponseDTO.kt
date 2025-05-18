package ktapi.kotlinsecurity.app.dto

import ktapi.kotlinsecurity.domain.model.Note

data class NoteResponseDTO(
    val id: String,
    val title: String,
    val content: String,
    val color: String,
    val createdAt: String,
    val ownerId: String
) {
    companion object {
        fun fromDomain(note: Note): NoteResponseDTO {
            return NoteResponseDTO(
                id = note.id.toString(),
                title = note.title,
                content = note.content,
                color = note.color,
                createdAt = note.createdAt.toString(),
                ownerId = note.ownerId.toString()
            )
        }
    }
}
