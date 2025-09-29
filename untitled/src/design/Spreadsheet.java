package design;

public class Spreadsheet {
    private final int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int column = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row - 1][column] = value;
    }

    public void resetCell(String cell) {
        int column = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row - 1][column] = 0;
    }

    public int getValue(String formula) {
        if (formula.charAt(0) == '=') {
            formula = formula.substring(1);
        }

        String[] parts = formula.split("\\+");
        int sum = 0;

        for (String part : parts) {
            part = part.trim();
            if (Character.isDigit(part.charAt(0))) {
                sum += Integer.parseInt(part);
            } else {
                int col = part.charAt(0) - 'A';
                int row = Integer.parseInt(part.substring(1)) - 1;
                sum += sheet[row][col];
            }
        }
        return sum;
    }





    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
        int value = spreadsheet.getValue("=5+7");// returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        int value1 = spreadsheet.getValue("=A1+6");// returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        int value2 = spreadsheet.getValue("=A1+B2");// returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        int value3 = spreadsheet.getValue("=A1+B2");// returns 15 (0+15)
    }
}
