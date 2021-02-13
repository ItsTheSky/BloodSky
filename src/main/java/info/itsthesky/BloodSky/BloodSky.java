package info.itsthesky.BloodSky;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import info.itsthesky.BloodSky.mmoitems.*;
import info.itsthesky.BloodSky.tools.Utils;
import net.Indyuce.mmoitems.MMOItems;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class BloodSky extends JavaPlugin {

	private final ConsoleCommandSender sender = Bukkit.getConsoleSender();
	private PluginManager pm = Bukkit.getPluginManager();

	@Override
	public void onEnable() {
		sender.sendMessage(Utils.colored("&7---------------------------------"));
		sender.sendMessage(Utils.colored("&eBloodSky &6is loading ..."));
		sender.sendMessage(Utils.colored("&e"));

		sender.sendMessage(Utils.colored("&3Chargement de &bSkript &3..."));
		if (!(pm.getPlugin("Skript") == null)) {
			if ((pm.getPlugin("Skript") != null) && Skript.isAcceptRegistrations()) {
				SkriptAddon addon = Skript.registerAddon(this);
				try {
					addon.loadClasses("info.itsthesky.BloodSky.skript");
				} catch (IOException e) {
					Skript.error("Wait, this is anormal. Please report this error on GitHub.");
					e.printStackTrace();
				}
			} else {
				Skript.error("Skript isn't installed or doesn't accept registrations.");
				pm.disablePlugin(this);
			}
		}
		sender.sendMessage(Utils.colored("&3Chargement de &bSkript &3terminé!"));
		sender.sendMessage(Utils.colored("&3Chargement des stats de &bMMOItems &3..."));

		MMOItems.plugin.getStats().register(new AgiliteStats());
		MMOItems.plugin.getStats().register(new DefenseElementStats());
		MMOItems.plugin.getStats().register(new DexterityStats());
		MMOItems.plugin.getStats().register(new DiscretionStats());
		MMOItems.plugin.getStats().register(new DominanceStats());
		MMOItems.plugin.getStats().register(new ForceStats());
		MMOItems.plugin.getStats().register(new IntelligenceStats());
		MMOItems.plugin.getStats().register(new PuissanceElementStats());
		MMOItems.plugin.getStats().register(new RayonStats());
		MMOItems.plugin.getStats().register(new VolonteStats());
		MMOItems.plugin.getStats().register(new SurvieStats());
		MMOItems.plugin.getStats().register(new SkillStats());
		MMOItems.plugin.getStats().register(new ElementStats());
		MMOItems.plugin.getStats().register(new SagesseStats());
		MMOItems.plugin.getStats().register(new PerceptionStats());
		MMOItems.plugin.getStats().register(new ResistanceStats());
		MMOItems.plugin.getStats().register(new ChanceStats());
		MMOItems.plugin.getStats().register(new EruditionStats());
		MMOItems.plugin.getStats().register(new CharismeStats());
		MMOItems.plugin.getStats().register(new MaitriseStats());

		sender.sendMessage(Utils.colored("&3Chargement des stats de &bMMOItems &3terminé! (20)"));

		sender.sendMessage(Utils.colored("&e"));
		sender.sendMessage(Utils.colored("&2BloodSky &ahas been loaded! Made by &2ItsTheSky#1234"));
		sender.sendMessage(Utils.colored("&7---------------------------------"));
	}
}
