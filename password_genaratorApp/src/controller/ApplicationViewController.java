package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class ApplicationViewController {

    public TextField txtGenaratePassword;

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static  final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%&*";




    private static Random random = new Random();
    public static TextField txtCount;


    public void genaratorPasswordOnAction(ActionEvent actionEvent) {


        txtGenaratePassword.setText(generatePassword());

    }

    public void copyOnAction(ActionEvent actionEvent) {
        String password = txtGenaratePassword.getText();
        Clipboard clip = Toolkit.getDefaultToolkit()
                .getSystemClipboard();
        StringSelection strse1 = new StringSelection(password);
        clip.setContents(strse1, strse1);
        new Alert(Alert.AlertType.INFORMATION, "PASSWORD COPIED!").show();
        //JOptionPane.showMessageDialog(null,"PASSWORD COPIED!");
    }


    public static String generatePassword() {


        StringBuilder password = new StringBuilder();

        // Add lowercase characters
        for (int i = 0; i < 3; i++) {
            password.append(LOWERCASE_CHARACTERS.charAt(random.nextInt(LOWERCASE_CHARACTERS.length())));
        }

        // Add uppercase characters
        for (int i = 0; i < 2; i++) {
            password.append(UPPERCASE_CHARACTERS.charAt(random.nextInt(UPPERCASE_CHARACTERS.length())));
        }

        // Add numeric characters
        for (int i = 0; i < 2; i++) {
            password.append(NUMERIC_CHARACTERS.charAt(random.nextInt(NUMERIC_CHARACTERS.length())));
        }

        // Add special characters
        for (int i = 0; i < 1; i++) {
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

        // Shuffle the password to ensure that it is random
        String passwordString = password.toString();
        char[] passwordChars = passwordString.toCharArray();
        shuffleArray(passwordChars);

        return new String(passwordChars);
    }

    private static void shuffleArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            char temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

}

