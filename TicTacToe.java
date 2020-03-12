package java_codes;

import java.util.HashMap;
import java.util.Scanner;


class TicTacToe {
	static HashMap<Integer,Integer> map=new HashMap<>();
    public static void show(char[][] board)
    {
    	for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
				  System.out.print(board[i][j]);  //<<<<" ";
			System.out.println();  
		}
    	System.out.println();
    }
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		char[][] board={{' ','|',' ','|',' '},
				{'_','+','_','+','_'},
				{' ','|',' ','|',' '},
				{'_','+','_','+','_'},
				{' ','|',' ','|',' '}
		         };
		int rows=board.length;
		int cols=board[0].length;
		
        show(board);
        int move=0;
        int pos=-1;
        int cnt=0;
        while(true)
        {
        	if(win(board,move))
        		break;
        	if(move==0) {
        		  System.out.println("Enter player's position( 0-9 Only): ");
        	           pos=scan.nextInt(); 
        	           put(board,pos,'X');
        	}// denoted by 'X'
        	else if(move==1)
        		  {
        	  
        		      pos=((int)(Math.random()*100)%9+9)%9;
        		     if(map.containsKey(pos))
        		    	 continue;
        		      put(board,pos,'0');
        		    	  
        		  }
        	map.put(pos,1);
        	  
        		move=1-move;
        		cnt++;
        		show(board);
        		if(cnt==9)
        			break;
        }
        if(cnt==9)
        	  System.out.println(" MATCH DRAWN !! ");
        	  else if(move==0)
        		  System.out.println(" COMPUTER WINS ");
        	  else
        		  System.out.println(" PLAYER WINS ");
        		  
        		  
        
        
        }
	private static void put(char[][] board, int pos, char c) {
		   if(pos==0)
			  board[0][0]=c;
		else if(pos==1)
			board[0][2]=c;
		else if(pos==2)
			 board[0][4]=c;
		else if(pos==3)
			board[2][0]=c;
		else if(pos==4)
			 board[2][2]=c;
		else if(pos==5)
			  board[2][4]=c;
		else if(pos==6)
			board[4][0]=c;
		else if(pos==7)
			 board[4][2]=c;
		else
			board[4][4]=c;
	}
	private static boolean win(char[][] board,int move) {
		  if(move==0)
		  {
			  if(checkrow(board,0,'0') || checkrow(board,2,'0')||checkrow(board,4,'0') 
					  || checkdiagonal(board,'0'))
				    return true;
			  return false;
		  }
		  else {
			 
				  if(checkrow(board,0,'X')|| checkrow(board,2,'X') ||checkrow(board,4,'X') 
						  ||checkdiagonal(board,'X'))
			      return true;
			  
			  return false;
		  }
			  
	}
	private static boolean checkdiagonal(char[][] board, char c) {
		
			return (board[0][0]==c && board[2][2]==c && board[4][4]==c) || (board[4][0]==c && board[2][2]==c && board[0][4]==c);
		
	}
	private static boolean checkrow(char[][] board, int i, char c) {
		
			return (board[i][0]==c && board[i][2]==c && board[i][4]==c);
	
	}
	

}
