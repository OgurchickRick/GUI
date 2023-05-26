package com.example.gui;

import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    public Spinner shiftField;
    @FXML
    private TextArea textField;
    @FXML
    private TextArea result;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decipherButton;
    @FXML
    private Button cleanButton;

    private final int alphabet_size = 32;

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
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isAlphabetic(ch)) {
                boolean isLowerCase = Character.isLowerCase(ch);
                ch += shift;
                if (isLowerCase && ch > 'я') {
                    ch -= alphabet_size;
                } else if (!isLowerCase && ch > 'Я') {
                    ch -= alphabet_size;
                }
            }
            res.append(ch);
        }
        result.setText(res.toString());
    }

    @FXML
    protected void decipherButtonClick() {
        String text = textField.getText();
        int shift = (int) shiftField.getValue();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isAlphabetic(ch)) {
                boolean isLowerCase = Character.isLowerCase(ch);
                ch -= shift;
                if (isLowerCase && ch < 'а') {
                    ch += alphabet_size;
                } else if (!isLowerCase && ch < 'А') {
                    ch += alphabet_size;
                }
            }
            res.append(ch);
        }
        result.setText(res.toString());
    }

    @FXML
    protected void cleanButtonClick() {
        textField.setText("");
        result.setText("");
        showAlert("Очистка", "Поля очищены");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}