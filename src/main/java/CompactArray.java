import java.io.FileOutputStream;
import java.io.IOException;

public class CompactArray {
    public static void main(String[] args) {
        int[] gameField = {1, 2, 0, 3, 2, 1, 0, 3, 1};
        int compactRepresentation = 0;

        for (int i = 0; i < gameField.length; i++) {
            int shiftedValue = gameField[i] << (i * 2);
            compactRepresentation |= shiftedValue;
        }
        try (FileOutputStream fos = new FileOutputStream("compactField.bin")) {
            fos.write(compactRepresentation & 0xFF);
            fos.write((compactRepresentation >> 8) & 0xFF);
            fos.write((compactRepresentation >> 16) & 0xFF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
