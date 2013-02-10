import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Area;


public class DynamicSleep {

	public static void bankIsOpen() {
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In bankIsOpen";
			if(Bank.isOpen()) {
				Variables.dynamicSleepStatus = "Not In";
				Task.sleep(40, 60);
				break;
			}
		}
	}

	public static void leavingBank() {
		Task.sleep(1000);
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In leavingBank";
			if(!Players.getLocal().isMoving()) {
				Variables.dynamicSleepStatus = "Not In";
				break;
			}
		}
	}

	public static void whileResting() {
		while(Variables.twoMinutes.isRunning()) {
			Variables.dynamicSleepStatus = "In whileResting";
			if(Walking.getEnergy() == Random.nextInt(90, 100)) {
				Variables.dynamicSleepStatus = "Not In";
				break;
			}
		}
	}

	public static void leavingAlterEntrance() {
		Task.sleep(1000);
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In leavingAlterEntrance";
			if(!Players.getLocal().isMoving()) {
				Variables.dynamicSleepStatus = "Not In";
				break;
			}
		}
	}

	public static void enteringAlter() {
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In enteringAlter";
			Area insideAlter = Areas.InsideAlter;
			if(insideAlter.contains(Players.getLocal().getLocation())) {
				Variables.dynamicSleepStatus = "Not In";
				Task.sleep(20, 40);
				break;
			}
		}
		
	}

	public static void leavingAlter() {
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In leavingAlter";
			Area AlterEntrance = Areas.AlterEntrence;
			if(AlterEntrance.contains(Players.getLocal().getLocation())) {
				Variables.dynamicSleepStatus = "Not In";
				Task.sleep(20, 40);
				break;
			}
		}
	}

	public static void whileCrafting() {
		while(Variables.fifteenSeconds.isRunning()) {
			Variables.dynamicSleepStatus = "In whileCrafting";
			if(Inventory.getItem(Variables.CRAFTEDRUNE_ID) != null) {
				Variables.dynamicSleepStatus = "Not In";
				Task.sleep(20, 40);
				break;
			}
		}
	}

}
