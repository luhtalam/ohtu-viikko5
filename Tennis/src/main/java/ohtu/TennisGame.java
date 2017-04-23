package ohtu;

public class TennisGame {

    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void addPoints(String playerName) {
        if (playerName == "player1") {
            playerOnePoints += 1;
        } else {
            playerTwoPoints += 1;
        }
    }

    public String pointsToString() {
        if (playerOnePoints == playerTwoPoints) {
            return equalPointsToString();
        } else if (playerOnePoints >= 4 || playerTwoPoints >= 4) {
            return winningPointsToString();
        } else {
            return pointsToString(playerOnePoints) + "-" + pointsToString(playerTwoPoints);
        }
    }

    private String pointsToString(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String equalPointsToString() {
        if (playerOnePoints > 3) {
            return "Deuce";
        } else {
            return pointsToString(playerOnePoints) + "-All";
        }
    }

    private String winningPointsToString() {
        int minusResult = playerOnePoints - playerTwoPoints;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}
