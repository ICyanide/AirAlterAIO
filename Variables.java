import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;


public class Variables {

	public static int TALISMAN_ID; 
	public static int ELEMENTALRUNE_ID;
	public static int CRAFTEDRUNE_ID;
	public static int ESSENCE_ID;
	public static int numRuns = 0;
	public static int runesMadeThisRun = 0;
	public static int totalRunesMade = 0;
	
	
	public static String status = "Loading...";
	
	public static boolean playerIsInAlterEntrance() {
		Area alterEntrance = Areas.AlterEntrence;
		return alterEntrance.contains(Players.getLocal().getLocation());
	}

	public static boolean playerIsInsideAlter() {
		Area insideAlter = Areas.InsideAlter;
		return insideAlter.contains(Players.getLocal().getLocation());
	}
}
