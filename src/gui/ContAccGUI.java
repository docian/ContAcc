package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.Angajati;
import service.ContAccService;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ContAccGUI extends JFrame {
	private JTextField txtField;
	private JTextArea txtAreaResults;
	private static ContAccService cas;
	private JTextField textField;
	private JTextField txtAccessPoint;
	private JTextField txtCardId;
	private JLabel lblTime;
	private JButton btnSalveaza;

	public JTextField getTxtAccessPoint() {
		return txtAccessPoint;
	}

	public JTextField getTxtCardId() {
		return txtCardId;
	}

	public JLabel getLblTime() {
		return lblTime;
	}

	public void setLblTime(String time) {
		this.lblTime.setText(time);
	}

	public static void main(String ... args){
		new ContAccGUI().setVisible(true);
			
	}

	public ContAccGUI() {
		cas = ContAccService.getInstance();
		setTitle("ContAcc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("Application");
		tabbedPane.setToolTipText("dfgd");
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(tabbedPane);
		
		JPanel panelAngajati = new JPanel();
		panelAngajati.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Angajati", null, panelAngajati, null);
		panelAngajati.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVizualizeazaComponenteDin = new JLabel("Vizualizeaza componente din baza de date ContAcc");
		lblVizualizeazaComponenteDin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVizualizeazaComponenteDin.setHorizontalAlignment(SwingConstants.CENTER);
		panelAngajati.add(lblVizualizeazaComponenteDin, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panelAngajati.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 1, 0));
		
		txtAreaResults = new JTextArea();
		txtAreaResults.setRows(10);
		txtAreaResults.setColumns(30);
		panel.add(txtAreaResults);
		
		JPanel panelCenter = new JPanel();
		panelAngajati.add(panelCenter, BorderLayout.SOUTH);
		
		JLabel lblNume = new JLabel("Nume");
		panelCenter.add(lblNume);
		lblNume.setVerticalAlignment(SwingConstants.TOP);
		
		txtField = new JTextField();
		panelCenter.add(txtField);
		txtField.setColumns(15);
		
		JLabel lblNewLabel = new JLabel("Prenume");
		panelCenter.add(lblNewLabel);
		
		textField = new JTextField();
		panelCenter.add(textField);
		textField.setColumns(15);
		
		Button button = new Button("Cauta");
		panelCenter.add(button);
		
		Cautare cl = new Cautare(txtAreaResults);
		
		button.addActionListener(cl);
		
		JPanel panelDepartamente = new JPanel();
		tabbedPane.addTab("Departamente", null, panelDepartamente, null);
		
		JPanel panelEvenimente = new JPanel();
		tabbedPane.addTab("Evenimente", null, panelEvenimente, null);
		panelEvenimente.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		FlowLayout fl_panelNorth = (FlowLayout) panelNorth.getLayout();
		fl_panelNorth.setHgap(15);
		panelEvenimente.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lbPunctAcces = new JLabel("Punct de Acces");
		panelNorth.add(lbPunctAcces);
		
		txtAccessPoint = new JTextField();
		panelNorth.add(txtAccessPoint);
		txtAccessPoint.setColumns(10);
		
		JLabel lblCardId = new JLabel("CardId");
		panelNorth.add(lblCardId);
		
		txtCardId = new JTextField();
		panelNorth.add(txtCardId);
		txtCardId.setColumns(10);
		
		JPanel panelCentral = new JPanel();
		panelEvenimente.add(panelCentral, BorderLayout.CENTER);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setRows(10);
		txtArea.setColumns(45);
		panelCentral.add(txtArea);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelEvenimente.add(panel_3, BorderLayout.SOUTH);
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblTime);
		
		JButton btnCauta = new JButton("Cauta");
		panel_3.add(btnCauta);
		btnCauta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnSalveaza = new JButton("Salveaza Eveniment");
		panel_3.add(btnSalveaza);
		btnSalveaza.addActionListener(new EvenimenteListen(this));
		
	}
	
	private class Cautare implements ActionListener{
		private JTextArea txtAreaResult;
		
		public Cautare(JTextArea txtAreaResult){
			this.txtAreaResult = txtAreaResult;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Cauta")){
				List<Angajati> la = cas.regasesteAngajatiNume(txtField.getText());
				StringBuilder sb = new StringBuilder();
				for(Angajati ita:la){
					sb.append(ita.getId()+" "+ita.getNume()+" "+ita.getPrenume()+" "+ita.getCardId()+"\r\n");
				}
				if(sb.length()>0) {
					txtAreaResult.setText(sb.toString());
				}else{
					JOptionPane.showMessageDialog(null, "not such a name in db");
				}							
			}			
		}		
	}

}
