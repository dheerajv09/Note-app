package com.example.noteapplication.ui.note_labels

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.R

class NoteLabelsFragment : Fragment() {

    companion object {
        fun newInstance() = NoteLabelsFragment()
    }

    private lateinit var viewModel: NoteLabelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_labels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoteLabelsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}