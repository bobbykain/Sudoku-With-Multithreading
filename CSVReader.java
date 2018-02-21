import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static int[][] readPuzzle(String fileName) {
        int[][] puzzle = new int[9][9];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            for (int i = 0; i < 9; ++i) {
                line = br.readLine();
                String[] row = line.split(",");
                for (int j = 0; j < 9; ++j) {
                    puzzle[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puzzle;
    }
}
