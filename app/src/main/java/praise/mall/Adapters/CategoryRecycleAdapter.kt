package praise.mall.Adapters

import android.content.Context
import android.media.Image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list_item.view.*
import praise.mall.Model.Category
import praise.mall.R
import praise.mall.Services.DataService.categories

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.category_list_item,parent,false)//To change body of created functions use File | Settings | File Templates.
        return Holder(view,itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position],context) //To change body of created functions use File | Settings | File Templates.
    }



    override fun getItemCount(): Int {
        return categories.count()//To change body of created functions use File | Settings | File Templates.
    }



    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryIV)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryTV)

        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image,
                "drawable",context.packageName)

            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

            itemView.setOnClickListener { itemClick(category) }
        }
    }


}