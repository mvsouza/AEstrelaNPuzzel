import java.util.LinkedList;
/**
 * A search algorithm for the N-Puzzle
 * @author meneguzzi
 *
 */
public class Solver {
	/**
	 * Uses a search algorithm to generate a solution to the N-Puzzle starting from state <code>s0</code> to 
	 * reach goal state <code>g</code>. If there is a solution, return an array of {@link String}s listing the moves, 
	 * if the solution is trivial (no moves), return an array with 1 <code>null</code> {@link String}, otherwise 
	 * (no solution), return <code>null</code>.
	 * return an array with . 
	 * @param s0 The initial state of the search problem
	 * @param g The goal state of the search problem
	 * @return a list of actions [a<sub>0</sub>, ..., a<sub>n</sub>] where each a<sub>i</sub> &in; {"up","down","left","right"}.
	 */
	public String []solve(int [][]s0, int [][]g) {
		LinkedList<String> aux = new LinkedList<String> (); 
		AEstrela<EstadoNPuzzle> aux2 = novaAEstrala(s0, g);
		LinkedList<EstadoNPuzzle> retorno = aux2.encontraSolucao();
		if(retorno == null)return null;
		if(retorno.size()==1&&retorno.get(0)==null){
			aux.add(null);
			return aux.toArray(new String[retorno.size()]);
		}
		//System.out.println(retorno.size());
		for(EstadoNPuzzle e : retorno){
			if(e!=null&&e.Movimento!=null&&e.Movimento!=""){
				aux.add(e.Movimento);
			}
		}
		//System.out.println(aux);
		//printGame(g);
		return aux.toArray(new String[aux.size()]);
	}
	
	/**
	 * Returns an AEstrela object with the given start state and goal and .
	 * @param s0
	 * @param g
	 * @return If the matrices have different sizes, it return 0.
	 */
	public AEstrela novaAEstrala(int [][]s0, int [][]g)
	{
		if(s0.length!=g.length)return null;
		return new AEstrela<EstadoNPuzzle>(new EstadoNPuzzle(s0,g.length,"",0,null),new EstadoNPuzzle(g,g.length,"",0,null));
	}
	/**
	 * Returns whether or not the specified problem is solvable.
	 * @param s0
	 * @param g
	 * @return
	 */
	public boolean isSolvable(int [][]s0, int [][]g) {
		return novaAEstrala(s0, g).isSolvable();
	}
	
	/**
	 * Returns the maximum height of the search tree (i.e. the longest move sequence considered during search).
	 * @param s0
	 * @param g
	 * @return
	 */
	public int maxTreeHeight(int [][]s0, int [][]g) {
		return novaAEstrala(s0, g).maxXpmT();
	}
	
	/**
	 * Returns the minimum number of moves to solve the specified problem, or -1 if the problem is unsolvable.
	 * @param s0
	 * @param g
	 * @return
	 */
	public int minMoves(int [][]s0, int [][]g) {
		String[] s = solve(s0,g);
		if(s==null)return -1;
		if(s.length==1 && s[0]==null)return 0;
		return s.length;
	}
}
