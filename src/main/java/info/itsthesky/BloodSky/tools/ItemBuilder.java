package info.itsthesky.BloodSky.tools;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;
import java.util.UUID;

public class ItemBuilder {
	private ItemStack item;

	public ItemBuilder(Material material) {
		item = new ItemStack(material, 1);
	}

	public ItemBuilder setName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

	public ItemBuilder setLore(List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return this;
	}

	public ItemBuilder setAmount(Integer quantity) {
		item.setAmount(quantity);
		return this;
	}

	public ItemBuilder setMaterial(Material material) {
		item.setType(material);
		return this;
	}

	public ItemBuilder setOwner(UUID uuid) {
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		assert sm != null;
		sm.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
		item.setItemMeta(sm);
		return this;
	}

	public ItemBuilder toggleUnbreakable() {
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(!meta.isUnbreakable());
		item.setItemMeta(meta);
		return this;
	}

	public ItemBuilder setBase64(String base64) {
		if (item.getType() == Material.PLAYER_HEAD) {
			NBTItem nbti = new NBTItem(item);
			if (Bukkit.getVersion().contains("1.16")) {
				nbti.mergeCompound(new NBTContainer("{display:{Name:\"{\\\"text\\\":\\\"Portfolios\\\"}\"},SkullOwner:{Id:[I;-471448956,411780600,-2117854973,552810048],Properties:{textures:[{Value:\"" + base64 + "\"}]}}}"));
			} else {
				nbti.mergeCompound(new NBTContainer("{SkullOwner:{Id:\"bf61a1f8-82e9-432b-816b-947458cec398\",Properties:{textures:[{Value:\""+base64+"\"}]}}}"));
			}
			item = nbti.getItem();
		}
		return this;
	}

	public ItemBuilder addNBT(String nbt) {
		NBTItem nbti = new NBTItem(item);
		nbti.mergeCompound(new NBTContainer(nbt));
		item = nbti.getItem();
		return this;
	}

	public ItemBuilder setCustomModelData(Integer cmd) {
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(cmd);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStack toItemStack() {
		return item;
	}

}