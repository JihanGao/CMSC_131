package poker;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

/* 
 * PokerJPanel is the specialized panel where the game will be drawn. 
 * (This is the "view")
 */
public class PokerGUI extends JPanel {

	private static final long serialVersionUID = 0L;
	
	// constants used for sizing of frame and components in GUI
	static final int TABLE_PADDING = 25;
	static final int CARD_WIDTH = 71;
	static final int CARD_HEIGHT = 96;
	static final int CARD_PADDING = 15;
	static final int PLAYER_PADDING = 50;
	static final int VERTICAL_TEXT_OFFSET = 15;
	static final int X_OFFSET = CARD_WIDTH * 2 + CARD_PADDING * 2 + PLAYER_PADDING;
	static final int Y_OFFSET = CARD_HEIGHT + VERTICAL_TEXT_OFFSET + CARD_PADDING + PLAYER_PADDING;
	static final int TABLE_HEIGHT = 2 * TABLE_PADDING + 3 * Y_OFFSET - PLAYER_PADDING - CARD_PADDING + CARD_HEIGHT + TABLE_PADDING;
	static final int DECK_CARD_OFFSET = 15;
	static final int TABLE_WIDTH = 
			Math.max(2 * TABLE_PADDING + (PokerGame.NUM_PLAYERS / 2) * X_OFFSET - CARD_PADDING - PLAYER_PADDING,
			45 * DECK_CARD_OFFSET + CARD_WIDTH + TABLE_PADDING);
	static final int COMMUNITY_OFFSET = 
			TABLE_WIDTH/2 - (CARD_WIDTH * 5) / 2 - 2 * CARD_PADDING;

	JButton dealButton = new JButton("            ");
	JButton shuffle1 = new JButton("Shuffle");
	JLabel cutInstructions = new JLabel("Click on a card to cut the deck at that position.");

	Dimension size;
	PokerGame game;  // the "model" and "controller"

	private class DealButtonListener implements ActionListener {

		/* Callback that runs when button is clicked */
		public void actionPerformed(ActionEvent e) {
			game.proceedToNextStep(dealButton);
			updateDisplay(0);
		}
	}
	
