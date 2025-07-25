import console.*;
import domain.*;
import repository.*;
import service.*;
import validation.*;

public class Main {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // Automatically add a student
        System.out.println("Automatically adding a new student...");
        service.saveStudent("5", "George", 223);

        // Automatically add a laboratory assignment
        System.out.println("Automatically adding a new laboratory assignment...");
        service.saveTema("4", "OOP", 10, 8);

        // Automatically add a grade for the student
        System.out.println("Automatically adding a grade for the student...");
        service.saveNota("1", "3", 9.0, 9, "done");

        UI consola = new UI(service);
        consola.run();
    }
}
