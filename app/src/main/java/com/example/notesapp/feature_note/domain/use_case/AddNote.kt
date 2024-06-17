package com.example.notesapp.feature_note.domain.use_case

import com.example.notesapp.feature_note.domain.model.InvalidNoteException
import com.example.notesapp.feature_note.domain.model.Note
import com.example.notesapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
){

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The tile can't be Empty")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content can't be Empty")
        }
        repository.insertNote(note)
    }
}