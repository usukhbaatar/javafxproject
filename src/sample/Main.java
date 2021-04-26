package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    int counter = 0;
    Stage window;
    Label label;
    Button okButton;
    Button resetButton;

    void okButtonClicked() {
        counter++;
        label.setText("Clicked: " + counter);
    }

    void resetButtonClicked() {
        counter = 0;
        label.setText("Clicked: " + counter);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Hello World!");

        Pane layout = new FlowPane();

        label = new Label();
        label.setText("Clicked: 0");
        okButton = new Button();
        okButton.setText("Click Me!");
        resetButton = new Button("Reset");

        layout.getChildren().add(label);
        layout.getChildren().add(okButton);
        layout.getChildren().add(resetButton);

        // event handler

        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> okButtonClicked());
        okButton.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER)
                okButtonClicked();
        });

        resetButton.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> resetButtonClicked());
        resetButton.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER)
                resetButtonClicked();
        });

        label.setStyle("-fx-padding: 5px;");
        okButton.setStyle("-fx-padding: 5px; -fx-start-margin: 5px; -fx-end-margin: 5px;");
        resetButton.setStyle("-fx-padding: 5px;");

        Scene scene = new Scene(layout, 300, 275);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
