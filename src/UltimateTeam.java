import java.util.ArrayList;

public class UltimateTeam {
    private ArrayList<UltimatePlayer> players;
    private ArrayList<Coach> coaches;

    public UltimateTeam(ArrayList<UltimatePlayer> players, ArrayList<Coach> coaches) {
        this.players = players;
        this.coaches = coaches;
    }

    public String getCutters() {
        return getPlayersByPosition("cutter");
    }

    public String getHandlers() {
        return getPlayersByPosition("handler");
    }

    public String toString() {
        String s = "Coaches";
        for (Coach coach : this.coaches) {
            s += coach.toString() + " ";
        }
        s += "Players";
        for (UltimatePlayer player : this.players) {
            s += player.toString() + " ";
        }
        return s;
    }
    private String getPlayersByPosition(String position) {
        String s = "";
        for (UltimatePlayer player : this.players) {
            if (position.equals(player.getPosition())) {
                s += player.toString() + " ";
            }
        }
        return s;
    }

}
