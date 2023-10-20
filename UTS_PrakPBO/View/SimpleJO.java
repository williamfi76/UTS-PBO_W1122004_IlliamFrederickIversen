package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SimpleJO {

    public static void showMSG(String title, String content) {
        JOptionPane.showMessageDialog(null, content, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showMSG(String title, String content, int type) {
        JOptionPane.showMessageDialog(null, content, title, type);
    }

    public static String inputStr(String title, String content, int type) {
        return JOptionPane.showInputDialog(null, content, title, type);
    }

    public static String inputStr(String title, String content) {
        return JOptionPane.showInputDialog(null, content, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static int inputInt(String title, String content, int type) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, content, title, type));
    }

    public static int inputInt(String title, String content) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, content, title, JOptionPane.PLAIN_MESSAGE));
    }

    public static boolean inputYN(String content, String title) {
        int choice = JOptionPane.showConfirmDialog(null, content, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (choice == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inputYN(String content, String title, int type) {
        int choice = JOptionPane.showConfirmDialog(null, content, title, JOptionPane.YES_NO_OPTION, type);
        if (choice == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String inputOption(String title, String content, ArrayList<String> options) {
        String arr[] = new String[options.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = options.get(i);
        }
        int index = JOptionPane.showOptionDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, arr, options.get(0));

        return options.get(index);
    }
}
