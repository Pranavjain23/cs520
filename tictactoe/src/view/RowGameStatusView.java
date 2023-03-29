/**
This class represents the status view of the RowGame.
It implements the RowGameView interface and serves as a composite class
along with other views to form the composite view of the game.
It displays the current player turn on the game board.
*/
package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.RowGameController;
import model.RowGameModel;

public class RowGameStatusView implements RowGameView
{
    // Declare the JTextArea to display the current player turn
    public JTextArea playerturn = new JTextArea();
    // Declare the JPanel to hold the messages
    public JPanel messages = new JPanel(new FlowLayout());

    /**
   * Constructor for RowGameStatusView class.
   * It initializes the JPanel and adds the JTextArea to it.
   * @param gameController the RowGameController object to be used in the view
   */
    public RowGameStatusView(RowGameController gameController) {
		super();
    }

    /**
    * Updates the view with the current state of the game model.
    * It sets the background color of the messages panel to white and
    * adds the player turn JTextArea to it.
    * @param gameModel the RowGameModel object containing the current game state
    */
    public void update(RowGameModel gameModel) {
        messages.setBackground(Color.white);
		messages.add(playerturn);
		}
}