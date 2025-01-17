import java.util.*;

class TeamManagement {
    private int teamId;
    public String TeamName;
    public LinkedList<PlayerManagement> players;
    public int totalPoints;
    public int Goals;

    // TeamManagement Constructor
    public TeamManagement(int teamId, String TeamName) {
        this.teamId = teamId;
        this.TeamName = TeamName;
        this.players = new LinkedList<>();
        this.totalPoints = 0;
        this.Goals = 0;
    }

    // Add Player to the team
    public void addPlayer(PlayerManagement player) {
        players.add(player);
    }

    // Update the total points of the team
    public void updateTotalPoints(int points) {
        this.totalPoints += points;
    }

    // Get team ID
    public int getTeamId() {
        return teamId;
    }
}

class PlayerManagement {
    private int playerId;
    public String playerName;
    public int goalsScored;
    public int teamId;
    public String Position;

    // PlayerManagement Constructor
    public PlayerManagement(int playerId, String playerName, int teamId, String Position) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.goalsScored = 0;
        this.teamId = teamId;
        this.Position = Position;
    }

    // Update the goals scored by the player
    public void updateGoalsScored(int goals) {
        this.goalsScored += goals;
    }
}

class LeagueMatches {
    private List<String> matchResults = new ArrayList<>();

    // Simulate a match between two teams
    public void simulateMatch(TeamManagement team1, TeamManagement team2) {
        Random rand = new Random();
        int team1Goals = rand.nextInt(4); // Random goals (0-3) for team1
        int team2Goals = rand.nextInt(4); // Random goals (0-3) for team2

        // Update total goals
        team1.Goals += team1Goals;
        team2.Goals += team2Goals;

        // Update points based on match result
        if (team1Goals > team2Goals) {
            team1.updateTotalPoints(3); // Team1 wins
        } else if (team1Goals < team2Goals) {
            team2.updateTotalPoints(3); // Team2 wins
        } else {
            team1.updateTotalPoints(1); // Draw
            team2.updateTotalPoints(1); // Draw
        }

        // Record match result
        matchResults.add(team1.TeamName + " " + team1Goals + " - " + team2Goals + " " + team2.TeamName);

        // Distribute goals to players
        distributeGoals(team1, team1Goals);
        distributeGoals(team2, team2Goals);
    }

    // Distribute goals among players in a team
    private void distributeGoals(TeamManagement team, int goals) {
        Random rand = new Random();
        for (int i = 0; i < goals; i++) {
            int randomPlayerIndex = rand.nextInt(team.players.size());
            team.players.get(randomPlayerIndex).updateGoalsScored(1);
        }
    }

    // Display all match results
    public void displayMatchResults() {
        System.out.println("Match Results:");
        for (String result : matchResults) {
            System.out.println(result);
        }
    }
}

class LeagueRankings {
    // Manage rankings with sorting by total points and goals
    public void manageRankings(LinkedList<TeamManagement> teams) {
        teams.sort((team1, team2) -> {
            if (team1.totalPoints != team2.totalPoints) {
                return Integer.compare(team2.totalPoints, team1.totalPoints); // Higher points first
            } else {
                return Integer.compare(team2.Goals, team1.Goals); // Higher goals first
            }
        });
    }

    // Display the rankings
    public void displayRankings(LinkedList<TeamManagement> teams) {
        System.out.println("\nLeague Rankings:");
        System.out.println("Rank | Team Name | Points | Goals");
        for (int i = 0; i < teams.size(); i++) {
            TeamManagement team = teams.get(i);
            System.out.printf("%4d | %-10s | %6d | %5d\n", i + 1, team.TeamName, team.totalPoints, team.Goals);
        }
    }
}

public class FootballLeagueManagement {
    public static void main(String[] args) {
        // Create teams
        LinkedList<TeamManagement> teams = new LinkedList<>();
        TeamManagement team1 = new TeamManagement(1, "Team1");
        TeamManagement team2 = new TeamManagement(2, "Team2");
        TeamManagement team3 = new TeamManagement(3, "Team3");
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        // Create players and assign them to teams
        team1.addPlayer(new PlayerManagement(1, "Player1", 1, "Forward"));
        team1.addPlayer(new PlayerManagement(2, "Player2", 1, "Midfielder"));

        team2.addPlayer(new PlayerManagement(3, "Player3", 2, "Defender"));
        team2.addPlayer(new PlayerManagement(4, "Player4", 2, "Goalkeeper"));

        team3.addPlayer(new PlayerManagement(5, "Player5", 3, "Forward"));
        team3.addPlayer(new PlayerManagement(6, "Player6", 3, "Midfielder"));

        // Simulate matches
        LeagueMatches leagueMatches = new LeagueMatches();
        leagueMatches.simulateMatch(team1, team2);
        leagueMatches.simulateMatch(team2, team3);
        leagueMatches.simulateMatch(team3, team1);

        // Display match results
        leagueMatches.displayMatchResults();

        // Manage and display rankings
        LeagueRankings leagueRankings = new LeagueRankings();
        leagueRankings.manageRankings(teams);
        leagueRankings.displayRankings(teams);
    }
}
