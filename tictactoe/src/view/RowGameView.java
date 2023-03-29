/*
This interface represents a composite view for the RowGame game.
It defines a method "update" that takes a RowGameModel object as a parameter
and updates the view based on the state of the model.
*/
package view;

import model.RowGameModel;

public interface RowGameView
{
    /**
    * Updates the view based on the state of the RowGameModel object passed as a parameter.
    * @param gameModel the RowGameModel object representing the current state of the game
    */
    public void update(RowGameModel gameModel); 
}