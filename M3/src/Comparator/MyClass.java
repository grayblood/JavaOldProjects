package Comparator;

public class MyClass implements Comparable<MyClass> {
	private String m_Nom;
	private String m_Cogmnom;
	private int m_Edat;

	public MyClass(String nombre, String apellido1, int Edat) {
		super();
		m_Nom = nombre;
		m_Cogmnom = apellido1;
		m_Edat = Edat;
	}
	
	@Override
	public int compareTo(MyClass a) {
	
	     /* 
	      * Sorting by last name. compareTo should return < 0 if this(keyword) 
	      * is supposed to be less than au, > 0 if this is supposed to be 
	      * greater than object au and 0 if they are supposed to be equal.
	      */
		
		// Por apellido
		/*
		  
		int last = this.m_Cogmnom.compareTo(a.getCogmnom()); 
	     return last == 0 ? this.m_Nom.compareTo(a.m_Nom) : last;
	     */
		
		//por nombre
		int last = this.m_Nom.compareTo(a.getNom());

	     return last == 0 ? this.m_Cogmnom.compareTo(a.getCogmnom()) : last;
	  }

	public String getNom() {
		return m_Nom;
	}

	public void setNom(String nom) {
		m_Nom = nom;
	}

	public String getCogmnom() {
		return m_Cogmnom;
	}

	public void setCogmnom(String cogmnom) {
		m_Cogmnom = cogmnom;
	}

	public int getEdat() {
		return m_Edat;
	}

	public void setEdat(int edat) {
		m_Edat = edat;
	}

	@Override
	public String toString() {
		return "MyClass [Nom=" + m_Nom + ", Cogmnom=" + m_Cogmnom + ", Edat=" + m_Edat + "]";
	}



}
