package Amazon.Graphs.Find_All_Possible_Recipes_from_Given_Supplies;

import java.util.*;

public class Solution {
    // Link: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
    // Time: O(Recipes + Supplies + Ingredients)
    // Space: O(Recipes + Supplies + Ingredients)
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        Set<String> suppliesHashSet = new HashSet<>();
        HashMap<String, Integer> recipesIndex = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        // Add all the available supplies to the hashSet
        for(String supplement : supplies)
            suppliesHashSet.add(supplement);

        // Store the index for all recipes
        for(int i = 0; i < recipes.length; i++)
            recipesIndex.put(recipes[i], i);

        int[] inDegree = new int[recipes.length];

        // Create a mapping between all the recipes that are Ingredients as well
        // to the recipes they are ingredients for
        for(int i = 0; i < recipes.length; i++) {
            for(String requirement : ingredients.get(i)) {
                if(suppliesHashSet.contains(requirement))
                    continue;

                map.putIfAbsent(requirement, new ArrayList<String>());
                map.get(requirement).add(recipes[i]);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // We will add all the recipes that in Zero degree to the Queue

        for(int i = 0; i < recipes.length; i++)
            if(inDegree[i] == 0)
                queue.add(i);

        // Perform Topological Sort
        while(!queue.isEmpty()) {
            int recipeIndex = queue.poll();
            answer.add(recipes[recipeIndex]);

            if(!map.containsKey(recipes[recipeIndex]))
                // if this recipe is not a requirement for any other recipes
                continue;

            for(String recipe : map.get(recipes[recipeIndex]))
                if(--inDegree[recipesIndex.get(recipe)] == 0)
                    queue.add(recipesIndex.get(recipe));
        }

        return answer;
    }
}
