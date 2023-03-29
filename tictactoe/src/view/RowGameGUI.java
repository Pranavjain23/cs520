/**
The RowGameGUI class is a composite view that contains
the RowGameGridView and RowGameStatusView as its components.
It also initializes the game GUI and provides the functionality
to update the view after each player move and reset the game.
*/
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;

public class RowGameGUI implements RowGameView{
    // The game GUI frame
    public JFrame gui = new JFrame("Tic Tac Toe");
    // The game model
    public RowGameModel gameModel = new RowGameModel();

    // The reset button
    public JButton reset = new JButton("Reset");

    // The player turn text area
    public JTextArea playerturn = new JTextArea();

    // The game controller
    private RowGameController gameController;

    // The game board view component
    public RowGameGridView gameBoardView;

    // The game status view component
    public RowGameStatusView gameStatusView;

    /**
     * Creates a new RowGameGUI object with a given RowGameController.
     * Initializes the game GUI with the game board view, game status view,
     * and reset button components.
     * Creates a new game initializing the GUI.
     * 
     * @param gameController The RowGameController that controls the game.
     */
    public RowGameGUI(RowGameController gameController) {
        this.gameController = gameController;
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);
        

        gameBoardView = new RowGameGridView(this.gameController);
        JPanel gamePanel = gameBoardView.gamePanel;

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);

        gameStatusView = new RowGameStatusView(this.gameController);
        JPanel messages = gameStatusView.messages;

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        gameStatusView.messages.add(playerturn);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameController.resetGame();
            }
        });

    }

    /**
     * Updates the block at the given row and column 
     * after one of the player's moves.
     *
     * @param gameModel The RowGameModel containing the block
     * @param row The row that contains the block
     * @param column The column that contains the block
     */
    public void update(RowGameModel gameModel) {
        gameBoardView.update(gameModel);
    
        gameStatusView.update(gameModel);
        }
}