package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    public TextField shiftField;
    @FXML
    private TextField textField;
    @FXML
    private Label result;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decipherButton;


    public void initialize() {
        encryptButton.disableProperty().bind(
                textField.textProperty().isEmpty().or(shiftField.textProperty().isEmpty())
        );
        decipherButton.disableProperty().bind(
                textField.textProperty().isEmpty().or(shiftField.textProperty().isEmpty())
        );
    }

    @FXML
    protected void handleKeyTyped() {
        String text = shiftField.getText();
        if (!text.matches("\\d*")) {
            shiftField.setText(text.replaceAll("\\D", ""));
        }
    }

    @FXML
    protected void encryptButtonClick() {
        String text = textField.getText();
        int shift = Integer.parseInt(shiftField.getText());
        String res = "";
        for (int i = 0; i <text.length(); i++) {
            char ch = (char) (text.charAt(i)+shift);
            res += ch;
        }
        result.setText(res);
    }

    @FXML
    protected void decipherButtonClick() {
        String text = textField.getText();
        int shift = Integer.parseInt(shiftField.getText());
        String res = "";
        for (int i = 0; i <text.length(); i++) {
            char ch = (char) (text.charAt(i)-shift);
            res += ch;
        }
        result.setText(res);
    }

}