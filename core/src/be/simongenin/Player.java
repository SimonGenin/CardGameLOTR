package be.simongenin;

import java.util.List;

public class Player {

    // Infos
    private String name;
    private int points;
    private int level;

    // Cards - General
    private List<Card> cards;
    private List<Deck> decks;

    // Cards - In Game
    private List<Card> handCards;
    private List<Card> boardCards;

    private int health;

}
