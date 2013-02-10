import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;


public class Crafting extends Node {

	@Override
	public boolean activate() {
		return Areas.AlterEntrence.contains(Players.getLocal().getLocation()) ||
				Areas.InsideAlter.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		
		if(Variables.playerIsInAlterEntrance()) {
			if(Inventory.getItem(Variables.ESSENCE_ID) != null) {
				Variables.status = "Entering Alter...";
				Methods.enterAlter();
			} else {
			Variables.status = "Leaving Alter Entrance...";
			Methods.leaveAlterEntrance();
			}
		}
		
		if(Variables.playerIsInsideAlter()) {
			if(Inventory.getItem(Variables.ESSENCE_ID) != null) {
				Variables.status = "Crafting Runes...";
				sleep(20, 40);
				Methods.craftRunes();
				Variables.numRuns += 1;
				Variables.runesMadeThisRun = Inventory.getItem(Variables.CRAFTEDRUNE_ID).getStackSize();
				Variables.totalRunesMade += Variables.runesMadeThisRun;
			} else {
				Variables.status = "Leaving Alter...";
				sleep(300, 400);
				Methods.leaveAlter();
			}
		}
	}

}
