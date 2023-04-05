package fpl;

public class Player {
    String name;
    String team;

    public Player(String name, String team) {
        String[] arr = name.split("[ -]");
        name=arr[arr.length-1];
        this.name=name;
        this.team =team;

    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
