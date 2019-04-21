package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Evenimente;
import service.ContAccService;

public class EvenimenteListen implements ActionListener {
	private JTextField txtAccessPoint, txtCardId;
	private JLabel lblTime;
	
	
	public EvenimenteListen(ContAccGUI cag){
		this.txtAccessPoint = cag.getTxtAccessPoint();
		this.txtCardId = cag.getTxtCardId();
		this.lblTime = cag.getLblTime();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Salveaza Eveniment")){
			EntityManager em = null;
			Evenimente ev = null;
			try{
				ContAccService cas = ContAccService.getInstance();
				DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");				
				Date d = sdf.parse(lblTime.getText());
				cas.adaugaEveniment(txtCardId.getText(),txtAccessPoint.getText(),d);				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				
			}
		}
	}

}
