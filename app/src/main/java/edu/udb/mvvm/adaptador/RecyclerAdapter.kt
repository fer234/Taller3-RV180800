package edu.udb.mvvm.adaptador

//for Context
import android.content.Context
//for RecyclerView
import androidx.recyclerview.widget.RecyclerView
//For view
import android.view.View
//For ViewGroup
import android.view.ViewGroup
//For LayoutInflater
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
//For Toast popup
import android.widget.Toast
//For TextView
import android.widget.TextView

//For Resource
import edu.udb.mvvm.R
import edu.udb.mvvm.viewmodels.MainViewModel
import edu.udb.mvvm.model.Registro

class RecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<Registro>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitem,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if (arrayList.size == 0) {
            Toast.makeText(context, "Lista vacia", Toast.LENGTH_LONG).show()
        } else {

        }
        return arrayList.size
    }
    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: Registro){
            binding.findViewById<TextView>(R.id.title).text = blog.title
            binding.findViewById<ImageButton>(R.id.delete).setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }
}

