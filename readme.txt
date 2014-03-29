/**********************************************************************
 *  N-Puzzle readme.txt template
 **********************************************************************/


Name: Matheus Valiente Souza
Student ID: 092002047

lines to run the tests:
javac -Xlint -cp junit-4.11.jar *.java
java -cp junit-4.11.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore SolverTest

obs.: On windows the colons should be changed by a semicolons.
Hours to complete assignment (optional):
16h

/**********************************************************************
 *  Explain briefly how you implemented the datatype for states.
 **********************************************************************/
	In this assignment was expected to solve a N-puzzle, so I develop a 
"EstadoNPuzzle" class, that, as implied, it describes a state from the 
N-puzzle game. In it, the board was represented by a matrix of int. 
	In order to use on the A star generic class, named "AEstrela", the 
class needed to extend the "IEstado" interface. 
	
/**********************************************************************
 *  Explain briefly how you represented a search node
 *  (state + number of moves + previous search node).
 **********************************************************************/
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
 *  Explain briefly how you detected unsolvable puzzles.
 **********************************************************************/
	Fist of all, I detected if the puzzle was solvable by, consuming all 
states.Them a tried discover by using a formula.  

/**********************************************************************
 *  If you wanted to solve random 4-by-4 or 5-by-5 puzzles, which
 *  would you prefer:  more time (say, 2x as much), more memory
 *  (say 2x as much), a better priority queue (say, 2x as fast),
 *  or a better priority function (say, one on the order of improvement
 *  from Hamming to Manhattan)? Why?
 **********************************************************************/
	I would choose a better heuristic formula, because that reduce the 
number of states explored in the spanning tree, so reduces the memory 
consume and the length of states to be prioritise, thus reduce the time 
it may take to rum.
	It means that the priority function impact a better performance in 
the other 3 factors, consequently it is a bottleneck the implementation.

/**********************************************************************
 *  If you did the extra credit, describe your algorithm briefly and
 *  state the order of growth of the running time (in the worst case)
 *  for isSolvable().
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

/**********************************************************************
 *  Known bugs / limitations.
 **********************************************************************/



/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including staff, classmates, and 
 *  friends) and attribute them by name.
 **********************************************************************/





/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
	



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
