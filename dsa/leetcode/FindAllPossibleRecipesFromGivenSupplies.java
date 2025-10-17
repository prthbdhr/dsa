/**
 *  #Leetcode 2115 | https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
 */

public class FindAllPossibleRecipesFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String > availableSupplies = new HashSet<>();

        Map<String, Integer> recipesToIndex = new HashMap<>();

        Map<String, List<String >> dependecyMap = new HashMap<>();

        for (String supply: supplies) availableSupplies.add(supply);

        for (int i = 0; i < recipes.length; i++) recipesToIndex.put(recipes[i], i);

        int[] inDegree = new int[recipes.length];

        for (int i = 0; i < recipes.length; i++) {

            for (String ingrdient: ingredients.get(i)) {

                if (!availableSupplies.contains(ingrdient)) {

                    dependecyMap.putIfAbsent(ingrdient, new ArrayList<>());
                    dependecyMap.get(ingrdient).add(recipes[i]);

                    inDegree[i]++;
                }
            }
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < recipes.length; i++) {

            if (inDegree[i] == 0) qu.add(i);
        }

        List<String > res = new ArrayList<>();

        while (!qu.isEmpty()) {

            String recipe = recipes[qu.poll()];

            res.add(recipe);

            if (!dependecyMap.containsKey(recipe)) continue;

            for (String dependentRecipe: dependecyMap.get(recipe)) {

                if (--inDegree[recipesToIndex.get(dependentRecipe)] == 0) {

                    qu.add(recipesToIndex.get(dependentRecipe));
                }
            }
        }

        return res;
    }
}