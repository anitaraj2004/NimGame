package Arrays;

import TurtleGraphics.KeyboardReader;

public class NimMethods 
{	
	public int FindSum(int[] boardlist)
	{
		int index=0, sum=0;
		for(int j=0; j<boardlist.length; j++)
		{
			sum=sum+boardlist[index];
			index++;
		}
		
		return sum;
	}
	
	public int[] StonesCalculation(int[] boardlist, int pilenum)
	{
		KeyboardReader reader = new KeyboardReader();
		int pilepick=0, stones=0;
				
		System.out.println("Which pile? ");
		pilepick=reader.readInt();
		
		while((pilepick>pilenum)||(pilepick<=0)||(boardlist[pilepick]==0))
		{
			System.out.println("Pick another pile. ");
			pilepick=reader.readInt();
		}
		
		System.out.println("How many stones? ");
		stones=reader.readInt();
		
		while((stones>boardlist[pilepick])||(stones>3)||(stones<=0))
		{
			System.out.println("Please pick a different number for stones. ");
			stones=reader.readInt();
		}
		
		boardlist[pilepick]=boardlist[pilepick]-stones;
		
		System.out.print("\nBoard: ");
		for(int i=1; i<boardlist.length; i++)
		{
			System.out.print(boardlist[i]);
			System.out.print(" ");
		}
		System.out.println(" ");
		
		return boardlist;
	}
	
	public void DrawPegs(int[] boardlist, int pilenum)
	{
		int temp1=pilenum, temp2;
		
		for(int i=0; i<=pilenum; i++)
		{
			for(int j=0; j<temp1; j++)
			{
				System.out.print("    |    ");
			}
			
			temp1--;
			
			temp2=(pilenum-1)-temp1;
			
			if(temp2>0)
			{
				for(int k=1; k<=temp2; k++)
				{
					System.out.print(" XXX|XXX ");
				}
			}
			
			System.out.println(" ");
		}
	}
	
	public void DrawPegs2(int[] boardlist, int pilenum)
	{
		int index=1, temp1=pilenum;
		
		for(int x=1; x<=pilenum; x++)
		{
			System.out.print("    |    ");
		}
		System.out.println(" ");
		
		for(int i=1; i<=pilenum; i++)
		{
			for(int j=1; j<=pilenum; j++)
			{
				if(boardlist[index]>=temp1)
				{
					System.out.print(" XXX|XXX ");
				}
				
				else if(boardlist[index]<temp1)
				{
					System.out.print("    |    ");
				}
				
				index++;
			}
			
			temp1--;
			
			index=1;
			
			System.out.println(" ");
		}
	}
}