package praise.mall.Controller

import android.content.Intent

import android.os.Bundle

import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import praise.mall.Adapters.CategoryAdapter
import praise.mall.Adapters.CategoryRecycleAdapter
import praise.mall.Model.Category
import praise.mall.R
import praise.mall.Services.DataService
import praise.mall.Utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)

        }

        //var categoryLV:RecyclerView?=findViewById(R.id.categoryLV)

            categoryLV.adapter = adapter


        val layoutManager = LinearLayoutManager(this)


            categoryLV.layoutManager = layoutManager



            categoryLV.setHasFixedSize(true)




    }
}
