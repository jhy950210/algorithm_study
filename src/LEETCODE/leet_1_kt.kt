package src.LEETCODE

class leet_1_kt {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var first = 0
        var second = 0

        for (i in nums.indices){
            first = i

            for (j in i+1 until nums.size){
                second = j

                if(nums[i] + nums[j] == target) return intArrayOf(first, second)
            }
        }

        return intArrayOf(first, second)
    }

    fun twoSumN0(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        throw IllegalArgumentException("No two sum solution")
    }
}
