package com.example.noteapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.noteapplication.ui.archive.ArchiveNotesFragment
import com.example.noteapplication.ui.delete.DeletedNotesFragment
import com.example.noteapplication.ui.home.HomeFragment

class BottomNavigationBarPageViewAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                ArchiveNotesFragment()
            }
            2 -> {
                ArchiveNotesFragment()
            }
            3 -> {
                DeletedNotesFragment()
            }
            4 -> {
                HomeFragment()
            }
            else -> null!!
        }
    }

    override fun getCount(): Int {
        return 5
    }
}