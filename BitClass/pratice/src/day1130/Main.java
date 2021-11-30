package day1130;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{
    private int rank;
    private String suit;

    public Card(String suit,int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
class Main{
    private static String[] Suits={"♥","♠","♣","♦"};
    public static List<Card> buyCard(){
        List<Card> deck=new ArrayList<>(52);
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                deck.add(new Card(Suits[i],j));
            }
        }
        return deck;
    }
    public static void swap(List<Card> card,int i,int j){
        Card tmp=card.get(i);
        card.set(i, card.get(j));
        card.set(j,tmp);
    }
    public static void shuffle(List<Card> card){
        Random random=new Random(20190905);
        for(int i=card.size()-1;i>0;i--){
            int r= random.nextInt(i);
            swap(card,i,r);
        }
    }
    public static void main(String[] args) {
        List<Card> deck=buyCard();
        System.out.println("已经买牌");
        shuffle(deck);
        System.out.println("已经洗牌");
        List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("A 手中的牌:");
        System.out.println(hands.get(0));
        System.out.println("B 手中的牌:");
        System.out.println(hands.get(1));
        System.out.println("C 手中的牌:");
        System.out.println(hands.get(2));
    }
}

