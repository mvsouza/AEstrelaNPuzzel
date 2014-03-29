import java.util.LinkedList;
public interface IEstado<T>{

	/**
	 * Returns the puzzle board from this state.
	 * @return
	 */
	public T getEstado();
	
	/**
	 * Returns the state which this state was generated from.
	 * @return
	 */
	public IEstado<T> getEstadoAnterior();
	
	/**
	 * Returns the quantity of moves to arrive to this state.
	 * @return
	 */
	public int getPercorrido();
	
	/**
	 * Returns the value calculated to arrive to goal.
	 * @param goal
	 * @return
	 */
	public int CalcEuristica(T goal);
	
	/**
	 * Returns if the tiles on the state board "e" is on the same arrangement of this state.
	 * @param e
	 * @return
	 */
	public boolean equals(IEstado<T> e);
	
	/**
	 * Returns a linked list of all the possible states that cam be derived from this state by moving the empty "tile".
	 * @return
	 */
	public LinkedList<IEstado<T>> Visinhos();
	
	/**
	 * Returns if this board cam arrive to the following state by "moving" the empty space.
	 * @param EstadoFinal
	 * @return
	 */
	public boolean isSolvable(IEstado<T> EstadoFinal);
	
	/**
	 * Print on the console the board.
	 * @return
	 */
	public void printEstado();
}