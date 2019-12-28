package me.clip.voteparty.listener

import com.vexsoftware.votifier.model.VotifierEvent
import me.clip.voteparty.plugin.VotePartyListener
import me.clip.voteparty.plugin.VotePartyPlugin
import org.bukkit.event.EventHandler

class VoteListener(override val plugin: VotePartyPlugin) : VotePartyListener
{
	
	@EventHandler
	fun VotifierEvent.onVote()
	{
		
		val player = server.getOfflinePlayer(vote.username)
		
		if (!player.isOnline && party.conf().party?.offlineVotes == true)
		{
			// Handle adding a vote
		}
		
		val online = player.player ?: return
		
		party.voteHandler.giveGuaranteedVoteRewards(online)
		party.voteHandler.giveRandomVoteRewards(online)
		// Effects at player location
	}
}