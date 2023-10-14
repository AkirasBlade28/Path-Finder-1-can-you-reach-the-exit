import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

public class Finder {
    
   public static boolean pathFinder(String maze) {
        // Your code here!!
        return depthFirstSearch(maze);
    }
    
    private static boolean depthFirstSearch(String maze) {
	    int mazeLength = maze.length();
	    int mazeWidth = maze.indexOf('\n');
	    Stack<Integer> stack = new Stack<>();
	    Set<Integer> visitedNodes = new HashSet<>();
	    stack.push(0);
	    while (!stack.isEmpty()) {
	        int currentNode = stack.peek();
	        int[] moves = {
	            currentNode - mazeWidth - 1,
	            currentNode + mazeWidth + 1,
	            currentNode - 1,
	            currentNode + 1
	        };
	        boolean hasPossibleMoves = false;
	        for (var move : moves) {
	            if (move >= 0 && move < mazeLength && maze.charAt(move) == '.' &&
	                    !visitedNodes.contains(move) && !stack.contains(move)) {
	                stack.push(move);
	                visitedNodes.add(move);
	                hasPossibleMoves = true;
	                break;
	            }
	        }
	        if (!hasPossibleMoves) {
	            visitedNodes.add(stack.pop());
	        }
	        if (visitedNodes.contains(mazeLength - 1)) {
	            return true;
	        }
	    }
	    return false;
	}
  
}