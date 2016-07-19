package main;

import java.util.Date;

import gui.ContAccGUI;
import service.ContAccService;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		ContAccGUI cai = new ContAccGUI();
		cai.setVisible(true);
		Date d = new Date();
		cai.setLblTime(d.toString());
		while(true){
			Thread.sleep(5000);
			d = new Date();
			cai.setLblTime(d.toString());
		}

	}

}
