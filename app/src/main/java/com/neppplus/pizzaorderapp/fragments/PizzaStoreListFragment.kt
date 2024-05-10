package com.neppplus.pizzaorderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp.R
import com.neppplus.pizzaorderapp.adapters.PizzaStoreAdapter
import com.neppplus.pizzaorderapp.datas.Store

class PizzaStoreListFragment : Fragment() {

    val mPizzaStroreDataList = ArrayList<Store>()

    lateinit var mPizzaStoreAdapter: PizzaStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    //동작 관련 코드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pizzaStoreListView = view.findViewById<ListView>(R.id.pizzaStoreListView)

        mPizzaStoreAdapter = PizzaStoreAdapter(requireContext(), R.layout.pizza_store_list_item, mPizzaStroreDataList)
        pizzaStoreListView.adapter = mPizzaStoreAdapter

        // 데이터 추가
        mPizzaStroreDataList.add(Store("A피자가게", "1111-5555", "https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mPizzaStroreDataList.add(Store("B피자가게", "1111-3333", "https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mPizzaStroreDataList.add(Store("C피자가게", "1111-2222", "https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mPizzaStroreDataList.add(Store("D피자가게", "1111-1111", "https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        mPizzaStoreAdapter.notifyDataSetChanged()
    }
}