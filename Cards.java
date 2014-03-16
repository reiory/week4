import java.util.*;
import java.io.*;

class Cards{
	private ArrayList<Card> cards = new ArrayList<Card>();
	int total;
	public Cards(int brand){
		String[] suits = new String[] {"Club","Heart","Diamond","Spade"};//花色
		total = brand *52;
		for(int i = 0; i < total; i++){
			String suit = suits[i / (13 * brand)];//花色
			int value = 1 + i % 13;//牌號
			Card newCard = new Card(suit,value);
			cards.add(newCard);
		}
		Shuffle();
	}
	void Shuffle()
	{
		Random ran = new Random();
		for(int i = 0; i < cards.size(); i++){
			int x = ran.nextInt(total);//random
			Collections.swap(cards, i, x);//交換 i , x
		}
	}
	public Card draw(){//抽牌
		if(cards.size() < total/2)
			refresh();
		Card temp = cards.get(0);
		cards.remove(0);
		total = total - 1;
		return temp;
	}
	private void refresh(){
		cards=null;
		System.gc();
		ArrayList<Card> N = new ArrayList<Card>();
		cards=N;
		String[] suits = new String[] {"Club","Heart","Diamond","Spade"};
		for(int i = 0; i < total; i++){
			String suit = suits[i / (total/4)];//花色
			int value = 1 + i % 13;//牌號
			Card newCard = new Card(suit,value);
			cards.add(newCard);
		}
		Shuffle();
	}
	public void Show(){
		for(Card i: cards){
			i.Show();
		}
	}
}
