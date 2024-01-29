import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void main(String[] args) {
        String sourceDirectory = "/home/koryun/Документы/";

        String backupDirectory = "./backup";
        File backupDir = new File(backupDirectory);
        backupDir.mkdir();

        backupFiles(sourceDirectory, backupDirectory);
    }

    private static void backupFiles(String sourceDir, String backupDir) {
        File sourceDirectory = new File(sourceDir);
        File[] files = sourceDirectory.listFiles();

        if (files != null) {
            for (File file : files) {

                if (file.isFile()) {
                    try {
                        Files.copy(file.toPath(), new File(backupDir + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Создана резервная копия файла: " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Директория не существует или пуста.");
        }
    }
}
