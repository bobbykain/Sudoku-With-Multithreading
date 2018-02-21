

public class Sudoku {
    public static void main(String[] args) {
        int[][] myPuzzle = CSVReader.readPuzzle("csv/ex1.csv");

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(myPuzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
