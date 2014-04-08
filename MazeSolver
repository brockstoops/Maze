//Brock Stoops
//COP 3503 
//Assignment 7 maze solver




import java.util.LinkedList;
import java.util.Queue;

public class Maze{
	
	//Calls the breadth first search method to find path
	public static void solve(char[][] maze){
		bfs(1,1,maze);
	}
	
	//Breadth first search method
	public static void bfs(int x, int y, char [][] maze){
		//Declare visited array and queue
		Queue<Maze.cell> q = new LinkedList<Maze.cell>();
		boolean [][] visited = new boolean[maze.length][maze[0].length];
		
		//create a starting cell and add to queue
		Maze.cell start = new Maze.cell(x,y);
		q.add(start);
		
		//Set starting point to true and ending boolean to false
		visited[x][y] = true;
		boolean e = false;
		
		//Stay in while loop while q is not empty and havent found exit yet
		while( !q.isEmpty() && !e) {
			//Remove cell and take values
			start =	q.remove();
			int a = start.x;
			int b = start.y;
			//If cell was ending cell set to true so can break out of while
			if(maze[a][b] == 'e')
				e = true;
			
			//Try up add if possible move
			if(maze[a-1][b] != '#' && !visited[a-1][b]){
				visited[a-1][b] = true;
				Maze.cell cell = new Maze.cell(a-1, b, start);
				q.add(cell);
			}
			//Try left, add to queue if possible move
			if(maze[a][b-1] != '#' && !visited[a][b-1]){
				visited[a][b-1] = true;
				Maze.cell cell = new Maze.cell(a, b-1, start);
				q.add(cell);
			}
			//Try down, add to queue if possible move
			if(maze[a+1][b] != '#' && !visited[a+1][b]){
				visited[a+1][b] = true;
				Maze.cell cell = new Maze.cell(a+1, b, start);
				q.add(cell);
			}
			//Try right, add to queue if possible move
			if(maze[a][b+1] != '#' && !visited[a][b+1]){
				visited[a][b+1] = true;
				Maze.cell cell = new Maze.cell(a, b+1, start);
				q.add(cell);
			}
		}

		//Loop through the linked list that has solution and change path to periods
		while(start.parent != null){
			if(maze[start.x][start.y] != 'e')
				maze[start.x][start.y]= '.';
			start = start.parent;
		}
	}
	
	//Cell class that uses linked list and keeps track of x and y components of maze
	public static class cell{
		public int x;
		public int y;
		public cell parent;
		
		public cell(int x, int y){
			this.x = x;
			this.y = y;
			this.parent = null;
		}
		
		public cell(int x, int y, cell c){
			this.x = x;
			this.y = y;
			this.parent = c;
			
		}
	}
	//Difficulty method
	public static double difficultyRating(){
		return 2;
	}
	//Hours spent method
	public static double hoursSpent(){
		return 3;
	}
}
