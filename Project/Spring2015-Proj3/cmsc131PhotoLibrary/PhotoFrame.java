package cmsc131PhotoLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

class PhotoFrame extends JPanel {

	// To make Serializable interface happy
	static final long serialVersionUID = 0;

	Photograph p;

	// BasicPicture and size of image to display
	BufferedImage image;

	JFrame frame;

	JButton button = new JButton("Modify Photo");

	JButton button2 = new JButton("Load New Photo");

	JRadioButton[] radioButtons;

	private int[] buttonFlag;

	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Constructor creates a frame containing specified picture and title
	 */
	PhotoFrame(int[] flag, JRadioButton[] radioButtons, Photograph toLock,
			String title, int x, int y) {
		p = toLock;
		buttonFlag = flag;
		this.radioButtons = radioButtons;

		image = toLock.getImage();
		setBackground(Color.gray);

		// Create a top-level window to put the picture in
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);

		/* Create panel for the stuff at the top of the display */
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		/* Create the panes that make up the top panel */
		final int NUM_PANELS = 3;
		JPanel[] layers = new JPanel[NUM_PANELS];
		for (int i = 0; i < NUM_PANELS; i++)
			layers[i] = new JPanel();

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (p) {
					frame.dispose();
					buttonFlag[0] = 0;
					p.notifyAll();
				}
			}

		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (p) {
					frame.dispose();
					buttonFlag[0] = 1;
					p.notifyAll();
				}
			}

		});

		layers[0].setBackground(Color.LIGHT_GRAY);
		layers[1].setBackground(Color.LIGHT_GRAY);
		layers[2].setBackground(Color.LIGHT_GRAY);

		/* Populate 1st layer with prompt */
		layers[0].add(this);

		layers[1].setLayout(new GridLayout(3, 3));
		for (int i = 0; i < PhotoSystem.NUM_RADIO_BUTTONS; i++) {
			radioButtons[i].setBackground(Color.LIGHT_GRAY);
			buttonGroup.add(radioButtons[i]);
			layers[1].add(radioButtons[i]);

		}
		radioButtons[0].setSelected(true);

		layers[2].add(button);
		layers[2].add(button2);

		/* Add the layers to the top panel */
		topPanel.add(layers[0], BorderLayout.NORTH);
		topPanel.add(layers[1], BorderLayout.CENTER);
		topPanel.add(layers[2], BorderLayout.SOUTH);

		/* Instantiate, setup, and display top-level window */

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		topPanel.validate();
		frame.setContentPane(topPanel);

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Removes the picture.
	 */
	void clear() {
		frame.dispose();

	}

	/**
	 * Tells Java how big picture frame should be.
	 */
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(), image.getHeight());
	}

	/**
	 * This paints the actual image
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
