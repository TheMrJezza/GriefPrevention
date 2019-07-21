package me.ryanhamshire.GriefPrevention.events;

import java.util.UUID;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.ryanhamshire.GriefPrevention.Claim;

/**
 * This Event is thrown when a claim is transfered....it is modifiable and can
 * be cancelled. The CommandSender can be null in the event that the Transfer
 * is called by another plugin that either didn't or couldn't report a sender.
 * Created by TheMrJezza on 22/07/2019.
 */
public class ClaimTransferEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private boolean isCancelled = false;

	private final Claim claim;
	private CommandSender modifier;
	private UUID newOwner;

	public ClaimTransferEvent(Claim claim, CommandSender modifier, UUID newOwner) {
		this.claim = claim;
		this.modifier = modifier;
		this.newOwner = newOwner;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	/**
	 * The claim
	 *
	 * @return the claim
	 */
	public Claim getClaim() {
		return claim;
	}

	/**
	 * The actor making the change...can be null
	 *
	 * @return the CommandSender or null
	 */
	public CommandSender getModifier() {
		return modifier;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		isCancelled = cancel;
	}

	public UUID getNewOwner() {
		return newOwner;
	}
	
	public void setNewOwner(UUID uuid) {
		newOwner = uuid;
	}
}
