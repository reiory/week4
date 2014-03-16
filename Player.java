import java.util.*;
import java.io.*;

public class Player extends GamePlayer{
	public Player()	{
		super("");
		System.out.println("Insert name:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		super.reName(name);
	}
	/* public playGame(){
		int opt=0;
		
	} */
}
