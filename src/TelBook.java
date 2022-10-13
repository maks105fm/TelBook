import java.util.InputMismatchException;
import java.util.Scanner;

public class TelBook {
    private Scanner scanner = new Scanner(System.in);
    private Contact[] contacts = new Contact[1000];

    public void menu() {
        System.out.println();
        System.out.println(" Выберите пункт в меню: ");
        System.out.println("1 - Добавить новый контакт");
        System.out.println("2 - Удалить  контакт");
        System.out.println("3 - Редактировать  контакт");
        System.out.println("4 - Список контактовт");
        System.out.println("5 - Удалить все записи");

        String n = scanner.nextLine();

        switch (n) {
            case "1" -> {
                newContact();
                menu();
            }
            case "2" -> {
                delcontact();
                menu();
            }
            case "3" -> {
                redcontact();
                menu();
            }
            case "4" -> {
                spiscontact();
                menu();
            }
            case "5" -> {
                delspiscont();
                menu();
            }
            default -> {
                System.out.println("Нет такого пункта меню");
                menu();
            }
        }
    }

    public void delspiscont() {
        contacts = new Contact[contacts.length];
        System.out.println("Записи удалены!");
    }

    public void redcontact() {
        spiscontact();
        System.out.println(" Какой изменить контакт? ");
        int number1 = scanner.nextInt();
        scanner.nextLine();

        if ((number1 - 1) < contacts.length) {
            Contact contact = contacts[number1 - 1];
            if (contacts[number1 - 1] != null) {

                System.out.println("Введите Имя ");
                String name = scanner.nextLine();

                System.out.println("Введите Фамилию ");
                String surname = scanner.nextLine();

                System.out.println("Введите номер ");
                String number = scanner.nextLine();

                contact.setName(name);
                contact.setSurname(surname);
                contact.setNumber(number);


            }
        }
    }

    public void delcontact() {
        spiscontact();
        System.out.println(" Какой удалить контакт? ");
        try {
            int number = scanner.nextInt();
            scanner.nextLine();

            if (number < contacts.length && contacts[number - 1] != null) {
                contacts[number - 1] = null;
                System.out.println("Контакт " + contacts[number - 1].getName() + " удалён");
            } else System.out.println("Не корректный индекс");

        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Вы указали не верный id, попробуйте ещё раз!");
            delcontact();
        }
    }

    public void spiscontact() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                System.out.println((i + 1) + " " + contacts[i].getName() + " " + contacts[i].getSurname() + " " + contacts[i].getNumber());
            }

        }
    }


    public void newContact() {
        System.out.println("Введите Имя ");
        String name = scanner.nextLine();
        while (!name.isBlank()) {
            System.out.println("Введите Фамилию ");
            String surname = scanner.nextLine();
            while (!surname.isBlank()) {
                System.out.println("Введите номер ");
                String number = scanner.nextLine();
                while (!surname.isBlank()) {

                    int id = 0;
                    for (int i = 0; i < contacts.length; i++) {
                        if (contacts[i] == null) {
                            id = i;
                            break;
                        }
                    }

                    Contact contact = new Contact(name, surname, number);
                    addcontact(contact);
                    break;
                } break;
            } break;
        }
    }

    public void addcontact(Contact contact) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
                break;
            }
        }
    }
}
