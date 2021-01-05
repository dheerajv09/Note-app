package com.example.noteapplication.ui.archive

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.R

class ArchiveNotesFragment : Fragment() {

    companion object {
        fun newInstance() = ArchiveNotesFragment()
    }

    private lateinit var viewModel: ArchiveNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.archive_notes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArchiveNotesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}