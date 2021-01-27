/*
Corradina Dinatale 100645103
 Alex Balez 101219847
 */
package chessclubmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ChessClubGUIController implements Initializable {

    MemberManager memMgr;

    public ChessClubGUIController() {
        memMgr = new MemberManager(1, 60);
    }

    @FXML
    private TextField textFieldFName;
    @FXML
    private TextField textFieldLName;
    @FXML
    private TextField textFieldGamesPlayed;
    @FXML
    private TextField textFieldWins;
    @FXML
    private TextArea membersDetails;

    @FXML
    private void addButtonAction(ActionEvent event) {

        String firstName = textFieldFName.getText();
        String lastName = textFieldLName.getText();
        int gamesPlayed, wins;
        try{
            gamesPlayed = Integer.parseInt(textFieldGamesPlayed.getText());
            wins = Integer.parseInt(textFieldWins.getText());
        }catch (java.lang.NumberFormatException e){
            Alert a = new Alert(Alert.AlertType.NONE, "Plays/wins must be numbers.", ButtonType.OK);
            a.showAndWait();
            return;
        }
        int losses = gamesPlayed - wins;

        if (memMgr.addMember(firstName, lastName, gamesPlayed, wins, losses)) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Added successfully ", ButtonType.OK);
            alert.showAndWait();
            clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "List is full!", ButtonType.OK);
            alert.showAndWait();
            clear();
        }

    }

    @FXML
    private void deleteButtonAction(ActionEvent event) {

        String id = JOptionPane.showInputDialog(null, "Please enter the ID of the memeber you wish to delete:",
                "Delete Member", JOptionPane.OK_CANCEL_OPTION);

        if (memMgr.deleteMember(Integer.parseInt(id))) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Deleted successfully ", ButtonType.OK);
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Result not found", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void updateWinsButtonAction(ActionEvent event) {

        String id = JOptionPane.showInputDialog(null, "Please enter the ID of the memeber who won:",
                "Record Win", JOptionPane.OK_CANCEL_OPTION);
        String wins = JOptionPane.showInputDialog(null, "Please enter the number of wins you wish to record:",
                "Record Win", JOptionPane.OK_CANCEL_OPTION);

        if (memMgr.updateWins(Integer.parseInt(id), Integer.parseInt(wins))) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Updated successfully ", ButtonType.OK);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Member Not found ", ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    private void updateLossesButtonAction(ActionEvent event) {

        String id = JOptionPane.showInputDialog(null, "Please enter the ID of the memeber who lost:",
                "Record Loss", JOptionPane.OK_CANCEL_OPTION);
        String losses = JOptionPane.showInputDialog(null, "Please enter the number of losses you wish to record:",
                "Record Loss", JOptionPane.OK_CANCEL_OPTION);
        if (memMgr.updateLosses(Integer.parseInt(id), Integer.parseInt(losses))) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Updated successfully ", ButtonType.OK);
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.NONE, "Member Not found ", ButtonType.OK);
            alert.showAndWait();

        }
    }

    void clear() {
        textFieldFName.setText("");
        textFieldLName.setText("");
        textFieldGamesPlayed.setText("");
        textFieldWins.setText("");
    }

    @FXML
    private void viewMembersButtonAction(ActionEvent event) {
        membersDetails.setText("");
        membersDetails.setText(memMgr.getMemberList());
    }

    @FXML
    private void viewBestPlayerButtonAction(ActionEvent event) {
        membersDetails.setText("");
        membersDetails.setText(memMgr.viewBestPlayer());
    }

    @FXML
    private void viewMostWinsButtonAction(ActionEvent event) {
        membersDetails.setText("");
        membersDetails.setText(memMgr.viewMostWins());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
