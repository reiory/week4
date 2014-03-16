import java.util.*;
import java.io.*;

public class Black_Jack{
	public static void main(String[] arg) {
		int brands = 1,opt=0;
		Cards C =new Cards(brands);
		while(true){
			System.out.print("Black Jack Game!!!\r\n1)Start Game 2)Quit Game : ");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			if(option == 2)
				break;
			Dealer dealer = new Dealer();
			Player player = new Player();//可增加玩家人數
			for(int i=0;i<2;i++){//new 2cards
					player.Hit(C.draw());
					dealer.Hit(C.draw());
			}
			while(true){
				player.showCards();
				System.out.println("Now please choose what you want to do:");
				System.out.println("1)Hit 2)stay :");
				opt = scanner.nextInt();
				if(opt == 1){
					player.Hit(C.draw());
				}
				else if(opt == 2)
					break;
				if(player.bustCheck() == false)
					break;
			}
			while(dealer.countPoint()<17){
				dealer.showCards();
				System.out.println("");
				dealer.Hit(C.draw());	
			}
			dealer.showCards();
			
			if(player.bustCheck()==false)
				System.out.println("Dealer win, you lost!\r\n");
			else if(dealer.bustCheck() == false)
				System.out.println("You win, dealer lost!\r\n");
			else if(dealer.countPoint() >= player.countPoint() )
				System.out.println("Dealer win, you lost!\r\n");
			else 
				System.out.println("You win, dealer lost!\r\n");
			player.removeAll();
			dealer.removeAll();
		} 
	}
}
