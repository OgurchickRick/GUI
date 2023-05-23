package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    public Spinner shiftField;
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
                textField.textProperty().isEmpty().or(shiftField.valueProperty().isNull())
        );
        decipherButton.disableProperty().bind(
                textField.textProperty().isEmpty().or(shiftField.valueProperty().isNull())
        );
    }


    @FXML
    protected void encryptButtonClick() {
        String text = textField.getText();
        int shift = (int) shiftField.getValue();
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isAlphabetic(ch)) {
                boolean isLowerCase = Character.isLowerCase(ch);
                if (isLowerCase) {
                    ch += shift;
                    if (ch > 'я') {
                        ch -= 32;
                    }
                } else {
                    ch += shift;
                    if (ch > 'Я') {
                        ch -= 32;
                    }
                }
            }
            res += ch;
        }
        result.setText(res);
    }



    @FXML
    protected void decipherButtonClick() {
        String text = textField.getText();
        int shift = (int) shiftField.getValue();
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isAlphabetic(ch)) {
                boolean isLowerCase = Character.isLowerCase(ch);
                if (isLowerCase) {
                    ch -= shift;
                    if (ch < 'а') {
                        ch += 32;
                    }
                } else {
                    ch -= shift;
                    if (ch < 'А') {
                        ch += 32;
                    }
                }
            }
            res += ch;
        }
        result.setText(res);
    }
}