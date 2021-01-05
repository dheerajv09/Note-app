package com.example.noteapplication.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.adapter.HeaderAdapter
import com.example.noteapplication.adapter.PageAdapter
import com.example.noteapplication.model.Note
import com.example.noteapplication.ui.all_notes.AllNotesFragment
import com.example.noteapplication.ui.archive.ArchiveNotesFragment
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        val dummyNoteData = mutableListOf(
            Note(),
            Note(id = 0,title = "dheeraj"),
            Note(id = 1,title = "verma"),
            Note(id = 2,title = "hello"),
            Note(id = 3,title = "world"),
            Note(id = 4,title = "hello world")
        )

        val recyclerView: RecyclerView = root.findViewById(R.id.fragment_home_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(true)
        val adapter = HeaderAdapter(context!!, dummyNoteData)
        recyclerView.adapter = adapter

        val pageAdapter = PageAdapter(childFragmentManager)
        pageAdapter.addFragment(AllNotesFragment(),"Notes")
        pageAdapter.addFragment(ArchiveNotesFragment(),"Reminder")

        root.viewpager.adapter = pageAdapter
        root.tablayout.setupWithViewPager(viewpager)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

