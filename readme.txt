/**********************************************************************
 *  N-Puzzle readme.txt template
 **********************************************************************/

Name: Matheus Valiente Souza

lines to run the tests:
javac -Xlint -cp junit-4.11.jar *.java
java -cp junit-4.11.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore SolverTest

obs.: On windows the colons should be changed by a semicolons.

/**********************************************************************
 *  Datatype for states.
 **********************************************************************/
	In this assignment was expected to solve a N-puzzle, so I develop a 
"EstadoNPuzzle" class, that, as implied, it describes a state from the 
N-puzzle game. In it, the board was represented by a matrix of int. 
	In order to use on the A star generic class, named "AEstrela", the 
class needed to extend the "IEstado" interface. 
	
	The representation for a search node chosen is defined by an Interface
(IEstado), that specifies all required methods to run an generic A * search 
algorithm. Therefore this implementation solves a problem using A star search, 
despite the problem being solved.
	The "IEstado" interface obligates the class, that is being inherent it, 
to have a coupled methods, that change may change by problem or way to 
implement. That scope include :
	-writing the state on the console;
	-if two states have the same information state value, in this case the
	puzzle board;
	-the number of states need to reach a created node from the start state;
	-A value from pessimist Heuristic to reach the goal from the current 
	state;
	-All possible states that cam be derived from the current;
	-If the goal is reachable;
	After the interface and the ready, it was a simple job of implement the 
documented methods.

/**********************************************************************
 *  IsSolvable Implementation
 **********************************************************************/
	The formula count the number the "inversions" in the n-puzzle, them
verify three conditions:
	"-If the grid width is odd, then the number of inversions in a solvable 
	situation is even.
	-If the grid width is even, and the blank is on an even row counting 
	from the bottom (second-last, fourth-last etc), then the number of 
	inversions in a solvable situation is odd.
	-If the grid width is even, and the blank is on an odd row counting 
	from the bottom (last, third-last, fifth-last etc) then the number 
	of inversions in a solvable situation is even."
	
	This formula was inspired on the explanation written by  Mark Ryan,
and cam be read on:
http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html

	It may be better verified its optimality.
/**********************************************************************
 *  Known bugs / limitations.
 **********************************************************************/
