package src.LEETCODE

class leet_371 {
    companion object{
        fun getSum(a: Int, b: Int): Int {
            val mask = 0xFFFFFFFF.toInt()
            var aa = a
            var bb = b
            while (bb != 0) {
                val carry = (aa and bb and mask)
                aa = (aa xor bb) and mask
                bb = ((carry shl 1) and mask)
            }
            return aa xor mask.inv()
        }
    }

}

fun main(){
    println(leet_371.getSum(1,-100))
}