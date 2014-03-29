import java.util.LinkedList;
public class AEstrela<S extends IEstado>
{
	private S EstadoInicial;
	private S EstadoFinal;
	public AEstrela(S EstadoInicial, S EstadoFinal)
	{
		this.EstadoInicial=EstadoInicial;
		this.EstadoFinal=EstadoFinal;
	}
	
	/**
	 * Returns the most closed state from the goal stipulated by the heuristic implemented and remove from the given list.
	 * @param estados List of states that the return state need to be peeked.
	 * @return State removed from the list.
	 */
	public S peekEstadoMaisProximo(LinkedList<S> estados)
	{	
		int aux = 2147483647;
		S atual = null;
		for(S i : estados)
		{
			int auxiliar = i.getPercorrido()+i.CalcEuristica(EstadoFinal.getEstado());
			if(auxiliar<aux)
			{
				atual=i;
				aux=auxiliar;
			}
		}
		if(atual!=null)estados.remove(atual);
		return atual;
	}
	
	/**
	 * Returns all the states from the found solution.
	 * @return If there`s no solution it returns null, if the first state is 
	 * the solution it returns a list containing one null, otherwise it should 
	 * return all the states from the found solution.
	 */
	public LinkedList<S> encontraSolucao(){
		if(!isSolvable())return null;
		if(EstadoInicial.equals(EstadoFinal))
		{
			LinkedList<S> s = new LinkedList<S>();
			s.add(null);
			return s;
		}
		LinkedList<S> passados = new LinkedList<S>();
		LinkedList<S> naoPassados = new LinkedList<S>();  
		LinkedList<S> navegados = new LinkedList<S>();  
		naoPassados.add(EstadoInicial);
		while (naoPassados.size()>0){
			S current = peekEstadoMaisProximo(naoPassados);
			//System.out.println(current.getPercorrido()+current.CalcEuristica(EstadoFinal.getEstado()));
			//current.printEstado();
			if (current.equals(EstadoFinal)) return reconstruirCaminho(current);
			//passados.add(current);
			LinkedList<S> visinhos = current.Visinhos();
			for (S estado : visinhos){
				if (getEstado(estado,passados)!=null) {
					continue;
				}
				IEstado aux = getEstado(estado,naoPassados);
				if (aux!=null){ 
					if(aux.getPercorrido()+aux.CalcEuristica(EstadoFinal.getEstado())<current.getPercorrido()+current.CalcEuristica(EstadoFinal.getEstado())){
						naoPassados.remove(aux);
						naoPassados.add(estado);
					}
				}
				else{
					naoPassados.add(estado);
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns the highest value of three height of the explored three created 
	 * until the algorithm to find the solution.
	 * @return 
	 */
	public int maxXpmT(){
		if(!isSolvable())return -1;
		if(EstadoInicial.equals(EstadoFinal)) return 1;
		LinkedList<S> passados = new LinkedList<S>();
		LinkedList<S> naoPassados = new LinkedList<S>();  
		naoPassados.add(EstadoInicial);
		while (naoPassados.size()>0){
			S current = peekEstadoMaisProximo(naoPassados);
			if (current.equals(EstadoFinal)) break;
			LinkedList<S> visinhos = current.Visinhos();
			for (S estado : visinhos){
				if (getEstado(estado,passados)!=null) continue;
				IEstado aux = getEstado(estado,naoPassados);
				if (aux!=null){ 
					if(aux.getPercorrido()+aux.CalcEuristica(EstadoFinal.getEstado())<current.getPercorrido()+current.CalcEuristica(EstadoFinal.getEstado())){
						naoPassados.remove(aux);
						naoPassados.add(estado);
					}
				}
				else{
					naoPassados.add(estado);
				}
			}
		}
		int retorno = 0;
		for (S estado : passados) if(estado.getPercorrido()>retorno)retorno=estado.getPercorrido();
		for (S estado : naoPassados) if(estado.getPercorrido()>retorno)retorno=estado.getPercorrido();
		return retorno+1;
	}
	/**
	 * Returns the recreated path of the searched states that active the final state.
	 * @return 
	 */
	public LinkedList<S> reconstruirCaminho(S current)
	{
		if (current!=null&&current.getEstadoAnterior()!=null){
			LinkedList<S> l = reconstruirCaminho((S)current.getEstadoAnterior()); 
			l.add(current);
			return l;
		}
		else{
			LinkedList<S> l = new LinkedList<S>();
			l.add(current);
			return l;		
		}
	}
	/**
	 * Returns the searched state with a identical game board.
	 * @return The state with same game board, but if doesn't contains one, it should return null.
	 */
	public S getEstado(S estado,LinkedList<S> lista)
	{
		for(S e : lista)
			if(e.equals(estado))return e;
		return null;
	}
	/**
	 * Returns if the current state cam reach the goal.
	 * @return 
	 */
	public boolean isSolvable() {
		return EstadoInicial.isSolvable(EstadoFinal);
	}
}