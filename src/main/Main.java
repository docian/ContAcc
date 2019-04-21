package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import gui.ContAccGUI;
import service.ContAccService;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		ContAccGUI cai = new ContAccGUI();
		cai.setVisible(true);
		Date d = new Date();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		cai.setLblTime(formatter.format(d).toString());
		while(true){
			Thread.sleep(5000);
			d = new Date();
			cai.setLblTime(formatter.format(d).toString());
		}

	}

}
