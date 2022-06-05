package leetcode

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
class Problem2115 {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val recipeToIngredients = mutableMapOf<String, List<String>>()
        for ((index, recipe) in recipes.withIndex()) {
            recipeToIngredients[recipe] = ingredients[index]
        }
        val answer = mutableListOf<String>()
        val memo = mutableMapOf<String, Boolean>()
        val visited = mutableSetOf<String>()
        val supplySet = supplies.toSet()
        for (recipe in recipes) {
            if (findAllRecipes(recipeToIngredients, supplySet, recipe, visited, memo)) {
                answer += recipe
            }
        }
        return answer
    }

    private fun findAllRecipes(recipeToIngredients: MutableMap<String, List<String>>,
                               supplies: Set<String>,
                               recipe: String,
                               visited: MutableSet<String>,
                               memo: MutableMap<String, Boolean>): Boolean {
        if (memo[recipe] != null) {
            return memo[recipe]!!
        }
        if (recipe in visited) {
            return false
        }
        visited += recipe
        var found = true
        for (ingredient in recipeToIngredients[recipe] ?: listOf()) {
            found = if (ingredient in recipeToIngredients) {
                found && findAllRecipes(recipeToIngredients, supplies, ingredient, visited, memo)
            } else {
                found && ingredient in supplies
            }
        }
        memo[recipe] = found
        return found
    }
}
