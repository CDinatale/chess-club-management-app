/*
Corradina Dinatale 100645103
 Alex Balez 101219847
 */
package chessclubmanagement;

/**
 *
 * @author corad
 */
public class Member {

    private int memberNo;
    private String firstName;
    private String lastName;
    private int gamesPlayed;
    private int wins;
    private int losses;

    public Member() {
    }

    public Member(int memberNo, String firstName, String lastName, int gamesPlayed, int wins, int losses) {

        this.memberNo = memberNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWinRate() {

        double winRate = (double) wins / gamesPlayed;
        return winRate;
    }

    @Override
    public String toString() {
        String s = "";

        s += "\nMember ID: " + memberNo + "\n" + "First Name = " + firstName + "\n" + "Last Name = " + lastName + "\n"
                + "Games Played = " + gamesPlayed + "\n" + "Wins = " + wins + "\n" + "Losses = " + losses + "\n";
        return s;
    }

}
