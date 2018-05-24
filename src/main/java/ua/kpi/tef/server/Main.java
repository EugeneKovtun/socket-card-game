package ua.kpi.tef.server;

import ua.kpi.tef.entities.CardDeck;
import ua.kpi.tef.entities.Player;
import ua.kpi.tef.utils.CardUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            Player player1 = new Player(server.accept());
            System.out.println("First player connected");
            PrintWriter firstPlayerWriter = new PrintWriter(player1.getSocket().getOutputStream(), true);
            firstPlayerWriter.println("Waiting for second player...");
            Player player2 = new Player(server.accept());
            System.out.println("Second player connected");
            PrintWriter secondPlayerWriter = new PrintWriter(player2.getSocket().getOutputStream(), true);
            CardDeck cardDeck = new CardDeck();
            cardDeck.shuffle();
            CardUtils.giveOut(player1, player2, cardDeck);
            firstPlayerWriter.println("You cards is " + player1.getCards());
            secondPlayerWriter.println("You cards is" + player2.getCards());
//
//            Scanner firstPlayerScanner = new Scanner(player1.getSocket().getInputStream());
//            int index = inputIntegerWithScanner(firstPlayerScanner);
//
//            secondPlayerWriter.println(player1.getCards().get(index - 1));
//
//            Scanner secondPlayerScanner = new Scanner(player2.getSocket().getInputStream());
//            index = inputIntegerWithScanner(secondPlayerScanner);
//
//            firstPlayerWriter.println(player2.getCards().get(index - 1));

            player1.getSocket().close();
            player2.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int inputIntegerWithScanner(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Main.inputIntegerWithScanner");
        }
        System.out.println("jjasd");
        return scanner.nextInt();
    }

}
