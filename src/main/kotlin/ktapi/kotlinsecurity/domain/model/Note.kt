package ktapi.kotlinsecurity.domain.model

import java.time.Instant
import java.util.UUID

data class Note(
    val id: String?,
    val title: String,
    val content: String,
    val color: String,
    val createdAt: Instant,
    val ownerId: UUID? = null
)
