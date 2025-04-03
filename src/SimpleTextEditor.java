import java.io.*; import java.util.Scanner;

public class SimpleTextEditor {

 public static void main(String[] args)
 {
 Scanner scanner = new Scanner(System.in); while (true)
 {
 System.out.println("Меню:");
 System.out.println("1. Записати в файл");
 System.out.println("2. Прочитати файл");
 System.out.println("3. Вихід");
 System.out.print("Выберить дію: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
        writeToFile(scanner);
    } else if (choice == 2) {
        readFromFile();
    } else if (choice == 3) {
        System.out.println("Вихід із програми.");
        break;
    } else {
        System.out.println("Невірний ввід. Спробуйте ще раз .");
    }
}
    scanner.close();
}

    public static void writeToFile(Scanner scanner) {
        System.out.print("Введіть строку для запису в файл: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(text + "\n");
            System.out.println("Запис виконан успішно.");
        } catch (IOException e) {
            System.out.println("Помилка при запису в файл.");
        }
    }

    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            System.out.println("Вміст файлу:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайден. Спочатку додайте дані");
        } catch (IOException e) {
            System.out.println("Помилка при читання  файлу.");
        }
    }

}
