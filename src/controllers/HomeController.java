package controllers;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private JFXListView<String> listLocation;

    public static JFXDialog dialogDetailPC;

    private DetailPCController detailPCController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FXMLLoader detailsLoader = new FXMLLoader(getClass().getResource("/resources/views/DetailPC.fxml"));
        DetailPCController detailPCController = detailsLoader.getController();

        try {
            VBox detailsPCPane = detailsLoader.load();
            dialogDetailPC = new JFXDialog(root, detailsPCPane, JFXDialog.DialogTransition.CENTER);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void updateLocation(List<String> locations) {
        listLocation.getItems().clear();
        if(locations != null)
            listLocation.getItems().addAll(locations);
    }

    @FXML
    private void onRefresh() {
        onShowDetailPC();
    }

    private void onShowDetailPC() {
        //detailPCController.initialize(null, null);
        dialogDetailPC.show();
    }
}