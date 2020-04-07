package it.polito.tdp.anagrammi.DB;

public class TestAnagrammaDAO {

	public static void main(String[] args) {
		AnagrammaDAO dao = new AnagrammaDAO();
	
		if (!dao.isCorret("76890"))
			System.out.println("No esiste");
		else
		System.out.println("Si esiste");
		
		

	}

}
