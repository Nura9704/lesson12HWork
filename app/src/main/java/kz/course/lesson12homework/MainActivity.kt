package kz.course.lesson12homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentList: ArrayList<ParentItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parentList = ArrayList()

        initViews()
        initNames()

        val adapter = ParentRecyclerViewAdapter(parentList)
        parentRecyclerView.adapter = adapter
    }

    private fun initViews() {
        parentRecyclerView = findViewById(R.id.parentRecyclerView)
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


}