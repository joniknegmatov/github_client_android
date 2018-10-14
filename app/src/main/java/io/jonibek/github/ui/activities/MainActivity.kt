package io.jonibek.github.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import io.jonibek.github.R
import io.jonibek.github.ui.fragments.RepoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(RepoListFragment.newInstance("square"))
    }

    private fun setFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commit()
    }
}
