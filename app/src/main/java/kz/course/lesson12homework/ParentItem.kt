package kz.course.lesson12homework

data class ParentItem(
    val title: String,
    val childItemList: ArrayList<ChildItem>,
    var isExpandable: Boolean = false
)
