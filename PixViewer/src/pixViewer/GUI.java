package pixViewer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * The location of the graphical user interface, panel and buttons.
 */
public class GUI implements Runnable {

	public JPanel buttonPanel;
	public ImagePanel imagePanel;
	private JFrame frame;

	public GUI() {
	}

	/*
	 * Graphical user interface basic settings.
	 */
	@Override
	public void run() {
		frame = new JFrame("Pix Viewer 2020");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600)); // Start resolution/size.
		frame.setMinimumSize(new Dimension(600, 450)); // Minimum size allowed (for button visability).
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents(Container container) {

		imagePanel = new ImagePanel(); // The UI that shows the image, changes it etc.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		// ******************************************
		// Defining and adding the buttons/panels:
		// ******************************************
		JButton openButton = new JButton("Öppna fil");
		openButton.setActionCommand("openButton");
		openButton.addActionListener(new ButtonListener(imagePanel));

		JButton saveButton = new JButton("Spara fil");
		saveButton.setActionCommand("saveButton");
		saveButton.addActionListener(new ButtonListener(imagePanel));

		JButton clearButton = new JButton("Rensa");
		clearButton.setActionCommand("clearButton");
		clearButton.addActionListener(new ButtonListener(imagePanel));

		JButton rotateButton = new JButton("Rotera");
		rotateButton.setActionCommand("rotateButton");
		rotateButton.addActionListener(new ButtonListener(imagePanel));

		JButton negativeButton = new JButton("Negativ");
		negativeButton.setActionCommand("negativeButton");
		negativeButton.addActionListener(new ButtonListener(imagePanel));

		JButton mirrorButton = new JButton("Spegla bild");
		mirrorButton.setActionCommand("mirrorButton");
		mirrorButton.addActionListener(new ButtonListener(imagePanel));

		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Creates a space between operational and effect
																	// buttons.
		buttonPanel.add(rotateButton);
		buttonPanel.add(negativeButton);
		buttonPanel.add(mirrorButton);

		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

	}
}
