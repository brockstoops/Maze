//Brock Stoops
//COP3503
//Assignment 6: Maze creation

import java.util.*;

public class Maze {

	public static char [][] create(int width, int height){
		return Create(width, height);
	}
	
	private static char [][] Create(int width, int height){
		
		//Set up 2D array
		int x = 2*width + 1;
		int y = 2*height + 1;
		int z = width*(2*height - 1);
		int count = 0;
		Random r = new Random();
		
		char [][] maze = new char[x][y];
		boolean [] visited = new boolean[z];
		//Set a couple wall values to true 
		//Had to set up array with extra values to calculate walls easier
		for(int i = width - 1; i < visited.length; i +=(2*width))
			visited[i] = true;
		//Set up disjoint set array to make sure you always join to sets that are disjoint
		int [] sets = new int[width*height];
		for(int i = 0; i < sets.length; i++){
			sets[i] = i;
		}
		//Fill up maze
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				if(j == 0 || i == 0 ){
					maze[i][j] = '#';
				}
				else if(i % 2 == 0 && j % 2 == 0 ){
					maze[i][j] = '#';
				}
				else if(i % 2 == 0  || j % 2 == 0){
					maze[i][j] = '#';
				}
				else
					maze[i][j] = ' ';
			}
		}
		maze[1][1] = 's';
		maze[x-2][y-2] = 'e';
		
		//While loop that follows assignment format
		//Runs minimum amount of times needed to join all sets
		while(count != width*height-1){
			//Pick random wall
			int w = r.nextInt(z);
			//Do no visit duplicate walls
			if(visited[w] == true)
				continue;
			visited[w] = true;
			int a = w / width;
			int b = w % width;
			int c, m;
			if(a % 2 == 1){
				c = width;
				m = 2*(b+1) - 1;
			}
			else {
				c = 1;
				m = 2*(b+1);
			}
			int d = (a/2)*width + b;
			//Do not let wall of non disjoint sets to be taken down
			if(findset(sets[d+c], sets) == findset(sets[d],sets))
				continue;
			int n = a+1;
			//Delete wall
			maze[m][n] = ' ';
			
			//Union sets
			sets = union(d, findset(sets[d+c], sets), sets);
			count++;
		}
		
		return maze;
	}
	
	//Union function to join 2 sets together
	public static int[] union(int a, int b, int[] sets){
		sets[b] = findset(a, sets);
		return sets;
	}
	
	//Find set function to find the parent of the set
	public static int findset(int a, int[] sets){
		if(sets[a] == a)
			return a;
		else
			return findset(sets[a], sets);
	}
	
	//Difficulty method
	public static double difficultyRating(){
		return 2.5;
	}
	
	//Hours spent method
	public static double hoursSpent(){
		return 4;
	}
	
}
