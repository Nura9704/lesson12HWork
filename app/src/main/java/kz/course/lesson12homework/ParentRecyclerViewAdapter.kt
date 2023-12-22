package kz.course.lesson12homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ParentRecyclerViewAdapter() :
    RecyclerView.Adapter<ParentRecyclerViewAdapter.ParentViewHolder>() {

    private var parentItemList: ArrayList<ParentItem> = ArrayList()
    fun updateArrayList(parentItemList: ArrayList<ParentItem>) {
        this.parentItemList.clear()
        this.parentItemList=parentItemList
        notifyDataSetChanged()
    }
    class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentTitle: TextView = itemView.findViewById(R.id.parentTitleTextView)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return ParentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentItemList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = parentItemList[position]
        holder.parentTitle.text = parentItem.title

        val adapter = ChildRecyclerViewAdapter(parentItem.childItemList)
        holder.childRecyclerView.adapter = adapter

        //expandable condition
        val isExpandable = parentItem.isExpandable
        holder.childRecyclerView.visibility = if (isExpandable) {
            View.VISIBLE
        } else {
            View.GONE
        }

        // if any Item is expanded, it will collapse it. If any Item is not Expanded, it will expanded
        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            parentItem.isExpandable = !parentItem.isExpandable
            notifyItemChanged(position)
        }

    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = parentItemList.indexOfFirst {
            it.isExpandable
        }

        if (temp >= 0 && temp != position) {
            parentItemList[temp].isExpandable = false
            notifyItemChanged(temp)
        }
    }
}