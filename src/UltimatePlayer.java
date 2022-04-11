public class UltimatePlayer extends Player {
    private static int jerseyNumberCounter = 0;
    private int jerseyNumber;
    private String position;

    public UltimatePlayer(String firstName, String lastName, String position) {
        super(firstName, lastName);

        if("cutter".equals(position) || "handler".equals(position))
            this.position = position;
        else this.position = "handler";

        this.jerseyNumberCounter++;
        this.jerseyNumber = jerseyNumberCounter;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        return super.toString() + "\n   Jersey #: " + this.jerseyNumber + "\n   Position: " + this.position;
    }
}

