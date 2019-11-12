package controllers.UserController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilController implements Initializable {

    @FXML
    private JFXButton save , update , cancel;
    @FXML
    private AnchorPane root;
    @FXML
    private Pane show , modifier;

    @FXML
    private void save(ActionEvent e) {

        show.toFront();
    }
    @FXML
    private void update(ActionEvent e) {
        modifier.toFront();

    }
    @FXML
    private void cancel (ActionEvent e) {
        show.toFront();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
