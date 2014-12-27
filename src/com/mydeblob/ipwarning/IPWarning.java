package com.mydeblob.ipwarning;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class IPWarning extends JavaPlugin implements Listener{

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		String ip = e.getPlayer().getAddress().toString();
		String[] split = ip.split(":");
		for(Player p:Bukkit.getOnlinePlayers()){
			if(p.getName().equalsIgnoreCase(e.getPlayer().getName())) continue;
			String[] splitt = p.getAddress().toString().split(":");
			if(splitt[0].equalsIgnoreCase(split[0])){
				for(Player pp:Bukkit.getOnlinePlayers()){
					if(pp.hasPermission("templar.staff")){
						pp.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&4Warning&7] &c" + e.getPlayer().getName() + " has the same IP address as " + p.getName() + "!"));
					}
				}
			}
		}
	}
}
