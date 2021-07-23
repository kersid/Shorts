package me.kersid_.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.kersid_.Main.Utils.Utils;

public class commands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("shotgun")) {
            if (!(args[0].equalsIgnoreCase(null))){
            	if (isInteger(args[0]) == true) {
            		ConfigMaker.get().set("ArrowNumber", args[0]);
            		sender.sendMessage(Utils.chat("&7Crossbows will now fire &2" + args[0] + " &7Arrows"));
            	}
            }
            return true;
        }	
		return false;
	}
	
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }

	    return true;
	}
	

}
