package com.endless.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.Endless.ELCore;
import com.Endless.user.User;




public class JoinListener implements Listener {


    ELCore plugin = (ELCore)ELCore.getPlugin(ELCore.class);

	
	// Gives players their prefixes on join. 
    @SuppressWarnings("deprecation")
	@EventHandler
    public void playerJoin(PlayerJoinEvent e){
        
        User user = new User(e.getPlayer());
    	System.out.print(user.getRank().ordinal());
    	int ordinal = user.getRank().ordinal() - 8;
    	String s = String.valueOf(ordinal *= -1);
    	
    	ScoreboardManager manager = Bukkit.getScoreboardManager();
    	Scoreboard score = manager.getNewScoreboard();
    	if(score.getTeam(s + e.getPlayer().getName().substring(0,2) + user.getRank().getName().toString()) == null){
	        Team rankTab = score.registerNewTeam(s + e.getPlayer().getName().substring(0,2) + user.getRank().getName().toString());
	        rankTab.setPrefix(ChatColor.translateAlternateColorCodes('&', user.getPrefix()));
	        rankTab.addPlayer(Bukkit.getOfflinePlayer(e.getPlayer().getUniqueId()));
    	}
        
        
        e.getPlayer().setScoreboard(score);
        
        for(Player p : plugin.getServer().getOnlinePlayers()) {
        	Bukkit.getPlayer(p.getName()).setScoreboard(score);
        }
        
    }
    
}
