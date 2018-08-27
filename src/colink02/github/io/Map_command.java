package colink02.github.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Map_command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args[0].equalsIgnoreCase("download")) {
			if(sender.isOp()) {
				if(!args[1].isEmpty()) {
					try {
						URL website = new URL(args[1]);
						URLConnection spoof = website.openConnection();
						spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
						BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream(), "UTF-8"));
						String inputLine;
						while ((inputLine = in.readLine()) != null) {
							System.out.println(inputLine);
						}
					} catch (MalformedURLException e) {
						e.printStackTrace();
						return false;
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				} else {
					sender.sendMessage("There is no URL!");
					return false;	
				}
			} else {
				sender.sendMessage("You are not Op and cannot run this command!");
				return false;
			}
		}
		return false;
	}
	
}
