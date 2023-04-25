package src.LEETCODE

class leet_70_kt {
    companion object{
        /**
         * n=1 : 1개
         * n=2 : 2개
         * n=3 : 3개
         *
         * n=4 : 5개
         * (1,1,1,1)
         * (1,2,1)
         * (2,1,1)
         * (1,1,2)
         * (2,2)
         *
         * n=5 : 8개
         * (1,1,1,1,1)
         * (2,1,1,1)
         * (1,2,1,1)
         * (1,1,2,1)
         * (1,1,1,2)
         * (2,2,1)
         * (2,1,2)
         * (1,2,2)
         */
        fun climbStairs(n: Int): Int {
            if(n <= 2) return n

            return climbStairs(n-2) + climbStairs(n-1)
        }

        fun bosu(n: Int): Int {

            return n.inv()
        }
    }
}

fun main(){
    println( leet_70_kt.bosu(58))
}