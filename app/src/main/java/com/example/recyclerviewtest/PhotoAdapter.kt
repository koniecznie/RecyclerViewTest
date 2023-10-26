package com.example.recyclerviewtest
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PhotoAdapter :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    private var dataList = emptyList<DataModel>()
    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }
    //Tworzymy ViewHolder odpowiadający za bezpośrednie odniesienie do każdego z widoków z elementami danych

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var desc: TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.desc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {

        // tworzymy uklad
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.photo_layout, parent,
            false
        )
        return ViewHolder(view)
    }

    // wypełniamy danymi przez bindowanie
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //pobieramy dane na podstawie pozycji
        val data = dataList[position]
        // ustawiamy widoki elementów na podstawie modelu danych
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.image.setImageResource(data.image)

        holder.image.setOnClickListener { view ->
            Intent(view.context, DetailActivity::class.java).apply {
                putExtra("title", data.title)
                putExtra("description", data.desc)
                putExtra("image_res", data.image)
            }.also { view.context.startActivity(it) }
        }
    }

    // łączna liczba elementów
    override fun getItemCount() = dataList.size
}