	private class Shuffle1Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			game.doShuffle1();
			updateDisplay(0);
		}
	}
	
	public class MyMouseListener implements MouseListener{
		public void mousePressed(MouseEvent e) {
			int x = e.getX(), y = e.getY();
			if ((y > TABLE_PADDING && y < TABLE_PADDING + CARD_HEIGHT) &&
					x > TABLE_PADDING && x < TABLE_PADDING + (game.getDeck().getNumCards() - 1)* DECK_CARD_OFFSET + CARD_WIDTH) {
				int card = (x - TABLE_PADDING) / DECK_CARD_OFFSET;
				if (card > game.getDeck().getNumCards() - 1) {
					card = game.getDeck().getNumCards() - 1;
				}
				game.doCutDeck(card);
			}
			updateDisplay(0);
		}
		
		public void mouseClicked(MouseEvent e) {
			
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	public PokerGUI(PokerGame game) {

		this.game = game;

		dealButton.addActionListener(new DealButtonListener());
		shuffle1.addActionListener(new Shuffle1Listener());

		size = new Dimension(TABLE_WIDTH, TABLE_HEIGHT);

		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));  // left to right
		setBackground(new Color(40, 180, 40));   // looks like green felt table!
		add(Box.createHorizontalStrut(20));
		dealButton.setText("Deal");
//		add(dealButton);

		// Create a top-level window
		JFrame frame = new JFrame("Beeblebroxian Poker Simulator");
		
		frame.setResizable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel combo = new JPanel();
		combo.setLayout(new java.awt.BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(40, 180, 40));
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
		topPanel.add(shuffle1);
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(cutInstructions);
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(dealButton);

		this.setSize(TABLE_WIDTH, TABLE_HEIGHT);
		this.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		this.setMinimumSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		this.setBounds(new java.awt.Rectangle(TABLE_WIDTH, TABLE_HEIGHT));
		MyMouseListener mouseListener = new MyMouseListener();
		this.addMouseListener(mouseListener);
		combo.add(topPanel, java.awt.BorderLayout.NORTH);
		combo.add(this, java.awt.BorderLayout.SOUTH);
		frame.setContentPane(combo);
		frame.pack();
		frame.show();
	}

	/*
	 * redraws the panel, then waits a specified period
	 */
	public void updateDisplay(int milliseconds) {
		repaint();
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {}
	}

	/*
	 * Tells Java how big frame should be.
	 */
	public Dimension getPreferredSize() {
		return size;
	}

	/*
	 * Called by the system to display the current state. YOU SHOULD NEVER
	 * CALL THIS METHOD!  The system will call it automatically anytime the
	 * view needs to be re-drawn.  (This is an example of a "call-back" method.)
	 */
	public void paint(Graphics g) {
		super.paint(g);   // ensures button is drawn
		if (game != null) {
			int x, y;
			Deck deck = game.getDeck();
			Card[] deckCards = new Card[deck.getNumCards()];
			for (int i = 0; i < deckCards.length; i++) {
				deckCards[i] = deck.getCardAt(i);
			}
			Player[] players = game.getPlayers();
			Card[] tableCards = game.getTableCards();

			/* Draw cards in the deck */
			for (int i = 0; i < deckCards.length; i++) {
				drawCard(g, deckCards[i], TABLE_PADDING + DECK_CARD_OFFSET * i, TABLE_PADDING);
			}

			for (int player = 0; player < players.length; player++) {
				// calculate location on screen for this player's cards/label
				int playersPerRow = players.length / 2;
				int playerX = TABLE_PADDING + (player % playersPerRow) * X_OFFSET;
				y = TABLE_PADDING * 2 + CARD_HEIGHT + (player / playersPerRow) * Y_OFFSET * 2;

				Card[] playerCards = players[player].getHand();
				if (players[player].getHand() != null) {
					Card[] hand = new Card[7];  // player cards plus table cards
					for (int i = 0; i < playerCards.length ; i++) {
						hand[i] = playerCards[i];
					}
					for (int i = 0; i < tableCards.length; i++) {
						hand[i + 2] = tableCards[i];
					}


					// evaluate hand and draw label for this player
					String handName = BestHandFinder.evaluteHand(hand);
					g.setColor(Color.BLACK);
					if (hand[0] != null) {
						g.drawString("Player " + (player + 1) + ":  " + handName, playerX, y);
					}
					// draw the cards for this player
					y += VERTICAL_TEXT_OFFSET;
					for (int card = 0; card < playerCards.length; card++) {
						x = playerX + card * (CARD_WIDTH + CARD_PADDING);
						Card c = players[player].getHand()[card];
						drawCard(g, c, x, y);
					}
				}
			}

			// draw "community" cards
			x = COMMUNITY_OFFSET;
			y = TABLE_PADDING + Y_OFFSET + TABLE_PADDING + CARD_HEIGHT;
			if (tableCards.length > 0) {
				g.drawString("Community Cards", x, y);
			}
			y += VERTICAL_TEXT_OFFSET;
			for (int i = 0; i < tableCards.length; i++) {
				x = COMMUNITY_OFFSET + i * (CARD_WIDTH + CARD_PADDING);
				Card c = tableCards[i];
				drawCard(g, c, x, y);
			}
		}
	}

	/* 
	 * Draws card c within graphical context g at coordinates (x, y).
	 * If c == null, the card appears face-down
	 */
	private void drawCard(Graphics g, Card c, int x, int y) {
		String cardName;
		if (c == null) {
			cardName = "images/b1fv.gif";  // face-down
		} else {
			cardName = c.getImageFileName();
		}
		g.drawImage(ImageLoader.getImage(cardName), x, y, this);
	}
} 