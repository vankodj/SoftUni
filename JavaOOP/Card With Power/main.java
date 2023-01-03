package cardWithPower;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();
        Card card = new Card(CardRank.valueOf(rank), CardSuits.valueOf(suit));
        System.out.printf("Card name: %s of %s; Card power: %d", card.getRankPowers(), card.getSuitPowers(), card.getPower());

    }
}
