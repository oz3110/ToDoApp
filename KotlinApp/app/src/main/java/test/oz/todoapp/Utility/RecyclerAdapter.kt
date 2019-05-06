package test.oz.todoapp.Utility

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.oz.todoapp.R

class RecyclerAdapter(private val context : Context?, private val itemClickListener : RecyclerViewHolder.ItemClickListener, private val itemList : List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    private var mRecyclerView : RecyclerView? = null
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }

    // ここでカードビュー内のテキストビューに文字をセットしている
    // リスト型で受けるならまあ・・・？
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.let {
            it.itemTextView.text = itemList.get(position)
        }
    }

    override fun getItemCount() : Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val layoutView = layoutInflater.inflate(R.layout.todo_cardview, parent, false)
        layoutView.setOnClickListener(){ view ->
            mRecyclerView?.let{
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }
        return RecyclerViewHolder(layoutView)
    }
}