package com.fishingpoker;

public class NewGame extends Thread{

	public NewGame() {
		// TODO Auto-generated constructor stub
	}
	   boolean isRunning = true;

	    int timer = 0;

	    /**
	     * 线程体代码
	     */
	    @Override
	    public void run() {
	        while (isRunning) {
	            try {
	                Thread.currentThread().sleep(1000);
	                timer++;
	                System.out.println("逝去了 "+timer+" 秒");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }	
	    }
}
