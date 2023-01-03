package cardWithPower;

public class Card {
    private CardRank rankPowers;
    private CardSuits suitPowers;
    private int power;

    public Card(CardRank rankPowers, CardSuits suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
        this.power = this.rankPowers.getPower() + this.suitPowers.getPower();
    }

    public CardRank getRankPowers() {
        return rankPowers;
    }

    public void setRankPowers(CardRank rankPowers) {
        this.rankPowers = rankPowers;
    }

    public CardSuits getSuitPowers() {
        return suitPowers;
    }

    public void setSuitPowers(CardSuits suitPowers) {
        this.suitPowers = suitPowers;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
