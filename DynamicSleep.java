import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;


public class DynamicSleep {

	static Timer fifteenSeconds;
	static Timer twoMinutes;
	
	public static void bankIsOpen() {
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && !Bank.isOpen()) {
			Variables.dynamicSleepStatus = "In bankIsOpen";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void leavingBank() {
		Task.sleep(1000);
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && Players.getLocal().isMoving()) {
			Variables.dynamicSleepStatus = "In leavingBank";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void whileResting() {
		twoMinutes = new Timer(120000);
		while(twoMinutes.isRunning() && Walking.getEnergy() != Random.nextInt(90, 100)) {
			Variables.dynamicSleepStatus = "In whileResting";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void leavingAlterEntrance() {
		Task.sleep(1000);
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && Players.getLocal().isMoving()) {
			Variables.dynamicSleepStatus = "In leavingAlterEntrance";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void enteringAlter() {
		Area insideAlter = Areas.InsideAlter;
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && !insideAlter.contains(Players.getLocal().getLocation())) {
			Variables.dynamicSleepStatus = "In enteringAlter";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void leavingAlter() {
		Area AlterEntrance = Areas.AlterEntrence;
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && !AlterEntrance.contains(Players.getLocal().getLocation())) {
			Variables.dynamicSleepStatus = "In leavingAlter";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

	public static void whileCrafting() {
		fifteenSeconds = new Timer(15000);
		while(fifteenSeconds.isRunning() && !(Inventory.getItem(Variables.CRAFTEDRUNE_ID) != null)) {
			Variables.dynamicSleepStatus = "In whileCrafting";
			Task.sleep(50);
		}
		Variables.dynamicSleepStatus = "Not In";
	}

}
