package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	private int qtd = 0;
	private int threadId;
	private int total = 10;
	private Semaphore mutex;

	public ThreadController(int threadId, int total, Semaphore mutex) {
		this.threadId = threadId;
		this.total = total;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		
		while (qtd <= total) {
			login();
			comprar();
		}

		// IN�CIO DA SE��O CR�TICA
		
//		try {
//			mutex.acquire();
			valida��o();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			mutex.release();
//		}

		// FIM DA SE��O CR�TICA
	}

	private void login() {

		int ingresso = (int) ((Math.random() * 4) + 1);
		System.out.println("Thread #" + threadId + " Quantidade escolhida: " + ingresso + " ingressos");

		int tempo1 = (int) ((Math.random() * 4) + 1);

		if (tempo1 < 3) {
			try {
				sleep(tempo1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Tempo expirado, sess�o encerrada!");
		}
		
		tempo1 = 0;
	}

	private void comprar() {

		int tempo2 = (int) ((Math.random() * 3) + 1);
		
		if (tempo2 < 2) {
			try {
				sleep(tempo2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Tempo expirado, sess�o encerrada!");
		}
	}
	
	private void valida��o() {

		
		}
	}

