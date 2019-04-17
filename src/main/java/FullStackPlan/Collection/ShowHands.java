package FullStackPlan.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHands {
    private int playersCount = 2;
    private String[] types = {"方块", "梅花", "红桃", "黑桃"};
    private String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private List<String> cards = new LinkedList<String>();
    private List<String> players = new ArrayList<String>();
    private List<String>[] playCards = new List[playersCount];

    public List<String> iniCards() {
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] +"-"+ values[j]);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    public void iniPlayers(String... names) {
        for (int i = 0; i < playersCount; i++) {
            players.add(names[i]);
        }

    }

    public void iniPlayCards() {
        for (int i = 0; i < players.size(); i++) {
            playCards[i] = new LinkedList<String>();
        }
    }

    public void dealCards(int dealCounts) {
        for (int j = 0; j < dealCounts; j++) {
            for (int i = 0; i < players.size(); i++) {
                playCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
//        iniCards();
//        System.out.println(playCards[0].get(0));
//        for (List<String> list : playCards) {
//            System.out.println(list);
//        }
    }

    public void showPlayerCards() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i) + ": ");
            for (String card : playCards[i]) {
                System.out.println(card + "\t");
            }
            System.out.println("\n");
        }
    }
    public String getCardType(String card){
        String type=null;
        String[] tmp;
        tmp=card.split("-");
        type=tmp[0];
        return type;
    }
    public String getCardValue(String card){
        String value=null;
        String[] tmp;
        tmp=card.split("-");
        value=tmp[1];
        return value;
    }
//    public int getShowHandsType(LinkedList<String> playerCards){
//        for (int i=0;i<playerCards.size();i++){
//            for (int j=i+1;j<playerCards.size();j++){
////                if (getCardValue())
//            }
//
//    }}

    public static void main(String[] args) {
        ShowHands showHands = new ShowHands();
//        System.out.println(showHands.iniCards().size());//如果调用了这句，会进行两次初始化牌，下面语句会打印出两副牌
//        for(String card:showHands.iniCards()){
//            System.out.println(card);
        showHands.iniPlayers("我", "你");
        showHands.iniCards();
        showHands.iniPlayCards();//一开始忘记调用初始化手牌方法，报空指针异常，因为playCards[]数组里面元素为空
        showHands.dealCards(5);
        showHands.showPlayerCards();
System.out.println(showHands.getCardType("梅花-2"));
    }
}

