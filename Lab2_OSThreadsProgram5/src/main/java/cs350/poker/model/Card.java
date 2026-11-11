package cs350.poker.model;

/**
 * Represents a single immutable playing card in a standard 52-card deck.
 *
 * <p>Each card is identified by a suit (1=Clubs, 2=Diamonds, 3=Hearts, 4=Spades)
 * and a face value (1=Ace, 2=2, ..., 11=Jack, 12=Queen, 13=King). Cards are
 * immutable once constructed; no mutator methods are provided.</p>
 *
 * <p>The rank of a card is computed so that Aces are highest and Deuces lowest.
 * Rank formula: if Ace, rank = 12*4 + suit; otherwise rank = (faceValue - 2)*4 + suit.
 * This yields a unique rank for every card in the deck (1..52).</p>
 *
 * @author Poker Demo
 * @version 1.0
 */
public class Card implements Comparable<Card> {

   // define the card class using test driven development
	
}
