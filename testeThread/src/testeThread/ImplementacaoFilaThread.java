package testeThread;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{

	public static ConcurrentLinkedQueue<ObjetoFilaThread> filaThread = new ConcurrentLinkedQueue<ObjetoFilaThread>();
	public static HashMap<String, String> listaRelatorio = new HashMap<String, String>();
	
	public static void add(ObjetoFilaThread obj) {
		filaThread.add(obj);
		listaRelatorio.put(obj.getNome(), obj.getTituloRelatorio());
	}
	
	public static void listaRelatorio() {
		System.out.println("");
		System.out.println("------- Lista Relatorios ----------");
		listaRelatorio.forEach((key, value) -> {
			System.out.println("Nome:" + key );
			System.out.println("Titulo do relatorio: " + value );
			System.out.println("-");
		});
		System.out.println("");
	}
	
	@Override
	public void run() {
		System.out.println("Rodando fila thread");
		
		while(true) {
			Iterator iterator = filaThread.iterator();
			synchronized (iterator) {
				while( iterator.hasNext() ) {
					ObjetoFilaThread processo = (ObjetoFilaThread) iterator.next();
					
					System.out.println("___________________");
					System.out.println("Gerando relatorio de " + processo.getNome() + " sobre " + processo.getTituloRelatorio() );
					iterator.remove();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
