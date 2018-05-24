package ua.kpi.tef.entities;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Socket socket;
    private List<Card> cards = new ArrayList<>();

    public Player(Socket socket) {
        this.socket = socket;
    }

    public boolean addCard(Card card) {
        return cards.add(card);
    }

    public Socket getSocket() {
        return socket;
    }

    public List<Card> getCards() {
        return cards;
    }
}
