package betting;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OddsConverterPanel extends JPanel {
	
	JPanel pnlEast = new JPanel();
	JPanel pnlCenter = new JPanel();
	JPanel pnlSouth = new JPanel();
	JPanel pnlNorth = new JPanel();
	JPanel pnlCenterLeft = new JPanel();
	JPanel pnlCenterRight = new JPanel();
	JPanel[] pnlGames = new JPanel[13];
	JPanel[] pnlCheckBoxes = new JPanel[13];
	JPanel[] pnlProcents = new JPanel[13];
	JPanel[] pnlOddses = new JPanel[13];
	Checkbox[][] checkBoxes = new Checkbox[13][3];
	JLabel title = new JLabel("Stryktipshjälpen");
	JLabel[][] lblProcents = new JLabel[13][3];
	JLabel[][] lblOddses = new JLabel[13][3];
	JPanel pnlCheckBox = new JPanel();
	JPanel pnlProcent = new JPanel();
	JPanel pnlOdds = new JPanel();
	JTextField tfOdds = new JTextField();
	JTextArea taResult = new JTextArea();
	JButton btnDone = new JButton("Convert");
	Controller controller;
	Random rand = new Random();
	private final int GAP = 5;
	
	private Font font = new Font("SansSerif", Font.BOLD, 14);
	private Font fontTitle = new Font("Arial", Font.BOLD, 20);
	
	
	
	public OddsConverterPanel() {
		controller = new Controller(this);
		
		setPreferredSize(new Dimension(800,500));
		setLayout(new BorderLayout());
		pnlNorth.setPreferredSize(new Dimension(0,50));
		pnlSouth.setPreferredSize(new Dimension(0,50));
		pnlNorth.setBackground(Color.WHITE);
		pnlCenter.setBackground(Color.RED);
		
		pnlSouth.setBackground(Color.GREEN);
		
		//panel north
		title.setFont(fontTitle);
		pnlNorth.add(title);
		//panel center, includes gridlayout
		pnlCenter.setLayout(new GridLayout(1,2));
		pnlCenterLeft.setLayout(new GridLayout(13,1,GAP,1));
		pnlCheckBox.setLayout(new GridLayout(13,1,GAP,1));
		pnlProcent.setLayout(new GridLayout(13,3,GAP,1));
		pnlOdds.setLayout(new GridLayout(13,1,GAP,1));
		pnlCenterRight.setLayout(new GridLayout(1,3));
	
	
		pnlCenterRight.setBackground(Color.darkGray);
		initializePanels();
		setGamePanels();	
		pnlCenter.add(pnlCenterLeft);
		pnlCenter.add(pnlCenterRight);
		//panel south, toggle buttons should be here
		
		add(pnlSouth, BorderLayout.SOUTH);
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter);
		AL listener = new AL();
	}
	
	/**
	 * filling panels with objects
	 */
	private void initializePanels() {
		pnlCheckBox.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlProcent.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlOdds.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlCenterRight.add(pnlCheckBox);
		pnlCenterRight.add(pnlProcent);
		pnlCenterRight.add(pnlOdds);
		for(int i = 0; i < 13; i++) {
			pnlGames[i] = new JPanel();
			pnlCheckBoxes[i] = new JPanel();
			pnlProcents[i] = new JPanel();
			pnlOddses[i] = new JPanel();
			for(int j = 0; j < 3; j++) {
				checkBoxes[i][j] = new Checkbox();
				lblProcents[i][j] = new JLabel(i + j + "%");
				lblOddses[i][j] = new JLabel(i + j + ".00");
				lblProcents[i][j].setBackground(new Color((int)(Math.random() * 0x1000000)));
				lblProcents[i][j].setPreferredSize(new Dimension(35,20));
				lblOddses[i][j].setPreferredSize(new Dimension(35,20));
				pnlCheckBoxes[i].add(checkBoxes[i][j]);
				pnlProcents[i].add(lblProcents[i][j]);
				pnlOddses[i].add(lblOddses[i][j]);
			}
			pnlGames[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlCheckBoxes[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlProcents[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlOddses[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			
			pnlCenterLeft.add(pnlGames[i]);
			pnlCheckBox.add(pnlCheckBoxes[i]);
			pnlProcent.add(pnlProcents[i]);
			pnlOdds.add(pnlOddses[i]);
		}
	}

	private void setGamePanels() {
	}

	private class AL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnDone) {
				//double odds = Double.parseDouble(tfOdds.getText().toString());
				//controller.convertOddsToProbability(odds);
				int probability = Integer.parseInt(tfOdds.getText().toString());
				controller.convertProbabilityToOdds(probability);
			}
			
		}
		
	}
	
	

}
