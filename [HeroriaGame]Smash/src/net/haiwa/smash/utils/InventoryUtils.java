package net.haiwa.smash.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

	private Player p;
	
	public InventoryUtils(Player p) {
		this.p = p;
	}

	public Inventory choiceKitInventory() {
		
		Inventory inv = Bukkit.createInventory(null, 9, "§6" + p.getName() + " Kits");
		inv.setItem(0, new ItemStackUtils(p).redstoneBlockComingSoon());
		
		return inv;
	}
}
