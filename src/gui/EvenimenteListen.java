package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

public class EvenimenteListen implements ActionListener {
	
	private JTabbedPane tbdPane;
	
	public EvenimenteListen(JTabbedPane tbdPane){
		this.tbdPane = tbdPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("")){
			
		}
	}

}
