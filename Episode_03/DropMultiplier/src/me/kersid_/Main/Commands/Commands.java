package me.kersid_.Main.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.kersid_.Main.ConfigMaker;
import me.kersid_.Main.Utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("randomdrops") || cmd.getName().equalsIgnoreCase("rd")) {
            if (!(args[0].equalsIgnoreCase(null))){
            	if (args[0].equalsIgnoreCase("help")) {
            		onHelpCommand(sender);
            	}
            	
            	if (args[0].equalsIgnoreCase("setup")) {
            		if(sender.hasPermission("randomdrops.setup")) {
            			if (args[1].equalsIgnoreCase("random")) {
            				if (isInteger(args[2]) == true) {
            					if(isInteger(args[3]) == true) {
            						int min = Integer.parseInt(args[2]);
            						int max = Integer.parseInt(args[3]);
            							if(min>=max) {
            								sender.sendMessage("The minimum cannot be greater than or equal to the maximum");
            								return true;
            							}           					
            						ConfigMaker.get().set("Minimum", args[2]);
            						ConfigMaker.get().set("Maximum", args[3]);
            						ConfigMaker.get().set("DropMode", "Random");
            						sender.sendMessage("All drops will now be between " + args[2] + " and " + args[3]);
            						ConfigMaker.save();
            						return true;
            					}
            				}
            			}
            		

            		
            			if (args[1].equalsIgnoreCase("set")) {
            				if (isInteger(args[2]) == true){
            					ConfigMaker.get().set("SetAmount", args[2]);
            					ConfigMaker.get().set("DropMode", "Set");
            					sender.sendMessage("All drops will now be set to " + args[2]);
            					ConfigMaker.save();
        						return true;
            				}
            			}
            		}
            		sender.sendMessage(ChatColor.RED + "You are missing the permission");
            		sender.sendMessage(ChatColor.RED + "randomdrops.set");
            		return false;
            	}
            	
            	if (args[0].equalsIgnoreCase("set")) {
            		if (sender.hasPermission("randomdrops.set")) {
            		
            			if(args[1].equalsIgnoreCase("random")) {
            				sender.sendMessage(Utils.chat("DropMode is now set to&c RANDOM"));
            				ConfigMaker.get().set("DropMode", "Random");
            				ConfigMaker.save();
            				return true;
            			}
            		
            			if(args[1].equalsIgnoreCase("set")) {
            				sender.sendMessage(Utils.chat("DropMode is now set to&c SET"));
            			
            				ConfigMaker.get().set("DropMode", "Set");
            				ConfigMaker.save();
            				return true;
            			}
            		}
            		sender.sendMessage(ChatColor.RED + "You are missing the permission");
            		sender.sendMessage(ChatColor.RED + "randomdrops.set");
            	}
            	
            	if (args[0].equalsIgnoreCase("info")) {
            		sender.sendMessage("With Randomdrops you can set entities and blocks to drop a set amount of blocks/items. Or a random amount with your choice of minimum and maximum");
            	}
            }  
            return true;
		}
		return false;
	}

	public static void onHelpCommand(CommandSender sender) {
		sender.sendMessage(Utils.chat("&c>>>[RandomDrops help]<<<"));
		sender.sendMessage(Utils.chat("&c/rd setup random&6 [Minimum] [Maximum]"));
		sender.sendMessage(Utils.chat("&c/rd setup set&6 [Amount]"));
		sender.sendMessage(Utils.chat("&c/rd set&6 [Random/Set]"));
		sender.sendMessage(Utils.chat("&c/rd info"));
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