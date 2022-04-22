import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beyzaakkuzu.noteapp.feature.domain.model.Note
import com.beyzaakkuzu.noteapp.feature.domain.use_case.NoteUseCases
import com.beyzaakkuzu.noteapp.feature.domain.util.NoteOrder
import com.beyzaakkuzu.noteapp.feature.domain.util.OrderType
import com.beyzaakkuzu.noteapp.feature.presentation.notes.NoteState
import com.beyzaakkuzu.noteapp.feature.presentation.notes.NotesEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel(){
    private val _state= mutableStateOf<NoteState>(NoteState())
    val state: State<NoteState> =_state
    private var getNotesJob: Job? =null
    private var recentlyDeleteNote: Note? =null

    init{
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order ->{
                if(state.value.noteOrder::class== event.noteOrder::class &&
                        state.value.noteOrder.orderType==event.noteOrder.orderType){
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote ->{
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeleteNote= event.note
                }
            }
            is NotesEvent.RestoreNote ->{
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeleteNote?: return@launch)
                    recentlyDeleteNote=null}

            }
            is NotesEvent.ToggleOrderSection ->{
                _state.value=state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob= noteUseCases.getNotes(noteOrder).onEach { notes ->
            _state.value= state.value.copy(
                notes= notes,
                noteOrder= noteOrder
            )
        }
            .launchIn(viewModelScope)

    }
}