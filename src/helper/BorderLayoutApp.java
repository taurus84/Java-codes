package helper;

import javax.swing.JFrame;

public class BorderLayoutApp {
	public void start() {
		JFrame frame = new JFrame( "BorderLayoutApp" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( new BorderLayoutPanel() );
		frame.pack();
		frame.setVisible( true );
	}
	public static void main(String[] args) {
		BorderLayoutApp app = new BorderLayoutApp();
		app.start();
	}
}
