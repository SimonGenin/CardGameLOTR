package be.simongenin;

public enum Attribut {

    /**
     * Is a general.
     * Gives +1 in life and strength to every
     * card that is from the team.
     */
    GENERAL,

    /**
     * Can only be attacked by a card with more than
     * the half of current strength AND life.
     */
    AURA_OF_TERROR,

    /**
     * Can only be played if you have the card
     * "The one Ring" in your hand. The card the one ring
     * is removed from the game.
     */
    THE_ONE_RING,

    /**
     * Give +2 in strength and life for every card of your side,
     * -1 in strength and life for every card of the oponent side.
     */
    HERO

}
