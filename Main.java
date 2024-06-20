import controller.TeacherController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TeacherController contTeach = new TeacherController();
        contTeach.create("Антон", "Антонов", "Антонович", LocalDate.parse("06.12.1976", formatter));
        contTeach.create("Витольд", "Витольдов", "Витольдович", LocalDate.parse("12.06.1996", formatter));
        contTeach.getAllTeachers();
    }
}