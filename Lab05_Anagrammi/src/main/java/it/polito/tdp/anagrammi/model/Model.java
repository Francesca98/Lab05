package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DB.AnagrammaDAO;

public class Model {
	List<String> soluzione= new LinkedList<>();
	AnagrammaDAO adao = new AnagrammaDAO();
	
	public List<String> anagrammi(List<Character> caratteri) //RITORNA LA LISTA DI SOLUZIONI
	{
		ricorsiva("",0,caratteri);
		
		return this.soluzione;
	}
	
	private void ricorsiva(String parola, int intervallo, List<Character> list )
	{
	   if(list.size()==0)
	   {
		   soluzione.add(parola);
		   return;
	   }
	   
	   for(Character c : list)
	   {
		   String tentativo =parola+c ;
	     List<Character> rimanenti = new LinkedList<>(list);
	     rimanenti.remove(c);
	     ricorsiva(tentativo,intervallo+1, rimanenti);
	   }
	}

	public boolean isCorret(String string)
	{
		return this.adao.isCorret(string);
	}
}
