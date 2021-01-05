package com.example.noteapplication.ui.delete

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.R

class DeletedNotesFragment : Fragment() {

    companion object {
        fun newInstance() = DeletedNotesFragment()
    }

    private lateinit var viewModel: DeletedNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.deleted_notes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeletedNotesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}