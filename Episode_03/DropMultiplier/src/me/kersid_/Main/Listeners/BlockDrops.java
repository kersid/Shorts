package me.kersid_.Main.Listeners;

import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.kersid_.Main.ConfigMaker;
import me.kersid_.Main.Utils.RandomNumber;

public class BlockDrops implements Listener{
	

	
	@EventHandler()
	public void onBlockBroken(BlockBreakEvent event) {
			
		Player player = event.getPlayer();
		
		if(!(player.getInventory().getItemInMainHand().getType() == Material.AIR)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH))
				return;		
		}
		
		if (event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR)
			return;	
		
		World world = event.getPlayer().getLocation().getWorld();
		ItemStack tool = player.getInventory().getItemInMainHand();
		
		Collection <ItemStack> drops = event.getBlock().getDrops(tool);
		
		if (ConfigMaker.get().getString("DropMode").contains("Random")) {
					
			int min = Integer.parseInt(ConfigMaker.get().getString("Minimum"));
			int max = Integer.parseInt(ConfigMaker.get().getString("Maximum"));
			Integer number = RandomNumber.getRandomInt(min, max);
		
			for (int i = 0; i <= number - 2; i++) {
				
				for(ItemStack drop : drops)
					world.dropItem(event.getBlock().getLocation(), drop);
				}
			}
				
		if (ConfigMaker.get().getString("DropMode").contains("Set")) {
			
			Integer number = Integer.parseInt(ConfigMaker.get().getString("SetAmount"));
			
		
			for (Integer i = 0; i <= number - 2; i++) {

				for(ItemStack drop : drops)
					world.dropItem(event.getBlock().getLocation(), drop);
			}
			
		}
	}
}
