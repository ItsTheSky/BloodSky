package info.itsthesky.BloodSky.mmoitems;

import net.Indyuce.mmoitems.api.player.RPGPlayer;
import net.Indyuce.mmoitems.stat.type.ItemRestriction;
import net.Indyuce.mmoitems.stat.type.StringStat;
import net.mmogroup.mmolib.api.item.NBTItem;
import org.bukkit.Material;

public class ElementStats extends StringStat implements ItemRestriction {

	public ElementStats() {
		super(
				"ELEMENT_REQUIRE", Material.FIRE_CHARGE, "Élement Nécessaire",
				new String[] { "L'Élement du joueur requis", "pour que le joueur utilise l'item" }, new String[] { "all" });
	}

	@Override
	public boolean canUse(RPGPlayer player, NBTItem item, boolean message) {
		return true;
	}
}
