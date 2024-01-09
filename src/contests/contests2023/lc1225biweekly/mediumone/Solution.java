package contests.contests2023.lc1225biweekly.mediumone;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Time limit exceed attempt 1
// Memory limit exceeded

// Accepted after several attempts, 10:47


class Solution {


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> originalSuppliesList = Arrays.asList(supplies);
        Set<String> goodRecipes = new HashSet<>();

        // Construct a map from non-trivial recipes to the NON-TRIVIAL/COMPLEX ingredients
        Map<String, HashSet<String>> needsWorkIngredientMap = new ConcurrentHashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> neededIngredients = ingredients.get(i);

            HashSet<String> complexIngredients = new HashSet<>();
            for (String ing : neededIngredients) {
                if (!originalSuppliesList.contains(ing)) {
                    complexIngredients.add(ing);
                }
            }

            if (complexIngredients.isEmpty()) { // trivial recipe, add it to the list of good recipes
                goodRecipes.add(recipe);
                continue;
            }
            // non-trivial recipe, keep track of it's complexIngredients
            needsWorkIngredientMap.put(recipes[i], complexIngredients);
        }

        for (int i = 0; i < 1000; i++) {
            for (String recipe : needsWorkIngredientMap.keySet()) {
                HashSet<String> neededIngredients = needsWorkIngredientMap.get(recipe);

                // remove any complex recipes that are now non-complex
                neededIngredients.removeIf(goodRecipes::contains);

                if (neededIngredients.isEmpty()) {
                    // if no more complex ingredients, than it's now a good recipe
                    goodRecipes.add(recipe);
                    needsWorkIngredientMap.remove(recipe);
                }
            }
        }

        List<String> ansRecipes = new ArrayList<>();
        for(String recipe : recipes) {
            if (goodRecipes.contains(recipe)) {
                ansRecipes.add(recipe);
            }
        }

//        System.out.println("ans = " + ansRecipes);
        return ansRecipes;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findAllRecipes(
                new String[]{"bread"},
                List.of(List.of("yeast","flour")),
                new String[]{"yeast","flour","corn"}
        );

        sol.findAllRecipes(
                new String[]{"bread","sandwich"},
                List.of(List.of("yeast","flour"), List.of("bread","meat")),
                new String[]{"yeast","flour","meat"}
        );

        sol.findAllRecipes(
                new String[]{"bread","sandwich","burger"},
                List.of(List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread")),
                new String[]{"yeast","flour","meat"}
        );

        sol.findAllRecipes(
                new String[]{"ju","fzjnm","x","e","zpmcz","h","q"},
                List.of(
                        List.of("d"),
                        List.of("hveml","f","cpivl"),
                        List.of("cpivl","zpmcz","h","e","fzjnm","ju"),
                        List.of("cpivl","hveml","zpmcz","ju","h"),
                        List.of("h","fzjnm","e","q","x"),
                        List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                        List.of("f","hveml","cpivl")
                ),
                new String[]{"f","hveml","cpivl","d"}
        );


//        ["ju","fzjnm","x","e","zpmcz","h","q"]
//        [["d"],["hveml","f","cpivl"],["cpivl","zpmcz","h","e","fzjnm","ju"],["cpivl","hveml","zpmcz","ju","h"],["h","fzjnm","e","q","x"],["d","hveml","cpivl","q","zpmcz","ju","e","x"],["f","hveml","cpivl"]]
//        ["f","hveml","cpivl","d"]




//        ["xevvq","izcad","p","we","bxgnm","vpio","i","hjvu","igi","anp","tokfq","z","kwdmb","g","qb","q","b","hthy"]
//        [["wbjr"],["otr","fzr","g"],["fzr","wi","otr","xgp","wbjr","igi","b"],["fzr","xgp","wi","otr","tokfq","izcad","igi","xevvq","i","anp"],["wi","xgp","wbjr"],["wbjr","bxgnm","i","b","hjvu","izcad","igi","z","g"],["xgp","otr","wbjr"],["wbjr","otr"],["wbjr","otr","fzr","wi","xgp","hjvu","tokfq","z","kwdmb"],["xgp","wi","wbjr","bxgnm","izcad","p","xevvq"],["bxgnm"],["wi","fzr","otr","wbjr"],["wbjr","wi","fzr","xgp","otr","g","b","p"],["otr","fzr","xgp","wbjr"],["xgp","wbjr","q","vpio","tokfq","we"],["wbjr","wi","xgp","we"],["wbjr"],["wi"]]
//        ["wi","otr","wbjr","fzr","xgp"]
        sol.findAllRecipes(
                new String[]{"xevvq","izcad","p","we","bxgnm","vpio","i","hjvu","igi","anp","tokfq","z","kwdmb","g","qb","q","b","hthy"},
                List.of(
                        List.of("wbjr"),
                        List.of("otr","fzr","g"),
                        List.of("fzr","wi","otr","xgp","wbjr","igi","b"),
                        List.of("fzr","xgp","wi","otr","tokfq","izcad","igi","xevvq","i","anp"),
                        List.of("wi","xgp","wbjr"),
                        List.of("wbjr","bxgnm","i","b","hjvu","izcad","igi","z","g"),
                        List.of("xgp","otr","wbjr"),
                        List.of("wbjr"),
                        List.of("wbjr"),
                        List.of("wbjr"),
                        List.of("wbjr"),
                        List.of("wbjr"),
                        List.of("wbjr"),





                        List.of("cpivl","hveml","zpmcz","ju","h"),
                        List.of("h","fzjnm","e","q","x"),
                        List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                        List.of("f","hveml","cpivl")
                ),
                new String[]{"wi","otr","wbjr","fzr","xgp"}
        );
    }
}