public class Captain extends UltimatePlayer {
    private boolean type;
    private String actualType;

    public Captain(String firstName, String lastName, String position, boolean type) {
        super(firstName, lastName, position);
        this.type = type;

        if(type) actualType = "offense";
        else actualType = "defense";
    }

    public String toString() {
        return super.toString() + "\n   Captain: " + actualType;
    }
}
