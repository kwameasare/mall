package praise.mall.Controller

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_products.*
import praise.mall.Adapters.ProductsAdapter
import praise.mall.R
import praise.mall.Services.DataService
import praise.mall.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductsAdapter(this,DataService.getProducts(categoryType))

        var spanCount = 2

        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp

        if(screenSize > 720 ) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount )
        //var categoryLV: RecyclerView?=findViewById(R.id.categoryLV)
        productLV.layoutManager = layoutManager

        productLV.adapter = adapter
    }
}
