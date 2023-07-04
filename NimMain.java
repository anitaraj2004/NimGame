package Arrays;

import TurtleGraphics.KeyboardReader;

public class NimMain 
{

	public static void main(String[] args) 
	{		
		KeyboardReader reader = new KeyboardReader();
		NimMethods object = new NimMethods();
		
		String player1, player2, loser="";
		int pilenum=0, sum=0, counter=0;
		
		System.out.print("Name for player #1: ");
		player1=reader.readLine();
		
		System.out.print("Name for player #2: ");
		player2=reader.readLine();
		
		System.out.print("How many piles? ");
		pilenum=reader.readInt();
		
		while(pilenum<=0)
		{
			System.out.println("Please pick a different number for piles. ");
			pilenum=reader.readInt();
		}
		
		System.out.println(" ");
		
		if(pilenum>=1)
		{
			int[] boardlist = new int [pilenum+1];
			
			for(int index=0; index<=(pilenum); index++)
			{
				boardlist[index]=index;
			}
			System.out.print("Board: ");
			
			for(int i=1; i<boardlist.length; i++)
			{
				System.out.print(boardlist[i]);
				System.out.print(" ");
			}
			System.out.println(" ");
			
			object.DrawPegs2(boardlist, pilenum);
			
			sum=object.FindSum(boardlist);
			
			while(sum>0)
			{
				if(sum>0)
				{
					if(counter%2==0)
					{
						System.out.println(player1);
						boardlist=object.StonesCalculation(boardlist, pilenum);
						sum=object.FindSum(boardlist);
						object.DrawPegs2(boardlist, pilenum);
						counter++;
					}
					
					if(sum<=0)
					{
						loser=player1;
						break;
					}
				}
				
				if(sum>0)
				{
					if(counter%2!=0)
					{
						System.out.println(player2);
						boardlist=object.StonesCalculation(boardlist, pilenum);
						sum=object.FindSum(boardlist);
						object.DrawPegs2(boardlist, pilenum);
						counter++;
					}
					
					if(sum<=0)
					{
						loser=player2;
						break;
					}
				}
			}
			
			System.out.println(loser+" is the loser!");
		}
	}
}