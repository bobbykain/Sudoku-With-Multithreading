

public class Sudoku implements Runnable{
    int[][] myPuzzle;
    int[][] rowNums;
    int[][] colNums;
    int[][] boxNums;

    public Sudoku(String fileName) {
        myPuzzle = CSVReader.readPuzzle(fileName);
        rowNums = new int[9][10];
        colNums = new int[9][10];
        boxNums = new int[9][10];
    }

    public void run() {

    }

    public void countNums() {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++ col) {
                int num = myPuzzle[row][col];
                ++rowNums[row][num];
                ++colNums[col][num];
                if (row < 3 && col < 3)
                    ++boxNums[0][num];
                else if (row < 3 && (col > 2 && col < 6))
                    ++boxNums[1][num];
                else if (row < 3 && col > 5)
                    ++boxNums[2][num];
                else if ((row > 2 && row < 6) && col < 3)
                    ++boxNums[3][num];
                else if ((row > 2 && row < 6) && (col > 2 && col < 6))
                    ++boxNums[4][num];
                else if ((row > 2 && row < 6) && col > 5)
                    ++boxNums[5][num];
                else if (row > 5 && col < 3)
                    ++boxNums[6][num];
                else if (row > 5 && (col > 2 && col < 6))
                    ++boxNums[7][num];
                else
                    ++boxNums[8][num];
            }
        }
    }

    public static void main(String[] args) {
        Sudoku puzzle = new Sudoku("csv/ex1.csv");
        puzzle.countNums();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(puzzle.rowNums[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(puzzle.colNums[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(puzzle.boxNums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
