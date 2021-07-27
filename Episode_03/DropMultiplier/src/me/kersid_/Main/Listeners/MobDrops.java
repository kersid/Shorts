package me.kersid_.Main.Listeners;

import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.kersid_.Main.ConfigMaker;
import me.kersid_.Main.Utils.RandomNumber;

public class MobDrops implements Listener{

	@EventHandler()
	public void onBlockBroken(EntityDeathEvent event) {
		
		if (event.getEntity() instanceof Player)
			return;
		if (!(event.getEntity().getKiller() instanceof Player))
			return;
		if (event.getEntity().getKiller() instanceof Player) {
			if (event.getEntity().getKiller().getPlayer().getGameMode() == GameMode.CREATIVE || event.getEntity().getKiller().getGameMode() == GameMode.SPECTATOR)
			return;
		}

		Entity entity = event.getEntity();
		World world = event.getEntity().getLocation().getWorld();
		
		Collection <ItemStack> drops = event.getDrops();
		
		if (ConfigMaker.get().getString("DropMode").contains("Random")) {
					
			int min = Integer.parseInt(ConfigMaker.get().getString("Minimum"));
			int max = Integer.parseInt(ConfigMaker.get().getString("Maximum"));
			Integer number = RandomNumber.getRandomInt(min, max);
		
			for (int i = 0; i <= number - 2; i++) {
				
				for(ItemStack drop : drops)
					world.dropItem(entity.getLocation(), drop);
				}
			}
				
		if (ConfigMaker.get().getString("DropMode").contains("Set")) {
			
			Integer number = Integer.parseInt(ConfigMaker.get().getString("SetAmount"));
			
		
			for (Integer i = 0; i <= number - 2; i++) {

				for(ItemStack drop : drops)
					world.dropItem(entity.getLocation(), drop);
			}
			
		}
	}
	
}
