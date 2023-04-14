package fpl;

public class Player {
    private String name;
    private String team;
    public Player(String name, String team) {
        String[] arr = name.split("[ -]");
        name = arr[arr.length - 1];
        this.name = name;
        this.team = team;
    }
    public String getName() {
        return this.name;
    }
    public String getTeam() {
        return this.team;
    }
}
