package kz.course.lesson12homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kz.course.lesson12homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var parentList: ArrayList<ParentItem>
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        parentList = ArrayList()

        initNames()

        val adapter = ParentRecyclerViewAdapter()
        binding.parentRecyclerView.adapter = adapter
    }

    private fun initNames() {
        val childItems1 = ArrayList<ChildItem>()
        childItems1.add(ChildItem("Аватар: Путь воды", R.drawable.avatar2))
        childItems1.add(ChildItem("Барби", R.drawable.barbie))
        childItems1.add(ChildItem("Великий уровнитель 3", R.drawable.equalizer))
        childItems1.add(ChildItem("Один дома", R.drawable.home_alone))
        childItems1.add(ChildItem("Мег 2", R.drawable.meg2))
        childItems1.add(
            ChildItem(
                "Миссия невыполнима: Смертельная расплата",
                R.drawable.mission_imp
            )
        )

        parentList.add(ParentItem("Фильмы", childItems1))

        val childItems2 = ArrayList<ChildItem>()
        childItems2.add(ChildItem("Canva", R.drawable.canva))
        childItems2.add(ChildItem("Discord", R.drawable.discord))
        childItems2.add(ChildItem("Kaspi Pay", R.drawable.kaspi_pay))
        childItems2.add(ChildItem("Ozon", R.drawable.ozon))
        childItems2.add(ChildItem("Tiktok", R.drawable.tiktok))
        childItems2.add(ChildItem("Wildberries", R.drawable.wildberries))

        parentList.add(ParentItem("Приложения", childItems2))
    }

    private fun initObserves() {

    }

}