package praise.mall.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import praise.mall.Model.Category
import praise.mall.R

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryView:View

        val holder : ViewHolder

        if (convertView == null ){

            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)

            holder = ViewHolder()

            holder.categoryImage = categoryView.findViewById(R.id.categoryIV)

            holder.categoryName = categoryView.findViewById(R.id.categoryTV)

            categoryView.tag = holder

        }else{

            holder = convertView.tag as ViewHolder

            categoryView = convertView
        }


        val category = categories[position]

        val resourceid = context.resources.getIdentifier(category.image,"drawable",context.packageName)

        holder.categoryImage?.setImageResource(resourceid)

        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]//To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        return 0 //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return categories.count()//To change body of created functions use File | Settings | File Templates.
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}