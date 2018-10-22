package io.jonibek.github.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

import io.jonibek.github.R


class RepoFragment : MvpAppCompatFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }


    companion object {

        const val  REPO_ID = "REPO_ID"

        fun getInstance(repoId: Int): RepoFragment {
            val fragment = RepoFragment()
            val arguments = Bundle()
            arguments.putInt(REPO_ID, repoId)
            fragment.arguments = arguments
            return fragment
        }
    }


}
