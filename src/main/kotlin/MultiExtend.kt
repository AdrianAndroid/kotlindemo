open class BaseViewHolder {
    open fun sayHi() {
        println("BaseViewHolder sayHi!")
    }
}

class VH : BaseViewHolder(), Expandable {
    override fun sayHi() {
        super.sayHi()
        println("VH sayHi!")
    }

    override fun doExpand() {
        println("doExpand")
    }

    override fun doCustom() {
        println("doCustom")
    }
}

interface Expandable {
    fun doExpand()
    fun doCustom()
}

class KeepOneHolder<VH>(val myVH: VH) where VH : BaseViewHolder, VH : Expandable {
    fun bind(viewHolder: VH) {
        viewHolder.sayHi()
    }

}

fun main() {
    println("tool.main")
    val vh: VH = VH()
    val keepOneHolder = KeepOneHolder(vh)
}


