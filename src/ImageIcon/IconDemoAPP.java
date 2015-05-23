package ImageIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

//从网上借鉴的代码
/**
 * If the graphic files are loaded from an initial thread, there may be a delay
 * before the GUI appears. If the graphic files are loaded from the event
 * dispatch thread, the GUI may be temporarily unresponsive. So we use
 * SwingWorker as a background processing for the loading of image files.
 * <p>
 * This application needs the customization of the image files' informations in
 * the private inner class "LoadImages".
 * 
 * @author HAN
 * @version 1.0
 * @see IconDemoAPP2 version 2.0
 */
@SuppressWarnings("serial")
public class IconDemoAPP extends JPanel {
	private static JFrame frame;
	private JLabel photoLabel;
	private JToolBar toolBar;
	private int displayZone = 400;

	/**
	 * The constructor serves as the content pane construction.
	 */
	IconDemoAPP() {
		// JPanel uses FlowLayout by default. We set it to BorderLayout for
		// use of tool bar. This JPanel will be used as content pane.
		setLayout(new BorderLayout());

		// Create and add the tool bar to the content pane
		toolBar = createToolBar();
		add(toolBar, BorderLayout.SOUTH);

		// Create the photoLabel.
		photoLabel = new JLabel();
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		// Create a scroll pane to contain the photoLabel and set it up to the
		// center of the content pane in order to display the photo we wanted.
		JScrollPane scrollPane = new JScrollPane(photoLabel);
		add(scrollPane, BorderLayout.CENTER);

		setPreferredSize(new Dimension(displayZone + 100, displayZone + 100));

		// start a SwingWorker to load images in a background thread.
		new LoadImages().execute();
	}

	private JToolBar createToolBar() {
		// TODO Auto-generated method stub
		JToolBar toolBar = new JToolBar("Select an icon to be displayed");

		// Add two glue components in order to center the icon buttons.
		toolBar.add(Box.createGlue());
		toolBar.add(Box.createGlue());

		return toolBar;
	}

