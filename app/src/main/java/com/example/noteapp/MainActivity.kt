package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.db.NoteDatabase
import com.example.noteapp.repository.NoteRepository
import com.example.noteapp.viewmodel.NoteViewModel
import com.example.noteapp.viewmodel.NoteViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    //activities interact with the user

    /*
    The Data Binding Library generates binding classes that are used to access the layout's variables and views
    The generated binding class links the layout variables with the views within the layout
    The name of the class is based on the name of the layout file
    This class holds all the bindings from the layout properties
     */
    private lateinit var binding: ActivityMainBinding

    lateinit var noteViewModel: NoteViewModel

    //onCreate(Bundle) is where we initialize your activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        The binding object is created immediately after inflating the layout to ensure
        that the view hierarchy isn't modified before it binds to the views with expressions within the layout
        */
        //this creates an instance of the binding class for the activity to use.
        binding = ActivityMainBinding.inflate(layoutInflater)

//Activity class takes care of creating a window for us in which we can place our UI with setContentView(View)
        //render our layout on the screen.
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()

    }


    private fun setUpViewModel(){
        val noteRepository = NoteRepository(
            NoteDatabase(this)
        )

        val viewModelProviderFactory =
            NoteViewModelProviderFactory(
                application,
                noteRepository
            )

        //ViewModelProvider: An utility class that provides ViewModels for a scope.
        //Creates ViewModelProvider, which will create ViewModels via the given Factory
        // and retain them in a store of the given ViewModelStoreOwner.
        noteViewModel=ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(NoteViewModel::class.java)
    }
}