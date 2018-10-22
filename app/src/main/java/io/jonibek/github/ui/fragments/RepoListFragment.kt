package io.jonibek.github.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import io.jonibek.github.R
import io.jonibek.github.model.Repo
import io.jonibek.github.presenters.RepoListPresenter
import io.jonibek.github.ui.activities.MainActivity
import io.jonibek.github.ui.adapters.RepoRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_repo_list.*

class RepoListFragment : MvpAppCompatFragment(), RepoListView, RepoRecyclerAdapter.OnRepoClickListener {


    private lateinit var repoRecyclerAdapter: RepoRecyclerAdapter
    private lateinit var name: String

    @InjectPresenter
    lateinit var presenter: RepoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = arguments!!.getString("name")
        }

        repoRecyclerAdapter = RepoRecyclerAdapter(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        toolbar.title = name
        rvRepos.adapter = repoRecyclerAdapter
        rvRepos.layoutManager = LinearLayoutManager(context)
        presenter.updateRepos(name)
        presenter.getRepos(name)
    }


    override fun setRepos(repoList: List<Repo>) {
        repoRecyclerAdapter.setRepos(repoList)
    }

    override fun onItemClick(repo: Repo) {
        (activity as MainActivity).openRepoFullInfo(repo.id)
    }

    companion object {
        fun newInstance(name: String): RepoListFragment {
            val fragment = RepoListFragment()
            val arguments = Bundle()
            arguments.putString("name", name)
            fragment.arguments = arguments
            return fragment
        }
    }
}
