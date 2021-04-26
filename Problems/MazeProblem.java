/* Java program to solve Rat in a Maze problem using
backtracking */

public class MazeProblem {
	final int N = 4;

	/* A utility function to check if x, y is valid
		index for N*N maze */
	boolean isSafe(int maze[][], int x, int y, int safeVal)
	{
		// if (x, y outside maze) return false
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == safeVal);
	}

	/* This function solves the Maze problem using
	Backtracking. It mainly uses solveMazeUtil()
	to solve the problem. It returns false if no
	path is possible, otherwise return true and
	prints the path in the form of 1s. Please note
	that there may be more than one solutions, this
	function prints one of the feasible solutions.*/
	boolean solveMaze(int maze[][])
	{
        //Starting points x,y, then ending point a,b
        boolean retRes = solveMazeUtil(maze, 0, 0,3,1);
		if (retRes == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		System.out.println("Exists? "+ retRes);
		return true;
	}

	/* A recursive utility function to solve Maze
	problem */
	boolean solveMazeUtil(int maze[][], int x, int y, int a,int b)
	{
		// if (x, y is goal) return true
		if (x == a && y == b) {
			return true;
		}

		// Check if maze[x][y] is valid
		if (isSafe(maze, x, y,1) == true) {
			// mark x, y as part of solution path


			/* Move forward in x direction */
			if (solveMazeUtil(maze, x + 1, y,a,b))
				return true;

			/* If moving in x direction doesn't give
			solution then Move down in y direction */
			if (solveMazeUtil(maze, x, y + 1,a,b))
				return true;

			/* If none of the above movements works then
			BACKTRACK: unmark x, y as part of solution
			path */
			
			return false;
		}

		return false;
	}

	public static void main(String args[])
	{
		MazeProblem rat = new MazeProblem();
		int maze[][] = { { 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } };
		rat.solveMaze(maze);
	}
}
// This code is contributed by Abhishek Shankhadhar
