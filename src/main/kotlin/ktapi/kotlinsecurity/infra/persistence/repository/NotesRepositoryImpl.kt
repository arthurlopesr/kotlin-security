package ktapi.kotlinsecurity.infra.persistence.repository

import ktapi.kotlinsecurity.domain.model.Note
import ktapi.kotlinsecurity.domain.repository.NotesRepository
import ktapi.kotlinsecurity.infra.persistence.document.NoteDocument
import org.springframework.stereotype.Repository

@Repository
class NotesRepositoryImpl(
    private val mongoNoteRepository: MongoNoteRepository
) : NotesRepository {
    override fun findAll(): List<Note> {
        return mongoNoteRepository.findAll().map {
            it.toDomain()
        }
    }

    override fun findByOwnerId(ownerId: String): List<Note> {
        return mongoNoteRepository.findByOwnerId(ownerId).map {
            it.toDomain()
        }
    }

    override fun findById(id: String): Note? {
        TODO("Not yet implemented")
    }

    override fun save(note: Note): Note {
        val noteDocument = NoteDocument.fromDomain(note)
        return mongoNoteRepository.save(noteDocument).toDomain()
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}