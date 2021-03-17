package pixViewer;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		GUI gui = new GUI();
		SwingUtilities.invokeLater(gui);
	}
}