package ktapi.kotlinsecurity.app.dto

import ktapi.kotlinsecurity.domain.model.Note
import java.time.Instant
import java.util.UUID

data class NoteRequestDTO(
    val id: String?,
    val title: String,
    val content: String,
    val color: String,
    val ownerId: UUID
) {
    fun toDomain(): Note {
        return Note(
            id = id,
            title = title,
            content = content,
            color = color,
            createdAt = Instant.now(),
            ownerId = ownerId
        )
    }
}
