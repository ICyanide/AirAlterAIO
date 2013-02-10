import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;


public class Banking extends Node {

	@Override
	public boolean activate() {
		return Areas.Bank.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		Variables.runningNode = "Banking";
		
		if(Inventory.isFull() && !Bank.isOpen()) {
			Variables.status = "Leaving Bank...";
			Methods.leaveBank();
			sleep(200, 400);
		} else {
			Variables.status = "Opening Bank...";
			Methods.openBank();
			sleep(200, 400);
		}
		
		if(Bank.isOpen()) {
			Variables.status = "Banking...";
			sleep(20, 40);
			Methods.neckyCheck();
			sleep(20, 40);
			Methods.doBanking();
			sleep(200, 400);
		}
	}
}
