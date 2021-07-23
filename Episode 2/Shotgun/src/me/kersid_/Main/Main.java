package me.kersid_.Main;

import org.bukkit.plugin.java.JavaPlugin;

import me.kersid_.Main.Listeners.Listeners;

public class Main extends JavaPlugin {
	
	public void onEnable() {
				
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		getCommand("shotgun").setExecutor(new commands());
		
		ConfigMaker.setup();
		ConfigMaker.get().addDefault("ArrowNumber", "20");
		ConfigMaker.get().options().copyDefaults(true);
		ConfigMaker.save();
		
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
	}
	
	public void onDisable() {
		
	}
}
	







