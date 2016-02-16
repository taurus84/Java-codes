package helper;
import java.awt.*;
import javax.swing.*;

public class BorderLayoutPanel extends JPanel {
    private JLabel lblTxt1 = new JLabel("Detta är text 1");
    private JLabel lblTxt2 = new JLabel("Text 2");
    private JButton btnExit = new JButton("Avsluta");
    private JButton button = new JButton("Knapp");
    private JTextArea textarea = new JTextArea();
    private Font font = new Font("SansSerif", Font.BOLD, 14);

    public BorderLayoutPanel() {
        setPreferredSize( new Dimension( 1500, 500 ) );
        setLayout(new BorderLayout(10,5));

        lblTxt1.setFont(font);                   // typsnitt för texten i 'lblTxt1'
        lblTxt1.setBorder(BorderFactory.createLineBorder(Color.black));  // kantlinje
        lblTxt1.setPreferredSize(new Dimension(50, 50));
        lblTxt2.setBackground(Color.red);        // bakgrundsfärg på 'lblTxt2'
        lblTxt2.setOpaque(true);
        button.setFont(font);                    // typsnitt i 'button'
        btnExit.setBackground(Color.MAGENTA);
        textarea.setPreferredSize(new Dimension(60,60));
        textarea.setBorder(BorderFactory.createLineBorder(Color.black)); // kantlinje
        
        add(btnExit, BorderLayout.NORTH);
        add(button, BorderLayout.WEST);
        add(textarea, BorderLayout.EAST);
        add(lblTxt1, BorderLayout.SOUTH);
        add(lblTxt2, BorderLayout.CENTER);
    }
}
