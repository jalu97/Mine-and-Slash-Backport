package com.robertx22.mine_and_slash.db_lists.initializers.profession_recipes;

import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryInit;
import com.robertx22.mine_and_slash.professions.recipe.BaseRecipe;

import java.util.ArrayList;
import java.util.List;

public class AlchemyRecipes implements ISlashRegistryInit {

    @Override
    public void registerAll() {

        List<BaseRecipe> all = new ArrayList<BaseRecipe>();

        /*
        all.add(new TestRecipe());
        all.add(new TestRecipe2());
        all.add(new TestRecipe3());
        all.add(new TestRecipe4());

        for (int i = 0; i < 500; i++) {
            all.add(new SimpleAlchemyRecipe(i + "alchemytest", Arrays.asList(Items.GLASS, Items.EMERALD, Items.GOLD_INGOT, Items.IRON_INGOT, Items.IRON_BLOCK), Items.EXPERIENCE_BOTTLE)
                    .levelReq(i));
        }

         */

        all.forEach(x -> x.registerToSlashRegistry());
    }
}
