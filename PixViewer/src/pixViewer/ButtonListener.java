package pixViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ButtonListener implements ActionListener {

	GUI gui = new GUI();
	ImagePanel imagePanel = new ImagePanel();

	public ButtonListener(ImagePanel imagePanel) {
		this.imagePanel = imagePanel;

	}

	public void actionPerformed(ActionEvent action) {

		switch (action.getActionCommand()) {
		// ******************************************
		case "openButton":
			JFileChooser chooseFile = new JFileChooser("");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG & GIF Images", "jpg", "gif", "png");
			chooseFile.setFileFilter(filter);

			int returnValue = chooseFile.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				if (chooseFile.getSelectedFile() != null) {

					imagePanel.loadImage(chooseFile.getSelectedFile()); // load image (but don't show it).
					imagePanel.repaint(); // refresh frame to show image.
				}
			}
			break;
		// ******************************************
		case "saveButton":
			if (imagePanel.getImage() != null) { // If there's no image loaded, the button does nothing.

				JFileChooser saveFile = new JFileChooser();
				saveFile.setDialogTitle("Spara som JPG");

				int returnVal = saveFile.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					try {
						ImageIO.write(imagePanel.getImage(), "jpg", new File(saveFile.getSelectedFile() + ".jpg"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			break;
		// ******************************************
		case "clearButton":
			if (imagePanel.getImage() != null) {

				imagePanel.doClear();
				imagePanel.repaint();
			}
			break;
		// ******************************************
		case "rotateButton":

			if (imagePanel.getImage() != null) {

				imagePanel.doRotate();
				imagePanel.repaint();
			}
			break;
		// ******************************************
		case "negativeButton":
			if (imagePanel.getImage() != null) {

				imagePanel.doNegative();
				imagePanel.repaint();
			}
			break;
		// ******************************************
		case "mirrorButton":
			if (imagePanel.getImage() != null) {

				imagePanel.doMirror();
				imagePanel.repaint();
			}
			break;
		// ******************************************
		}
	}
}
