import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt"; // Путь к исходному файлу
        String destinationFilePath = "destination.txt"; // Путь к целевому файлу

        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationFilePath);

        try {
            if (Files.exists(destinationPath)) {
                throw new IllegalStateException("Целевой файл уже существует: " + destinationFilePath);
            }

            // Копирование содержимого файла
            Files.copy(sourcePath, destinationPath);
            System.out.println("Файл успешно скопирован!");

        } catch (FileNotFoundException e) {
            // Обработка отсутствия исходного файла
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IllegalStateException e) {
            // Обработка недопустимого состояния
            System.err.println("Ошибка состояния: " + e.getMessage());
        } catch (IOException e) {
            // Обработка других ошибок ввода-вывода
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
