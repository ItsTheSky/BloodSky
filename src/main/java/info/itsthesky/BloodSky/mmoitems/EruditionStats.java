package info.itsthesky.BloodSky.mmoitems;

import net.Indyuce.mmoitems.api.player.RPGPlayer;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.type.ItemRestriction;
import net.mmogroup.mmolib.api.item.NBTItem;
import org.bukkit.Material;

public class EruditionStats extends DoubleStat implements ItemRestriction {

	public EruditionStats() {
		super("ERUDITION_REQUIRE", Material.WHITE_WOOL, "Erudition Nécessaire",
				new String[] { "L'Erudition du joueur requis", "pour que le joueur utilise l'item" }, new String[] { "all" });
	}


	@Override
	public boolean canUse(RPGPlayer player, NBTItem item, boolean message) {
		return true;
	}
}
