package me.kersid_.Main;

import org.bukkit.plugin.java.JavaPlugin;

import me.kersid_.Main.Commands.Commands;
import me.kersid_.Main.Listeners.*;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new BlockDrops(), this);
		getServer().getPluginManager().registerEvents(new MobDrops(), this);
		
		getCommand("randomdrops").setExecutor(new Commands());
		
		ConfigMaker.setup();
		ConfigMaker.get().addDefault("Minimum", "1");
		ConfigMaker.get().addDefault("Maximum", "64");
		ConfigMaker.get().addDefault("SetAmount", "64");
		ConfigMaker.get().addDefault("DropMode", "Random");
		ConfigMaker.save();
		
	}
	
	public void onDisable() {
		
		ConfigMaker.save();
		
	}
}
	







