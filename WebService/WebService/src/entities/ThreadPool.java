package entities;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	// Crear un metodo que cada vez que llegue un JSON nuevo se cree un hilo y lo
	// suba desde la cola
	// Crear un monitor y pasarselo por parametro a threadpool y cola
	ExecutorService scheduler;
	ScheduledExecutorService scheduler2;
	int tamano = Cola.v.size();

	public void start() {
		scheduler2 = Executors.newScheduledThreadPool(1);
		scheduler2.scheduleAtFixedRate(new Runnable() {
			@Override

			public void run() {

				scheduler = Executors.newFixedThreadPool(10);
				for (int i = 0; i < tamano; i++) {
					Runnable tarea = new Hilo();
					scheduler.execute(tarea);

				}
			}
		}, 30, 30, TimeUnit.SECONDS);
	}

	public void stop() {
		if(tamano > 0) {
			start();
		}
		scheduler.shutdown();
	}

	public ThreadPool() {

	}
}
