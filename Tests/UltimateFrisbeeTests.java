import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UltimateFrisbeeTests {

    private static Player player;
    private static Player playerNoName;
    private static UltimatePlayer player1;
    private static UltimatePlayer player2;
    private static UltimatePlayer player3;
    private static Captain captain;
    private static Captain defaultCaptain;
    private static Coach coach;
    private static Coach defaultCoach;
    private static ArrayList<UltimatePlayer> players;
    private static ArrayList<UltimatePlayer> noCutters;
    private static ArrayList<UltimatePlayer> noHandlers;
    private static ArrayList<Coach> coaches;
    private static UltimateTeam team;
    private static UltimateTeam teamNC;
    private static UltimateTeam teamNH;


    @BeforeAll
    static void setup() {
        player = new Player("John", "Doe");
        playerNoName = new Player();
        player1 = new UltimatePlayer("Mary", "Smith", "cutter"); // 1
        player2 = new UltimatePlayer("Erik", "Letzing", "defender"); // 2
        player3 = new UltimatePlayer();

        captain = new Captain("Henry", "Tully", "handler", true); // 3
        defaultCaptain = new Captain();

        coach = new Coach("Sara", "Lee", "Head Coach");
        defaultCoach = new Coach();


        players = new ArrayList<UltimatePlayer>();
        players.add(new UltimatePlayer("Sammy", "Trong", "handler")); // 4
        players.add(new UltimatePlayer("Jayant", "Patel", "handler")); // 5
        players.add(new UltimatePlayer("Myra", "Ozaeta", "cutter")); // 6
        players.add(new UltimatePlayer("Lisa", "Holbrook", "cutter")); // 7
        players.add(new UltimatePlayer("Lisbeth", "Kvale", "cutter")); // 8
        players.add(new Captain("Malik", "Henry", "handler", true)); // 9
        players.add(new Captain("Joseph", "Pak", "cutter", false)); // 10

        noCutters = new ArrayList<UltimatePlayer>();
        noCutters.add(new UltimatePlayer("Alan", "Turing", "handler")); // 11
        noCutters.add(new UltimatePlayer("Grace", "Hopper", "handler")); // 12
        noCutters.add(new UltimatePlayer("Ada", "Lovelace", "handler")); // 13

        noHandlers = new ArrayList<UltimatePlayer>();
        noHandlers.add(new UltimatePlayer("Charles", "Babbage", "cutter")); // 14
        noHandlers.add(new UltimatePlayer("Margaret", "Hamilton", "cutter")); // 15

        coaches = new ArrayList<Coach>();
        coaches.add(new Coach("Maryam", "Mathour", "Head Coach"));
        coaches.add(new Coach("Soren", "Van Loben Sels", "Assistant Coach"));

        team = new UltimateTeam(players, coaches);
        teamNC = new UltimateTeam(noCutters, coaches);
        teamNH = new UltimateTeam(noHandlers, coaches);
    }

//


   // }
    @Test
    public void testPlayer() {

        assertEquals("Doe, John", player.toString());
        assertEquals("unknown, unknown", playerNoName.toString());

    }

    @Test
    public void testUltimatePlayer() {


        String expected1 = "Smith, Mary\n   Jersey #: 1\n   Position: cutter";
        String expected2 = "Letzing, Erik\n   Jersey #: 2\n   Position: handler";
        String expected3 = "unknown, unknown\n   Jersey #: 0\n   Position: handler";
        assertEquals(expected1, player1.toString());
        assertEquals(expected2, player2.toString());
        assertEquals(expected3, player3.toString());
    }

    @Test
    public void testCaptain() {
        String expected1 = "Tully, Henry\n   Jersey #: 3\n   Position: handler\n   Captain: offense";
        String expected2 = "unknown, unknown\n   Jersey #: 0\n   Position: handler\n   Captain: defense";
        assertEquals(expected1, captain.toString());
        assertEquals(expected2, defaultCaptain.toString());
    }

    @Test
    public void testCoach() {
        String expected1 = "Lee, Sara\n   Role: Head Coach";
        String expected2 = "unknown, unknown\n   Role: coach";
        assertEquals(expected1, coach.toString());
        assertEquals(expected2, defaultCoach.toString());
    }

    @Test
    public void testNoCutters() {
        assertEquals("", teamNC.getCutters());
    }

    @Test
    public void testNoHandlers() {
        assertEquals("", teamNH.getCutters());
    }

    @Test
    public void testGetCutters() {

        String expected = "Ozaeta, Myra\n   Jersey #: 6\n   Position: cutter\n\n" +
                "Holbrook, Lisa\n   Jersey #: 7\n   Position: cutter\n\n" +
                "Kvale, Lisbeth\n   Jersey #: 8\n   Position: cutter\n\n" +
                "Pak, Joseph\n   Jersey #: 10\n   Position: cutter\n   Captain: defense\n\n";
        assertEquals(expected, team.getCutters());
    }

    @Test
    public void testGetHandlers() {

        String expected = "Trong, Sammy\n   Jersey #: 4\n   Position: handler\n\n" +
                "Patel, Jayant\n   Jersey #: 5\n   Position: handler\n\n" +
                "Henry, Malik\n   Jersey #: 9\n   Position: handler\n   Captain: offense\n\n";
        assertEquals(expected, team.getHandlers());
    }

    @Test
    public void teamToString() {
        String expected1 = "COACHES\n" + "Mathour, Maryam\n   Role: Head Coach\n\n" +
                "Van Loben Sels, Soren\n   Role: Assistant Coach\n\n";
        String expected2 = "PLAYERS\nTrong, Sammy\n   Jersey #: 4\n   Position: handler\n\n" +
                "Patel, Jayant\n   Jersey #: 5\n   Position: handler\n\n" +
                "Ozaeta, Myra\n   Jersey #: 6\n   Position: cutter\n\n" +
                "Holbrook, Lisa\n   Jersey #: 7\n   Position: cutter\n\n" +
                "Kvale, Lisbeth\n   Jersey #: 8\n   Position: cutter\n\n" +
                "Henry, Malik\n   Jersey #: 9\n   Position: handler\n   Captain: offense\n\n" +
                "Pak, Joseph\n   Jersey #: 10\n   Position: cutter\n   Captain: defense\n\n";
        assertEquals(expected1+expected2, team.toString());
    }



}