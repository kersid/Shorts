package me.kersid_.Episode_1;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	public static Plugin plugin;
	
	
	@Override
	public void onEnable() {
								
	this.getServer().getPluginManager().registerEvents(this, this);
			
	}	
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		if (event.getPlayer().getInventory() == null)
		GiveItems(event.getPlayer());
		
	}
	
	@EventHandler
	public void onArrowFired(EntityShootBowEvent event) {
		
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		Player player = (Player) event.getEntity();
		World world = player.getWorld();
		
		Location loc = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 100, player.getLocation().getZ());
		
		player.teleport(loc);

		
	}
	
	public void GiveItems(Player player) {
		
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Imp I");
		lore.add(ChatColor.GRAY + "Haha LXIX");
		meta.setLore(lore);
		item.setItemMeta(meta);					
		
		ItemStack item2 = new ItemStack(Material.ELYTRA);
		ItemMeta meta2 = item.getItemMeta();
		List<String> lore2 = new ArrayList<String>();
		lore2.add(ChatColor.GRAY + "Short I");
		lore2.add(ChatColor.GRAY + "Infinity 3.4");
		meta2.setLore(lore2);
		item2.setItemMeta(meta2);
				
		ItemStack item3 = new ItemStack(Material.ARROW);
		ItemMeta meta3 = item.getItemMeta();
		List<String> lore3 = new ArrayList<String>();
		lore2.add(ChatColor.GRAY + "Longboi I");
		lore2.add(ChatColor.GRAY + "Like, 2? II");
		meta3.setLore(lore3);
		item3.setItemMeta(meta3);					
					
		player.getInventory().addItem(item);
		player.getInventory().addItem(item2);
		player.getInventory().addItem(item3);
		
	}
}


