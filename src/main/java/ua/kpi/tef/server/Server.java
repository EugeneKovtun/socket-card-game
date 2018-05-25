package ua.kpi.tef.server;

import ua.kpi.tef.entities.Card;
import ua.kpi.tef.entities.CardDeck;
import ua.kpi.tef.entities.Player;
import ua.kpi.tef.utils.CardUtils;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            Player player1 = new Player(server.accept());
            System.out.println("First player connected");
            PrintWriter firstPlayerWriter = new PrintWriter(player1.getSocket().getOutputStream(), true);
            //firstPlayerWriter.println("Waiting for second player...");
            Player player2 = new Player(server.accept());
            System.out.println("Second player connected");
            PrintWriter secondPlayerWriter = new PrintWriter(player2.getSocket().getOutputStream(), true);

            CardDeck cardDeck = new CardDeck();
            cardDeck.shuffle();
            CardUtils.giveOut(player1, player2, cardDeck);
            firstPlayerWriter.println("You cards is " + player1.getCards()
                    + "\nTrump is" + cardDeck.getTrumpCard());
            secondPlayerWriter.println("You cards is" + player2.getCards()
                    + "\nTrump is" + cardDeck.getTrumpCard());


//            InputStream is1 = player1.getSocket().getInputStream();
//            InputStreamReader isr1 = new InputStreamReader(is1);
//            BufferedReader br1 = new BufferedReader(isr1);
//            System.out.println("Server.main");
//            String number = br1.readLine();
//            System.out.println("Server.main");
            InputStream is = player1.getSocket().getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String number = br.readLine();
            System.out.println("Message received from client is "+number);

            Card card1 = player1.getCards().get(Integer.parseInt(number) - 1);
//            System.out.println("Message received from client is " + number);
            secondPlayerWriter.println("You attacked by " + card1);


            InputStream is2 = player2.getSocket().getInputStream();
            InputStreamReader isr2 = new InputStreamReader(is2);
            BufferedReader br2 = new BufferedReader(isr2);
            number = br2.readLine();
            Card card2 = player2.getCards().get(Integer.parseInt(number) - 1);
            firstPlayerWriter.println("Enemy response with" + card2);


            if (CardUtils.compareCardWithTrump(card1, card2, cardDeck.getTrumpCard().getSuit()) > 0) {
                firstPlayerWriter.println("you win");
                secondPlayerWriter.println("you lose");
            } else if (CardUtils.compareCardWithTrump(card1, card2, cardDeck.getTrumpCard().getSuit()) < 0) {
                firstPlayerWriter.println("you lose");
                secondPlayerWriter.println("you win");
            } else {
                firstPlayerWriter.println("nobody win");
                secondPlayerWriter.println("nobody win");
            }

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


}
