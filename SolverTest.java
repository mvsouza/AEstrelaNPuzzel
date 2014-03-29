import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author meneguzzi
 *
 */
public class SolverTest {
	
	Solver solver;
	
	final Problem trivialProblem = new Problem( 
			new int [][] {{0,1,2},{3,4,5},{6,7,8}},
			new int [][] {{0,1,2},{3,4,5},{6,7,8}});
	final Problem easyProblem = new Problem( 
			new int [][] {{7,2,4},{5,0,6},{8,3,1}},
			new int [][] {{7,2,4},{5,6,0},{8,3,1}});
	final Problem mediumProblem = new Problem( 
			new int [][] {{2,5,6},{0,1,3},{7,4,8}},
			new int [][] {{1,2,3},{4,5,6},{7,8,0}});
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solver = new Solver();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	private String []invokeSearch(Problem problem) {
		return solver.solve(problem.s0, problem.g);
	}
	
	private boolean invokeSolvable(Problem problem) {
		return solver.isSolvable(problem.s0, problem.g);
	}
	
	private int invokeMaxTreeHeight(Problem problem) {
		return solver.maxTreeHeight(problem.s0, problem.g);
	}
	
	private int invokeMinMoves(Problem problem) {
		return solver.minMoves(problem.s0, problem.g);
	}

	/**
	 * Test method for {@link Solver#solve(int[][], int[][])}.
	 */
	@Test
	public final void testSearchTrivial() {
		String res[] = invokeSearch(trivialProblem);
		assertEquals(1,res.length);
		assertTrue(res[0] == null);
	}
	
	/**
	 * Test method for {@link Solver#solve(int[][], int[][])}.
	 */
	@Test
	public final void testSearchEasy() {
		String res[] = invokeSearch(easyProblem);
		assertEquals(1,res.length);
		assertEquals("right",res[0]);
	}
	
	/**
	 * Test method for {@link Solver#solve(int[][], int[][])}.
	 */
	@Test
	public final void testSearchMedium() {
		String res[] = invokeSearch(mediumProblem);
		assertEquals(15,res.length);
		assertEquals("right",res[0]);
		assertEquals("right",res[1]);
		assertEquals("up",res[2]);
		assertEquals("left",res[3]);
		assertEquals("down",res[4]);
		assertEquals("down",res[5]);
		assertEquals("left",res[10]);
		assertEquals("down",res[14]);
	}

	/**
	 * Test method for {@link Solver#isSolvable(int[][], int[][])}.
	 */
	@Test
	public final void testIsSolvableTrivial() {
		boolean res = invokeSolvable(trivialProblem);
		assertTrue(res);
	}
	
	/**
	 * Test method for {@link Solver#isSolvable(int[][], int[][])}.
	 */
	@Test
	public final void testIsSolvableEasy() {
		boolean res = invokeSolvable(easyProblem);
		assertTrue(res);
	}
	
	/**
	 * Test method for {@link Solver#isSolvable(int[][], int[][])}.
	 */
	@Test
	public final void testIsSolvableMedium() {
		boolean res = invokeSolvable(mediumProblem);
		assertTrue(res);
	}

	/**
	 * Test method for {@link Solver#maxTreeHeight(int[][], int[][])}.
	 */
	@Test
	public final void testMaxTreeHeightTrivial() {
		int res = invokeMaxTreeHeight(trivialProblem);
		assertEquals(1,res);
	}
	
	/**
	 * Test method for {@link Solver#maxTreeHeight(int[][], int[][])}.
	 */
	@Test
	public final void testMaxTreeHeightEasy() {
		int res = invokeMaxTreeHeight(easyProblem);
		assertEquals(2,res);
	}
	
	/**
	 * Test method for {@link Solver#maxTreeHeight(int[][], int[][])}.
	 */
	@Test
	public final void testMaxTreeHeightMedium() {
		int res = invokeMaxTreeHeight(mediumProblem);
		assertEquals(16,res);
	}
	
	/**
	 * Test method for {@link Solver#minMoves(int[][], int[][])}.
	 */
	@Test
	public final void testMinMovesTrivial() {
		int res = invokeMinMoves(trivialProblem);
		assertEquals(0,res);
	}
	
	/**
	 * Test method for {@link Solver#minMoves(int[][], int[][])}.
	 */
	@Test
	public final void testMinMovesEasy() {
		int res = invokeMinMoves(easyProblem);
		assertEquals(1,res);
	}
	
	/**
	 * Test method for {@link Solver#minMoves(int[][], int[][])}.
	 */
	@Test
	public final void testMinMovesMedium() {
		int res = invokeMinMoves(mediumProblem);
		assertEquals(15,res);
	}

	private class Problem {
		int [][]s0;
		int [][]g;
		Problem(int [][]s0, int g[][]) {
			this.s0 = s0;
			this.g = g;
		}
	}
}
