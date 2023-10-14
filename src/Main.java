import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class Main {
	// copy maze in new String with added path
	public static String drawPathFromStartToFinish = new String();
	
	public static void main(String[] args) {
		
		String maze = mazes();			               
		drawPathFromStartToFinish = maze;
		// input maze
		System.out.println("Maze:\n\n" + maze+"\n");
		// bfs
		System.out.println("Maze solution is: "+pathFinder(maze)+"!\n");
		// output maze 
		System.out.println("Shortest path from start to finish\n\n"+drawPathFromStartToFinish);
		// dfs
		System.out.println("DFS solution:" + Finder.pathFinder(maze));
		
	}
	
	static String mazes() {
		// tests - can modify each (W - wall) maze to assert true or false as result
		// String m6 is the best for testing
		// Start is at String.charAt(0)
		// Finish - String.charAt(String.length()-1);
		final String 
		
		m1 = 
		
		".W.\n"+
		".W.\n"+
		"...",
		        
		 m2 = 
		 
		 ".W.\n"+
		 ".W.\n"+
		 "W..",
		   
		 m3 = 
		 
		 "......\n"+
		 "......\n"+
		 "......\n"+
		 "......\n"+
		 "......\n"+
		 "......",
		   
		  m4 = 
		     
		  "......\n"+
		  "......\n"+
		  "......\n"+
		  "......\n"+
		  ".....W\n"+
		  "....W.",
		   
	      m5 =  
	        
	      "..W.WW.......\n"
	    + "......WW.W...\n"
		+ "WW..WW.......\n"
		+ "W.....W...W.W\n"
		+ "...WWW..WW..W\n"
		+ ".....W.....W.\n"
		+ "W....W....WW.\n"
		+ "....W..WW...W\n"
		+ "W.W.W.WW..W..\n"
		+ "......WWW.W..\n"
		+ "W.WW.........\n"
		+ "W.W.W........\n"
		+ "....WWW..W...\n"
		+ "......WW.W..\n"
		+ "WW..WW.......\n"
		+ "W.....W...W.W\n"
		+ "...WWW..WW..W\n"
		+ ".....W.....W.\n"
		+ "W.........WW.\n"
		+ "....W..W....W\n"
		+ "WWWWWWWW.WW..\n"
		+ "......WWWWWWW\n"
		+ "W.WW.........\n"
		+ "W.W.W........\n"
		+ "....WWW..W...",
			
	   m6 = 
		// returns true
	   ".WWW..WW.W.........W..W.W....WW..W.......WW..W..W.\n"+
	   "....W..WW.W...W.WW....WWW...........WW..W.WW.....W\n"+
	   ".....W..W...W.......W..WW..W......W.........W.W..W\n"+
	   "W..W..W.W.W..W.W.W...W...W...W.......W....W....W..\n"+
	   ".W...W....W.W...WWW.WWW..W....W..W...WW......W...W\n"+
	   "W.........W..W.......W..............W....WWW.W....\n"+
	   "....W......W...WW........WWW...W.W.WW..W.......W..\n"+
	   ".W..W....W............W.W..WWWW.WW..WWW...WW......\n"+
	   "......WWW........WW..W...WWW.WW...........WW.W..WW\n"+
	   ".WW......W....W...WWW...........W.....W...W....W.W\n"+
	   "....WW...........W.........W...W..................\n"+
	   ".W..W....W......W...W.W.......WW...W..............\n"+
	   "WWW........WW..W...W...WW.W..WW...WW.WWW...W.WWW..\n"+
	   "...W...........W..W.W.W..W..W.W.WW..W.W...........\n"+
	   "...........WW..W.WW.....W.....W........W.W..W.W...\n"+
	   ".W..W.W..................W...W.........WWWW....W..\n"+
	   "....W....W........W........W.W...W.W..W.W....WW...\n"+
	   ".W.......W......W.......W.....W....W.W.....WW.....\n"+
	   "WW.....W...W........W.W........WWWWW....W.W..W.W..\n"+
	   "...WWWW........W.WW.........W........W.W.....W.W.W\n"+
	   ".W..W..W....W.W........W........W.........W.......\n"+
	   "WW..WW......W....W....W.W...........W.....W.......\n"+
	   "..W..W...WWW...W.W.........W..W..W...WW.W.......W.\n"+
	   "WW.W.......WW..WW.W..W....WW............W....W....\n"+
	   "W.W...W.WW..WW.W....WW........WWW....WWW.W....W...\n"+
	   ".......W....W.....W.W.W..W.W.........W.....W....W.\n"+
	   "..WW...W.........WW....WW......W....W.......W.WWW.\n"+
	   "WW.WW..W.W.WW....WW.W..WW......W.W..........W.W...\n"+
	   "W..W.........W..W.........W....W......W......W....\n"+
	   "....W..WW.W...W.W.W....W.......W.W...W..WW....WW..\n"+
	   "......WW.........W....WW....W..W..WWW.W....W..WW..\n"+
	   "W.....W.W..WWW.W...WW....W...W.........WW..W....W.\n"+
	   "............W...W....W...W........W....WW...W.W...\n"+
	   "............W...W.....W...W..W.W....W..WWWW......W\n"+
	   "..W..W...W..............W.W...W......W...W.......W\n"+
	   "....W.W...W..W..W...W..W....W.W...........W..W.W.W\n"+
	   ".............W...W....W....W.....W..W.......W.....\n"+
	   "...WW.W..W....W....W........W.WWW..........W....WW\n"+
	   "....WW..W................W..W..W.WW.WW..W....WWWWW\n"+
	   ".....W.W......W..WW...W..WW...W.....W.W.....WW.W..\n"+
	   "WW..WW.W....WW....W..W...W...WW....W.WW....W......\n"+
	   "W..........W..WWWW..W..WW.WWW..W.....W..W...W...W.\n"+
	   "..W................WW..WW.....W.......WW..WW...W..\n"+
	   "W..W..W....W...WW.W......WWW.W.WWW.....WW...W..W.W\n"+
	   ".W...W.W.WWW...W.......WW........WW...W.W...W...WW\n"+
	   "W..W.....W...W...W......W.WW...W..W...............\n"+
	   "........W...W..WWW.WW.W.WW........W..W....WWW.W..W\n"+
	   ".......W.WW..W........W..W....W....W.W..WW........\n"+
	   "..W.........WWWW...WW...W.W.W.W.WW..W....W..W.W...\n"+
	   ".....W.....W.....W.W.W.....WW...........WWWW...WW.";
		
		return m6;
	}
	
	// boolean functions for CodeWars specifications
	static boolean pathFinder(String maze) {
		return bfs(maze);
	}
	
	/*
	READ ME: This is 'Path Finder #2: shortest path' in general
	I did it as a drill where I draw the shortest path, 
	rather than returning integer value of the shortest (length) path */
	
	// returns true if maze has finish + draws path (my added drill)
	static boolean bfs(String maze) {
		int mazeLength = maze.length();
	    int mazeWidth = maze.indexOf('\n');
	    Queue<Integer> que = new ArrayDeque<>(mazeLength);
	    Set<Integer> visitedNode = new HashSet<>();
	    Map<Integer, Integer> parentMap = new HashMap<>(); // added parentMap

	    que.add(0);
	    visitedNode.add(0);
	    parentMap.put(0, -1); // set the parent of the starting node to -1

	    while(!que.isEmpty()) {
	        int currentNode = que.poll();
	        int[] moves = {
	            currentNode - mazeWidth - 1,
	            currentNode + mazeWidth + 1,
	            currentNode - 1,
	            currentNode + 1
	        };
	        for (var move : moves) {
	            if (move >= 0 && move < mazeLength && maze.charAt(move) == '.' && !visitedNode.contains(move)) {
	                que.add(move);
	                visitedNode.add(move);
	                parentMap.put(move, currentNode); // add the parent of the current node to the parentMap
	            }
	        }
	        if(que.contains(mazeLength-1)) {
	            // if the finish node is found, backtrack to find the path
	            List<Integer> path = new LinkedList<>();
	            int node = mazeLength - 1;
	            path.add(node);
	            while(parentMap.get(node) != -1) {
	                node = parentMap.get(node);
	                path.add(node);
	            }
	            Collections.reverse(path);
	            for(int i : path) {
	            	drawPathFromStartToFinish = replaceCharAt(drawPathFromStartToFinish, i, '@');
	            }
	            return true;
	        }       
	    }
	    return false;
	}
	// visualize path 
	// by changing symbol '.' for an empty spot with different one (example: '$') for traversed path
	static String replaceCharAt(String maze, int index, char replace) {
	    char[] chars = maze.toCharArray();
	    chars[index] = replace;
	    return new String(chars);
	}
	
}
