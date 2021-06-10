package entities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Hilo implements Runnable{
	
	public Hilo() {
		
	}
	
	//Función que pone a correr el hilo
	public void run() {
			if(!Cola.v.isEmpty()) {
				System.out.println("subiendo un archivo..." + "// " + Thread.currentThread());
				try {
					write();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				Cola.addAlta();
			}
			
		}
	
	 //Función para escribir un archivo con los objetos de la cola
	public void write() throws IOException {
		File file = new File("info_in_vector.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		try 
		{
			oos.writeObject(Cola.v);
			System.out.println("Objeto introducido");
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
		System.out.println("Cerrando programa");
	}

	}

//}


//(new Runnable() {
