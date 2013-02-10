import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;


public class Traversing extends Node {

	@Override
	public boolean activate() {
		return !Areas.AlterEntrence.contains(Players.getLocal().getLocation()) &&
				!Areas.Bank.contains(Players.getLocal().getLocation()) &&
				!Areas.InsideAlter.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		Variables.runningNode = "Traversing";
		Methods.Rest();
		
		if(Inventory.getItem(Variables.CRAFTEDRUNE_ID) != null) {
			Variables.status = "Traversing to Bank...";
			Walking.newTilePath(Paths.AlterToBank).traverse();
		} else {
			Variables.status = "Traversing to Alter...";
			Walking.newTilePath(Paths.BankToAlter).traverse();
		}
	}

}
