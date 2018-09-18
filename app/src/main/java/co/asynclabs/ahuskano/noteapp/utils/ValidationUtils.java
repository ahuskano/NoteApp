package co.asynclabs.ahuskano.noteapp.utils;

import android.widget.EditText;

public class ValidationUtils {

    public static boolean isNullOrEmpty(String input) {
        return input == null || isEmpty(input);
    }

    public static boolean isNullOrEmpty(EditText input){
        return input == null || input.getText() == null || isEmpty(input.getText().toString());
    }

    private static boolean isEmpty(String input) {
        return "".equalsIgnoreCase(input);
    }

}
