import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku implements Runnable {
    int[][] myPuzzle;   // 9x9 array of sudoku board
    int[][] rowNums;    // 9x9 array of number of times a number appears in each row
    int[][] colNums;    // 9x9 array of number of times a number appears in each col
    int[][] boxNums;    // 9x9 array of number of times a number appears in each box

    public Sudoku(String fileName) {
        //myPuzzle = CSVReader.readPuzzle(fileName);
        myPuzzle = new int[9][9];
        rowNums = new int[9][10];
        colNums = new int[9][10];
        boxNums = new int[9][10];
        initialize(fileName);
    }

    public void initialize(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            for (int row = 0; row < 9; ++row) {
                line = br.readLine();
                String[] row_arr = line.split(",");
                for (int col = 0; col < 9; ++col) {
                    int num = Integer.parseInt(row_arr[col]);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

    }

    /*public void countNums() {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
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
    }*/

    public static void main(String[] args) {
        Sudoku puzzle = new Sudoku("csv/ex2.csv");

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
