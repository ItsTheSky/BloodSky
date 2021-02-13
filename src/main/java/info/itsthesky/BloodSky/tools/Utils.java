package info.itsthesky.BloodSky.tools;

import net.Indyuce.mmoitems.MMOItems;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

	public static List<Integer> integersBetween(int a, int b) {
		List<Integer> list = new ArrayList<>();
		for (int i = a; i < b+1; i++) {
			list.add(i);
		}
		return list;
	}

	public static ItemStack getItem(String type, String id) {
		return MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get(type),id);
	}

	public static String colored(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}

	public static ArmorStand spawnCustomArmorstand(Location loc, Material item) {
		ArmorStand stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setGravity(false);
		stand.setVisible(false);
		stand.getEquipment().setHelmet(new ItemBuilder(item).setName("§1").toItemStack());
		return stand;
	}

	public static Integer round(Double number) {
		String t = number.toString().split("\\.")[0];
		return Integer.valueOf(t);
	}

}
