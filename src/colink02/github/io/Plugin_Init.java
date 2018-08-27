package colink02.github.io;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin_Init extends JavaPlugin {

	@Override
	public void onEnable() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.isOp()) {
				p.sendMessage("Map Downloader is ready!");
			}
		}
	}
	@Override
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.isOp()) {
				p.sendMessage("Map Downloader has been disabled!");
			}
		}
	}
	
	
}
