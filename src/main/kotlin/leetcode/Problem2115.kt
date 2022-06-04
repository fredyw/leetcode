package leetcode

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
class Problem2115 {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        TODO()
    }
}

fun main() {
    val prob = Problem2115()
    println(prob.findAllRecipes(
        arrayOf("bread"),
        listOf(listOf("yeast","flour")),
        arrayOf("yeast","flour","corn"))) // ["bread"]
    println(prob.findAllRecipes(
        arrayOf("bread","sandwich"),
        listOf(listOf("yeast","flour"), listOf("bread","meat")),
        arrayOf("yeast","flour","meat"))) // ["bread","sandwich"]
    println(prob.findAllRecipes(
        arrayOf("bread","sandwich","burger"),
        listOf(listOf("yeast","flour"), listOf("bread","meat"), listOf("sandwich","meat","bread")),
        arrayOf("yeast","flour","meat"))) // ["bread","sandwich","burger"]
}