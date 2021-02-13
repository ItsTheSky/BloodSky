package info.itsthesky.BloodSky.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.crafting.CraftingStation;
import net.Indyuce.mmoitems.gui.CraftingStationView;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Name("Open MMOItems Station")
@Description("Open a MMOItems station to a specific player")
@Since("alpha-0.1")
@RequiredPlugins("MMOItems")
@Examples("open station \"arcane-forge\" to player")
public class EffOpenStation extends Effect {

    static {
        Skript.registerEffect(EffOpenStation.class, "[skutils] [mmoitems] open [the] station[s] [(named|with name|called|with id)] %string% to [the] [player] %player%");
    }

    private Expression<Player> player;
    private Expression<String> station;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.station = (Expression<String>) exprs[0];
        this.player = (Expression<Player>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return null;
    }

    @Override
    protected void execute(Event event) {
        String s = station.getSingle(event);
        Player p = player.getSingle(event);
        if (p != null) {
            if (s != null) {
                CraftingStation rstation = MMOItems.plugin.getCrafting().getStation(s);
                if (rstation != null) {
                    new CraftingStationView(p, rstation, 1).open();
                } else {
                    Bukkit.getServer().getLogger().warning("[BloodSky] The MMOItems Station with ID " + s + " cannot be found!");
                    return;
                }
            }
        }
    }
}