package cs350.poker.analysis;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Before;
import org.junit.Test;

import cs350.poker.model.Card;
import cs350.poker.model.Hand;

/**
 * Comprehensive JUnit 4 tests for the {@link HandComparator} class.
 *
 * <p>Tests cover comparisons between different hand types, tiebreakers
 * within the same hand type, symmetry, edge cases, and failure scenarios.</p>
 *
 * @author Poker Demo
 * @version 1.0
 */
public class HandComparatorTest {

    private HandComparator comparator;

    @Before
    public void setUp() {
        comparator = new HandComparator();
    }

    private Hand makeHand(int[][] cards) {
        Hand hand = new Hand();
        for (int[] card : cards) {
            hand.addCard(new Card(card[0], card[1]));
        }
        return hand;
    }

    // ==================== Different Hand Type Comparisons ====================

    @Test
    public void testRoyalFlushBeatsStraightFlush() {
        Hand royalFlush = makeHand(new int[][]{{3,10},{3,11},{3,12},{3,13},{3,1}});
        Hand straightFlush = makeHand(new int[][]{{2,5},{2,6},{2,7},{2,8},{2,9}});
        assertThat(comparator.compare(royalFlush, straightFlush), greaterThan(0));
    }

    @Test
    public void testStraightFlushBeatsFourOfAKind() {
        Hand straightFlush = makeHand(new int[][]{{4,5},{4,6},{4,7},{4,8},{4,9}});
        Hand fourOfAKind = makeHand(new int[][]{{1,1},{2,1},{3,1},{4,1},{1,13}});
        assertThat(comparator.compare(straightFlush, fourOfAKind), greaterThan(0));
    }

    @Test
    public void testFourOfAKindBeatsFullHouse() {
        Hand fourOfAKind = makeHand(new int[][]{{1,9},{2,9},{3,9},{4,9},{1,5}});
        Hand fullHouse = makeHand(new int[][]{{1,13},{2,13},{3,13},{4,5},{1,5}});
        assertThat(comparator.compare(fourOfAKind, fullHouse), greaterThan(0));
    }

    @Test
    public void testFullHouseBeatsFlush() {
        Hand fullHouse = makeHand(new int[][]{{1,8},{2,8},{3,8},{4,3},{1,3}});
        Hand flush = makeHand(new int[][]{{3,2},{3,5},{3,7},{3,9},{3,12}});
        assertThat(comparator.compare(fullHouse, flush), greaterThan(0));
    }

    @Test
    public void testFlushBeatsStraight() {
        Hand flush = makeHand(new int[][]{{1,2},{1,5},{1,8},{1,11},{1,13}});
        Hand straight = makeHand(new int[][]{{1,5},{2,6},{3,7},{4,8},{1,9}});
        assertThat(comparator.compare(flush, straight), greaterThan(0));
    }

    @Test
    public void testStraightBeatsThreeOfAKind() {
        Hand straight = makeHand(new int[][]{{1,5},{2,6},{3,7},{4,8},{1,9}});
        Hand trips = makeHand(new int[][]{{1,9},{2,9},{3,9},{4,4},{1,2}});
        assertThat(comparator.compare(straight, trips), greaterThan(0));
    }

    @Test
    public void testThreeOfAKindBeatsTwoPair() {
        Hand trips = makeHand(new int[][]{{1,7},{2,7},{3,7},{4,4},{1,2}});
        Hand twoPair = makeHand(new int[][]{{1,1},{2,1},{3,13},{4,13},{1,9}});
        assertThat(comparator.compare(trips, twoPair), greaterThan(0));
    }

    @Test
    public void testTwoPairBeatsOnePair() {
        Hand twoPair = makeHand(new int[][]{{1,8},{2,8},{3,5},{4,5},{1,3}});
        Hand onePair = makeHand(new int[][]{{1,1},{2,1},{3,13},{4,12},{1,10}});
        assertThat(comparator.compare(twoPair, onePair), greaterThan(0));
    }

    @Test
    public void testOnePairBeatsHighCard() {
        Hand onePair = makeHand(new int[][]{{1,2},{2,2},{3,5},{4,8},{1,11}});
        Hand highCard = makeHand(new int[][]{{1,1},{2,13},{3,12},{4,10},{1,8}});
        assertThat(comparator.compare(onePair, highCard), greaterThan(0));
    }

    // ==================== Same Type Tiebreakers ====================

    @Test
    public void testHighCardTiebreakerHigherKicker() {
        // Both high card; first has K as second kicker, second has Q
        Hand higher = makeHand(new int[][]{{1,1},{2,13},{3,10},{4,7},{1,3}});
        Hand lower = makeHand(new int[][]{{2,1},{1,12},{4,10},{3,7},{2,3}});
        assertThat(comparator.compare(higher, lower), greaterThan(0));
    }

    @Test
    public void testPairTiebreakerHigherPair() {
        Hand kingsHigh = makeHand(new int[][]{{1,13},{2,13},{3,5},{4,3},{1,2}});
        Hand jacksHigh = makeHand(new int[][]{{1,11},{2,11},{3,5},{4,3},{1,2}});
        assertThat(comparator.compare(kingsHigh, jacksHigh), greaterThan(0));
    }

    @Test
    public void testIdenticalHandsTie() {
        // Same cards in both hands = exact tie
        Hand hand1 = makeHand(new int[][]{{1,2},{1,5},{1,8},{1,11},{1,1}});
        Hand hand2 = makeHand(new int[][]{{1,2},{1,5},{1,8},{1,11},{1,1}});
        assertThat(comparator.compare(hand1, hand2), is(0));
    }

    // ==================== Symmetry & Transitivity ====================

    @Test
    public void testSymmetry() {
        Hand better = makeHand(new int[][]{{1,1},{2,1},{3,1},{4,1},{1,13}});
        Hand worse = makeHand(new int[][]{{1,5},{2,5},{3,9},{4,11},{1,13}});
        assertThat(comparator.compare(better, worse), greaterThan(0));
        assertThat(comparator.compare(worse, better), lessThan(0));
    }

    @Test
    public void testReflexive() {
        Hand hand = makeHand(new int[][]{{1,5},{2,6},{3,7},{4,8},{1,9}});
        assertThat(comparator.compare(hand, hand), is(0));
    }

    // ==================== Failure Cases ====================

    @Test(expected = IllegalArgumentException.class)
    public void testCompareNullFirstHand() {
        Hand hand = makeHand(new int[][]{{1,2},{2,5},{3,8},{4,11},{1,1}});
        comparator.compare(null, hand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareNullSecondHand() {
        Hand hand = makeHand(new int[][]{{1,2},{2,5},{3,8},{4,11},{1,1}});
        comparator.compare(hand, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareBothNull() {
        comparator.compare(null, null);
    }
}
