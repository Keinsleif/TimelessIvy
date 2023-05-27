package keinsleif.timeless_ivy.lexicon;

import keinsleif.timeless_ivy.recipe.InitRecipe;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconCategory;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.lexicon.AlfheimLexiconEntry;
import vazkii.botania.common.lexicon.page.PageCraftingRecipe;
import vazkii.botania.common.lexicon.page.PageText;

public final class LexiconData {
    public static LexiconEntry regenIvy;

    public static void init() {
        LexiconCategory categoryTools = BotaniaAPI.categoryTools;

        regenIvy = new AlfheimLexiconEntry("regenIvy",categoryTools);
        regenIvy.setLexiconPages(new PageText("0"),new PageText("2"),
                new PageCraftingRecipe("1", InitRecipe.recipeRegenIvy));
    }
}
