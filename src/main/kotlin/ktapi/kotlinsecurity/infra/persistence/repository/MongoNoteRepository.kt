package ktapi.kotlinsecurity.infra.persistence.repository

import ktapi.kotlinsecurity.infra.persistence.document.NoteDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoNoteRepository : MongoRepository<NoteDocument, ObjectId> {
    fun findByOwnerId(ownerId: String): List<NoteDocument>
}
