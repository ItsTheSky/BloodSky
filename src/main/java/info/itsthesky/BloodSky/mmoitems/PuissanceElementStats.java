package info.itsthesky.BloodSky.mmoitems;

import net.Indyuce.mmoitems.api.player.RPGPlayer;
import net.Indyuce.mmoitems.stat.type.DoubleStat;
import net.Indyuce.mmoitems.stat.type.ItemRestriction;
import net.mmogroup.mmolib.api.item.NBTItem;
import org.bukkit.Material;

public class PuissanceElementStats extends DoubleStat implements ItemRestriction {

	public PuissanceElementStats() {
		super("ELEMENT_POWER_REQUIRE", Material.FIRE_CHARGE, "Puissance Élementaire Nécessaire",
				new String[] { "La Puissance Élementaire du joueur requis", "pour que le joueur utilise l'item" }, new String[] { "all" });
	}

	@Override
	public boolean canUse(RPGPlayer player, NBTItem item, boolean message) {
		return true;
	}
}
