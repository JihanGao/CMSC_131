package cmsc131PhotoLibrary;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class ImageSelectionBox {

	/* This field is required for any class that implements Serializable */
	private static final long serialVersionUID = 0;

	/* The actual top-level window that will be displayed */
	private JFrame window;

	private JTextArea promptBox = new JTextArea();
	private JTextField inputBox = new JTextField();

	private JButton button = new JButton("Get Photo");

	/** Constructor that sets up the GUI */
	ImageSelectionBox(String initialPhoto) {

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
				synchronized(ImageSelectionBox.this) {
					ImageSelectionBox.this.notifyAll();
				}
			}
		});
		
		inputBox.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				synchronized(ImageSelectionBox.this) {
					ImageSelectionBox.this.notifyAll();
				}
			}
		});

		String prompt = "Enter the location of an image.  You may enter the name of";
		prompt += " an image in the project directory, (e.g. " + initialPhoto + " ) or it could be";
		prompt += " the complete url of an image on the internet";
		prompt += " (e.g. http://www.ahajokes.com/cartoon/overl.jpg)";

		promptBox.setColumns(40);
		promptBox.setBackground(Color.LIGHT_GRAY);
		layers[0].setBackground(Color.LIGHT_GRAY);
		layers[1].setBackground(Color.LIGHT_GRAY);
		layers[2].setBackground(Color.LIGHT_GRAY);
		promptBox.setWrapStyleWord(true);
		promptBox.setLineWrap(true);
		promptBox.setText(prompt);
		/* Populate 1st layer with prompt */
		layers[0].add(promptBox);

		inputBox.setColumns(40);
		inputBox.setText(initialPhoto);
		layers[1].add(inputBox);
		layers[2].add(button);

		/* Add the layers to the top panel */
		topPanel.add(layers[0], BorderLayout.NORTH);
		topPanel.add(layers[1], BorderLayout.CENTER);
		topPanel.add(layers[2], BorderLayout.SOUTH);

		/* Instantiate, setup, and display top-level window */
		window = new JFrame();
		window.setSize(600, 200);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		topPanel.validate();
		window.setContentPane(topPanel);
		//	window.pack();
		window.setVisible(true);


	}

	void setVisible(boolean setting) {
		window.setVisible(setting);
	}

	String getTextValue() {
		return inputBox.getText();
	}

}
