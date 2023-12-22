package kz.course.lesson12homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildRecyclerViewAdapter(private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildViewHolder>() {

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.childLogoImageView)
        val childTitle: TextView = itemView.findViewById(R.id.childTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ChildRecyclerViewAdapter.ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.imageView.setImageResource(childItemList[position].image)
        holder.childTitle.text = childItemList[position].title
    }
}