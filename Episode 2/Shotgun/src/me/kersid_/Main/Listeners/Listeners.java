package me.kersid_.Main.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import me.kersid_.Main.Utils.Utils;
import me.kersid_.Main.ConfigMaker;

public class Listeners implements Listener {
	
	@EventHandler()
	public void onArrowFired(EntityShootBowEvent event) {
					
		if(!(event.getBow().getType() == Material.CROSSBOW))
			return;
				
        Entity entity = event.getEntity();
        String a = ConfigMaker.get().getString("ArrowNumber");
        Integer b = Integer.parseInt(a);
        
        for (int i = 0; i < b; i++) {
       
        	double randomX = GetRandomNumber(-1, 1)/6;
        	double randomY = GetRandomNumber(-1, 1)/6;
        	double randomZ = GetRandomNumber(-1, 1)/6;
        	
        	double X1 = entity.getLocation().getDirection().getX() + randomX;
        	double Y1 = entity.getLocation().getDirection().getY() + randomY;
        	double Z1 = entity.getLocation().getDirection().getZ() + randomZ;
        	
        	Vector test1 = new Vector(X1, Y1, Z1);
        	        	
        	((ProjectileSource) entity).launchProjectile(Arrow.class, test1);
        }
	}
	
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if(event.getEntity() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getEntity();
			arrow.remove();
		}
	}
	
	public double GetRandomNumber(double min, double max) {
		Random random = new Random();
		return random.doubles(min, (max)).findFirst().getAsDouble();
	}	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		if (!(event.getPlayer().getInventory().isEmpty()))
			return;
		
		ItemStack crossbow = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = crossbow.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Shotgun I");
		lore.add(Utils.chat(ChatColor.GREEN + "&lPew Pew"));
		meta.setLore(lore);
		crossbow.setItemMeta(meta);					
		
		ItemStack arrow = new ItemStack(Material.ARROW);
		arrow.setAmount(64);
		ItemMeta meta1 = arrow.getItemMeta();
		List<String> lore1 = new ArrayList<String>();
		meta1.setLore(lore1);
		arrow.setItemMeta(meta1);					
		
		event.getPlayer().getInventory().addItem(crossbow);
		event.getPlayer().getInventory().addItem(arrow);
	}
}
