package net.haiwa.smash.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackUtils {

	public ItemStackUtils() {

	}
	
	public ItemStack leaveBed() {
		
		ItemStack leavebed = new ItemStack(Material.BED);
		ItemMeta leavebedM = leavebed.getItemMeta();
		
		leavebedM.setDisplayName("�cQuitter la partie");
		leavebed.setItemMeta(leavebedM);
		
		return leavebed;
	}

	public ItemStack kitNetherStar() {
		
		ItemStack netherstarkit = new ItemStack(Material.NETHER_STAR);
		ItemMeta netherstarkitM = netherstarkit.getItemMeta();
		
		netherstarkitM.setDisplayName("�6Choissir un kit");
		netherstarkit.setItemMeta(netherstarkitM);
		
		return netherstarkit;
	}

	public ItemStack redstoneBlockComingSoon() {
		
		ItemStack redstoneblockcs = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta redstoneblockcsM = redstoneblockcs.getItemMeta();
		
		redstoneblockcsM.setDisplayName("�4Coming Soon...");
		redstoneblockcs.setItemMeta(redstoneblockcsM);
		
		return redstoneblockcs;
	}
}