	/**
	 * @param path
	 *            - the path used to create the buffered image.
	 * @return an BufferedImage object, or <code>null</code> if the given path
	 *         is not valid or an error occurs during reading.
	 */
	private BufferedImage createImage(String path) {
		// TODO Auto-generated method stub
		URL imageURL = getClass().getResource(path);
		if (imageURL != null) {
			try {
				return ImageIO.read(imageURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("an error occurs during reading.");
				e.printStackTrace();
				return null;
			}
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * It is for the image icon that needs a description for the visually
	 * impaired user.
	 * <p>
	 * Create an icon from an original image, which has normally a bigger size.
	 * 
	 * @param image
	 *            - the original image to be converted to icon
	 * @param width
	 *            - the created icon width
	 * @param height
	 *            - the created icon height
	 * @param desc
	 *            - the description for created icon, which would allow
	 *            assistive technologies to help visually impaired user
	 *            understand what information the icon conveys.
	 * @return an Icon object
	 */
	private Icon createIcon(Image image, int width, int height, String desc) {
		// TODO Auto-generated method stub
		BufferedImage iconImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = iconImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return new ImageIcon(iconImage, desc);
	}

	/**
	 * It is for the image icon without the description.
	 * <p>
	 * Create an icon from an original image, which has normally a bigger size.
	 * 
	 * @param image
	 *            - the original image to be converted to icon
	 * @param width
	 *            - the created icon width
	 * @param height
	 *            - the created icon height
	 * @return an Icon object
	 */
	private Icon createIcon(Image image, int width, int height) {
		// TODO Auto-generated method stub
		BufferedImage iconImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = iconImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		return new ImageIcon(iconImage);
	}

	/**
	 * Based on the original big image, we create a scaled version (keep the
	 * initial width-height ratio) to display if this image is bigger than the
	 * display zone we customized; or else, display it directly.
	 * 
	 * @param photoPath
	 *            - the path of original big image.
	 */
	private void displayPhoto(String photoPath) {
		BufferedImage photo = createImage(photoPath);
		int width = photo.getWidth();
		int height = photo.getHeight();
		int maxLength = Math.max(width, height);
		int displayZone = getDisplayZone();
		if (maxLength < displayZone) {
			// display the photo directly
			photoLabel.setIcon(new ImageIcon(photo));
		} else {
			// display the scaled version (keep the initial width-height ratio).
			if (maxLength == photo.getWidth()) {
				// The width is bigger than the height.
				photoLabel
						.setIcon(createIcon(
								photo,
								displayZone,
								(int) (displayZone * ((float) height / (float) width))));
			} else {
				// The height is bigger than the width.
				photoLabel.setIcon(createIcon(photo,
						(int) (displayZone * ((float) width / (float) height)),
						displayZone));
			}
		}
	}

	@SuppressWarnings("unused")
	private void setDisplayZone(int displayZone) {
		this.displayZone = displayZone;
	}

	private int getDisplayZone() {
		return displayZone;
	}

	private class LoadImages extends SwingWorker<Void, Icon> {
		private String imageDir = "/image/";
		private String[] imageNames = { "bkgd.jpg", "bkgd1.jpg",
				"bkgd2.jpg" };
		private String[] imageCaptions = { "Chrysanthemum", "Desert",
				"Hydrangeas" };

		private int iconIndex = 0;

		@Override
		protected Void doInBackground() throws Exception {
			System.out
					.println("We are now in the Swing's predefined thread: The background thread...");
			for (int i = 0; i < imageNames.length; i++) {

				BufferedImage image = createImage(imageDir + imageNames[i]);
//				System.out.println(image.toString());
				Icon buttonIcon = createIcon(image, 32, 32, imageCaptions[i]);

				// Multiple invocations to the publish method might occur before
				// the process method is executed. For performance purposes all
				// these invocations are coalesced into one invocation with
				// concatenated arguments. And the process method might be
				// executed many times, which is invoked asynchronously from the
				// event-dispatching thread.
				publish(buttonIcon);
			}
			return null;
		}

		@Override
		protected void process(List<Icon> iconChunks) {
			for (Icon buttonIcon : iconChunks) {
				JButton toolBarButton = new JButton(new ToolBarButtonAction(
						buttonIcon, imageDir + imageNames[iconIndex],
						imageCaptions[iconIndex]));
				iconIndex++;

				// Add the new button just BEFORE the last glue, which centers
				// the buttons in the tool bar.
				toolBar.add(toolBarButton, toolBar.getComponentCount() - 1);
			}
		}
	}

	private class ToolBarButtonAction extends AbstractAction {
		ToolBarButtonAction(Icon buttonIcon, String actionCommand,
				String toolTip) {
			putValue(LARGE_ICON_KEY, buttonIcon);
			putValue(ACTION_COMMAND_KEY, actionCommand);
			putValue(SHORT_DESCRIPTION, toolTip);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// the action command represents the path of the image we want to
			// display in the center of the content pane.
			String path = e.getActionCommand();

			// Show the photo in the main area.
			displayPhoto(path);

			// Set the application title.
			frame.setTitle("Icon demo: " + new File(path).getName());
		}

	}

	/**
	 * For thread safety, this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create the window.
		frame = new JFrame("Icon demo: Please select an image");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JPanel contentPane = new IconDemoAPP();
		frame.setContentPane(contentPane);

		// realize the inside components.
		frame.pack();

		// this centers the frame on the screen
		frame.setLocationRelativeTo(null);

		// display the window.
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		if (!SwingUtilities.isEventDispatchThread()) {
			System.out.println("This is in the initial thread...");
		}

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				if (SwingUtilities.isEventDispatchThread()) {
					System.out
							.println("This is in the event-dispatching thread...");
				}
				createAndShowGUI();
			}

		});
	}

}
