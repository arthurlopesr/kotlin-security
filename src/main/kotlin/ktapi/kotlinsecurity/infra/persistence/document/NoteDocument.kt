package ktapi.kotlinsecurity.infra.persistence.document

import ktapi.kotlinsecurity.domain.model.Note
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "notes")
data class NoteDocument(
    @Id
    val id: ObjectId = ObjectId.get(),
    @Indexed(unique = true)
    val title: String,
    val content: String,
    val color: String,
    val createdAt: Instant,
    val ownerId: String
) {
    fun toDomain() = Note(
        id = id.toHexString(),
        title = title,
        content = content,
        color = color,
        createdAt = createdAt,
        ownerId = ownerId
    )

    companion object {
        fun fromDomain(note: Note) = NoteDocument(
            id = note.id?.let { ObjectId(it) } ?: ObjectId.get(),
            title = note.title,
            content = note.content,
            color = note.color,
            createdAt = note.createdAt,
            ownerId = note.ownerId
        )
    }
}