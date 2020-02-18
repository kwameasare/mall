package praise.mall.Services

import praise.mall.Model.Category
import praise.mall.Model.Product


object DataService {


    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )


    val hats = listOf(
        Product("ST Graphic Beanie", "$18","hat1"),
        Product("ST Hat Black", "$28","hat2"),
        Product("ST Hat White", "$18","hat3"),
        Product("ST Hat Snapback", "$22","hat4")
    )

    val hoodies = listOf(
        Product("ST Hoodie Gray","$38","hoodie1"),
        Product("ST Hoodie Red","$50","hoodie2"),
        Product("ST Hoodie Greyer","$48","hoodie3"),
        Product("ST Hoodie Black","$60","hoodie4")

    )

    val shirts = listOf(
        Product("ST Shirt Black","$10","shirt1"),
        Product("ST Shirt Light Grey","$12","shirt2"),
        Product("ST Hoodie Shirt Red","$22","shirt3"),
        Product("ST Shirt Hustle E Black","$60","shirt4"),
        Product("DSLP Kickflip Studios","$18","shirt5")

    )

    val digitalGood = listOf<Product>()

    fun getProducts(category: String): List<Product> {

        return when(category){
            "SHIRTS" -> return shirts
            "HATS" -> return hats
            "HOODIES" -> return hoodies
            else -> return digitalGood

        }

//        if(category == "HATS") {
//            return hats
//        }else if (category == "SHIRTS"){
//            return shirts
//        }
    }

}