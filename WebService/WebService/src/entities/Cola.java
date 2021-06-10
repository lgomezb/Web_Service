package entities;

import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.locks.Condition;

import persistence.DaoAlta;

public class Cola {
	public static int max_size = 10;
	Condition condition;
	
	public static Vector<Alta> v = new Vector<>();
	
	public Cola(Condition condition) {
		this.condition = condition;
	}
	
	public static Boolean saveAlta(Alta alta) {
		if (v.add(alta)) {
			return true;
		} else {
			return false;
		}
	}

	public static void addAlta() {
        DaoAlta daoAlta = new DaoAlta();
        try {
			daoAlta.add(v.get(0));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        
        v.remove(0); 
		
	}
	
	
}
