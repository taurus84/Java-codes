package betting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class StryktipsPanel extends JPanel {
	
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
	JLabel jblTitle = new JLabel("<html><div style='text-align: center;'>" + "VECKANS OMGÅNG" + "</div></html>");
	JLabel jblTurnOver = new JLabel();
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
	private final int GAP = 0;

	
	private Font font = new Font("SansSerif", Font.BOLD, 14);
	private Font fontTitle = new Font("Arial", Font.BOLD, 20);
	private Font fontTurnOver = new Font("Arial", Font.BOLD, 10);
	
	
	
	public StryktipsPanel() {
		controller = new Controller(this);
		
		setPreferredSize(new Dimension(800,500));
		setLayout(new BorderLayout());
		pnlNorth.setPreferredSize(new Dimension(0,50));
		pnlSouth.setPreferredSize(new Dimension(0,20));
//		pnlNorth.setBackground(Color.WHITE);
//		pnlCenter.setBackground(Color.RED);
//		pnlSouth.setBackground(Color.GREEN);
		
		//panel north
		jblTitle.setFont(fontTitle);
		pnlNorth.add(jblTitle);
		//panel center, includes gridlayout
		pnlCenter.setLayout(new GridLayout(1,2));
		pnlCenterLeft.setLayout(new GridLayout(13,1,GAP,GAP));
		pnlCheckBox.setLayout(new GridLayout(13,1,GAP,GAP));
		pnlProcent.setLayout(new GridLayout(13,3,GAP,GAP));
		pnlOdds.setLayout(new GridLayout(13,1,GAP,GAP));
		pnlCenterRight.setLayout(new GridLayout(1,3));
	
	
		pnlCenterRight.setBackground(Color.darkGray);
		initializePanels();
		setGamePanels();	
		pnlCenter.add(pnlCenterLeft);
		pnlCenter.add(pnlCenterRight);
		//panel south, toggle buttons should be here
		jblTurnOver.setFont(fontTurnOver);
		pnlSouth.add(jblTurnOver);
		add(pnlSouth, BorderLayout.SOUTH);
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter);
		AL listener = new AL();
		loadDataFromSvenskaSpel();
	}

	private void loadDataFromSvenskaSpel() {
		SvenskaSpelData ssd = new SvenskaSpelData();
		jblTitle.setText(ssd.getWeekHeader());
		jblTurnOver.setText("Omsättning: " + ssd.getTurnOver());
		String[] games = ssd.getMatches();
		String[][] procents = ssd.getProcents();
		String[][] odds = ssd.getOdds();
		for(int i = 0; i < 13; i++) {
			pnlGames[i].add(new JLabel(games[i]));
			for(int j = 0; j < 3; j++) {
				lblProcents[i][j].setText(procents[i][j]+"%");
				lblOddses[i][j].setText(odds[i][j]);
				lblOddses[i][j].setBackground(Color.BLUE);
				lblOddses[i][j].setOpaque(true);
			}
		}
	}

	/**
	 * filling panels with objects
	 */
	private void initializePanels() {
		pnlCheckBox.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlProcent.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlOdds.setBackground(new Color((int)(Math.random() * 0x1000000)));
		pnlCenterRight.add(pnlProcent);
		pnlCenterRight.add(pnlOdds);
		pnlCenterRight.add(pnlCheckBox);
		for(int i = 0; i < 13; i++) {
			pnlGames[i] = new JPanel();
			pnlCheckBoxes[i] = new JPanel();
			pnlProcents[i] = new JPanel();
			pnlOddses[i] = new JPanel();
			for(int j = 0; j < 3; j++) {
				checkBoxes[i][j] = new Checkbox();
				JLabel tempLbl = new JLabel();
				//tempLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				lblProcents[i][j] = tempLbl;
				lblOddses[i][j] = new JLabel("x.00");
//				lblProcents[i][j].setBackground(new Color((int)(Math.random() * 0x1000000)));
				lblProcents[i][j].setPreferredSize(new Dimension(35,20));
				lblOddses[i][j].setPreferredSize(new Dimension(35,20));
				pnlCheckBoxes[i].add(checkBoxes[i][j]);
				pnlProcents[i].add(lblProcents[i][j]);
				pnlOddses[i].add(lblOddses[i][j]);
			}
/*			pnlGames[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlCheckBoxes[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlProcents[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
			pnlOddses[i].setBackground(new Color((int)(Math.random() * 0x1000000)));
*/
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

	public Color getColor(double power)
	{
		//Where "power" is a number between 0.0 and 1.0. 0.0 will return a bright red, 1.0 will return a bright green.
		double H = power * 0.4; // Hue (note 0.4 = Green, see huge chart below)
		double S = 0.9; // Saturation
		double B = 0.9; // Brightness

		return Color.getHSBColor((float)H, (float)S, (float)B);
	}
	
	

}
