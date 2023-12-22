package kz.course.lesson12homework


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val parentLiveData: MutableLiveData<ArrayList<ParentItem>> = MutableLiveData()
    lateinit var parentArrayList: MutableLiveData<ArrayList<ParentItem>>
    private lateinit var childArrayList:ArrayList<ChildItem>

    init {
        populateList()
    }

    fun getUserMutableLiveData(): MutableLiveData<ArrayList<ParentItem>> {
        return parentLiveData
    }

    private fun populateList() {

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

    }

}