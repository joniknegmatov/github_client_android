package io.jonibek.github.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.jonibek.github.R
import io.jonibek.github.model.Repo
import java.util.ArrayList

class RepoRecyclerAdapter : RecyclerView.Adapter<RepoRecyclerAdapter.RepoViewHolder>() {


    private val repoList = ArrayList<Repo>()

    fun setRepos(repoList1: List<Repo>) {
        this.repoList.clear()
        this.repoList.addAll(repoList1)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repoList[position]
        holder.tvTitle.text = repo.name
        holder.tvStars.text = repo.stargazersCount.toString()
        holder.tvForks.text = repo.forksCount.toString()
    }

    inner class RepoViewHolder(view: View,
                               val tvTitle: TextView = view.findViewById(R.id.tvTitle),
                               val tvStars: TextView = view.findViewById(R.id.tvStars),
                               val tvForks: TextView = view.findViewById(R.id.tvForks))
        : RecyclerView.ViewHolder(view)
}