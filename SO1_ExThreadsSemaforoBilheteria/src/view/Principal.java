package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {
	
	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore mutex = new Semaphore(permissao);
		
		for (int threadId = 0 ; threadId < 10 ; threadId++) {

			ThreadController tCont = new ThreadController(threadId, permissao, mutex);
			tCont.start();
		}
	}
}
