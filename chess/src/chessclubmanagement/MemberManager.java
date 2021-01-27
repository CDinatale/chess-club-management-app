/*
Corradina Dinatale 100645103
 Alex Balez 101219847
 */
package chessclubmanagement;

import java.util.ArrayList;

/**
 *
 * @author corad
 */
public class MemberManager {

    private static int currentUnusedMemberNo;
    private int maxMembers;
    private int numMembers;
    private Member[] mList;

    public MemberManager(int memberNoSeed, int maxMembers) {

        currentUnusedMemberNo = memberNoSeed;
        this.maxMembers = maxMembers;
        numMembers = 0;
        mList = new Member[maxMembers];
    }

    public boolean addMember(String firstName, String lastName, int gamesPlayed, int wins, int losses) {

        Member newMember = new Member(currentUnusedMemberNo, firstName, lastName, gamesPlayed, wins, losses);

        if (numMembers < maxMembers) {

            mList[numMembers] = newMember;
            numMembers++;
            currentUnusedMemberNo++;
            return true;
        }
        return false;
    }

    public int findMember(int memberNo) {

        for (int x = 0; x < numMembers; x++) {
            if (mList[x].getMemberNo() == memberNo) {
                return x;
            }
        }
        return -1;
    }

    public boolean deleteMember(int memberNo) {

        int loc = findMember(memberNo);
        if (loc == -1) {
            return false;
        }
        mList[loc] = mList[numMembers - 1];
        numMembers--;
        return true;
    }

    public String getMemberList() {

        String s = "-----------Member List----------";
        for (int x = 0; x < numMembers; x++) {
            s += "\n\nMember ID: " + mList[x].getMemberNo() + "\nFirst Name: " + mList[x].getFirstName()
                    + "\nLast Name: " + mList[x].getLastName() + "\nGames Played: " + mList[x].getGamesPlayed()
                    + "\nWins: " + mList[x].getWins() + "\nLosses: " + mList[x].getLosses()
                    + "\nWin Rate: " + mList[x].getWinRate() + "\n";
        }
        return s;
    }

    public boolean updateWins(int memberNo, int wins) {

        int loc = findMember(memberNo);
        if (loc == -1) {
            return false;
        }
        int currentWins = mList[loc].getWins();
        int currentGamesPlayed = mList[loc].getGamesPlayed();
        mList[loc].setWins(currentWins + wins);
        mList[loc].setGamesPlayed(currentGamesPlayed + wins);
        return true;

    }

    public boolean updateLosses(int memberNo, int losses) {

        int loc = findMember(memberNo);
        if (loc == -1) {
            return false;
        }
        int currentLosses = mList[loc].getLosses();
        int currentGamesPlayed = mList[loc].getGamesPlayed();
        mList[loc].setLosses(currentLosses + losses);
        mList[loc].setGamesPlayed(currentGamesPlayed + losses);
        return true;
    }

    public String viewBestPlayer() {

        double highestWinningRate = mList[0].getWinRate();
        Member bestPlayer = mList[0];

        for (int i = 0; i < numMembers; i++) {
            if (highestWinningRate < mList[i].getWinRate()) {
                bestPlayer = mList[i];

            }
        }
        return bestPlayer.toString();
    }

    public String viewMostWins() {

        double mostWins = mList[0].getWins();
        Member playerWithMostWins = mList[0];
        ArrayList<Member> playerList = new ArrayList<>();
        String s = "";

        for (int i = 0; i < numMembers; i++) {
            if (mostWins < mList[i].getWins()) {
                playerWithMostWins = mList[i];

            }
        }

        playerList.add(playerWithMostWins);

        for (int i = 0; i < numMembers; i++) {

            if (playerWithMostWins.getWins() == mList[i].getWins() && playerWithMostWins != mList[i]) {
                playerList.add(mList[i]);
            }

        }
        for (Member i : playerList) {
            s += "\nMember ID: " + i.getMemberNo() + "\nFirst Name: " + i.getFirstName()
                    + "\nLast Name: " + i.getLastName() + "\nGames Played: " + i.getGamesPlayed()
                    + "\nWins: " + i.getWins() + "\nLosses: " + i.getLosses()
                    + "\nWin Rate: " + i.getWinRate() + "\n";
        }
        return s;

    }

}
