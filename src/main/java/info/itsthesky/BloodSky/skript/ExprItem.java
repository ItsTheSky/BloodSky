package info.itsthesky.BloodSky.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@Name("MMOItems Item")
@Description("Return a MMOItems item via it's type and id")
@Since("alpha-0.1")
@RequiredPlugins("MMOItems")
@Examples("item with type \"TOOL\" and with id \"STEEL_PICKAXE\"")
public class ExprItem extends SimpleExpression<ItemStack> {

    static {
        Skript.registerExpression(ExprItem.class, ItemStack.class, ExpressionType.SIMPLE,
                "[bloodsky] [new] [custom] (mmoitem|mi) [item] with [the] type %string% and [the] id %string%");
    }

    private Expression<String> type;
    private Expression<String> item;

    @Override
    public Class<? extends ItemStack> getReturnType() {
        return ItemStack.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.type = (Expression<String>) exprs[0];
        this.item = (Expression<String>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected ItemStack[] get(Event event) {
        String t = type.getSingle(event);
        String i = item.getSingle(event);
        if (t != null) {
            Type rtype = MMOItems.plugin.getTypes().get(t);
            if (rtype == null) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[BloodSky] The MMOItems type with ID " + t + " cannot be found!");
                return new ItemStack[0];
            }
            if (i != null) {
                ItemStack ritem = MMOItems.plugin.getItem(rtype,i);
                if (ritem == null) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[BloodSky] The MMOItems item with ID " + t + " cannot be found!");
                    return new ItemStack[0];
                }
                return new ItemStack[] {ritem};
            }
        }
        return null;
    }
}