package info.itsthesky.BloodSky.mmoitems;

import net.Indyuce.mmoitems.api.player.RPGPlayer;
import net.Indyuce.mmoitems.stat.type.ItemRestriction;
import net.Indyuce.mmoitems.stat.type.StringStat;
import net.mmogroup.mmolib.api.item.NBTItem;
import org.bukkit.Material;

public class SkillStats extends StringStat implements ItemRestriction {

	public SkillStats() {
		super("SKILLS_REQUIRE", Material.BLAZE_ROD, "Skill Nécessaire",
				new String[] { "Le Skill du joueur requis", "pour que le joueur utilise l'item" }, new String[] { "all" });
	}

	@Override
	public boolean canUse(RPGPlayer player, NBTItem item, boolean message) {
		return true;
	}
}
