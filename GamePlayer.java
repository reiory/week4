import java.util.*;
import java.io.*;

class GamePlayer{
	private ArrayList<Card> handcard;
	private String playername;
	public GamePlayer(String name){
		handcard = new ArrayList<Card>();
		this.playername = name;
	}
	public void reName(String name){
		this.playername = name;
	}
	public int countPoint(){
		int ace = 0, sum = 0,acetry=0;
		for(Card c : handcard){
			if(c.cardRecall() == 1){
				ace ++;
			}
			else if(c.cardRecall() > 10){
				sum += 10;
			}
			else{
				sum += c.cardRecall();
			}
		}
		if(ace>0)	{
			int tec=sum;
			if((tec+11+ace-1)<=21)
				sum=tec+11+ace-1;
			else 
				sum=sum+ace;
			return sum;
		}
		return sum;
	}
	public void showCards(){
		for(Card c : handcard){
			c.Show();
		}
		showPoint();
	}
	public void showPoint()	{
		System.out.println("Now "+playername+" have "+countPoint()+" points.\r\n");
	}
	public boolean bustCheck()
	{
		int point = countPoint();
		if(point == 21)
			System.out.println("Black Jack!!!\r\n");
		else if(point>21){
			System.out.println("So sad, your point busted!\r\n");
			return false;
		}
		return true;
	}
	public String namerecall(){
		return this.playername;
	}
	public void Hit(Card temp){ //來
		handcard.add(temp);
	}
	public void removeAll(){
		handcard.clear();
	}
}
