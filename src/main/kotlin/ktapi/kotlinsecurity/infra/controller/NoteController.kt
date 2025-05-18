package ktapi.kotlinsecurity.infra.controller

import ktapi.kotlinsecurity.app.dto.NoteRequestDTO
import ktapi.kotlinsecurity.app.dto.NoteResponseDTO
import ktapi.kotlinsecurity.app.service.NoteService
import ktapi.kotlinsecurity.infra.usecase.CreateNoteUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(
    private val noteService: NoteService,
    private val createNoteUseCase: CreateNoteUseCase
) {

    @PostMapping
    fun createNote(@RequestBody body: NoteRequestDTO): ResponseEntity<NoteResponseDTO> {
        val note = body.toDomain()
        val savedNote = createNoteUseCase.createNote(note)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(NoteResponseDTO.fromDomain(savedNote))
    }

    @GetMapping
    fun getNotesByOwnerId(@RequestParam ownerId: String): ResponseEntity<List<NoteResponseDTO>> {
        val notes = noteService.findByOwnerId(ownerId)
        val response = notes.map { NoteResponseDTO.fromDomain(it) }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{noteId}")
    fun getNoteById(@PathVariable noteId: String): ResponseEntity<NoteResponseDTO> {
        val note = noteService.findById(noteId) ?: return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        return ResponseEntity.ok(NoteResponseDTO.fromDomain(note))
    }

    @DeleteMapping("/{noteId}")
    fun deleteNoteById(@PathVariable noteId: String): ResponseEntity<Void> {
        noteService.deleteById(noteId)
        return ResponseEntity.noContent().build()
    }
}