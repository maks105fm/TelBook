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

        String n = scanner.nextLine();

        switch (n) {
            case "1" -> newContact();
            case "2" -> delcontact();
            case "3" -> redcontact();
            case "4" -> spiscontact();

        }
    }

    public void redcontact(){
        spiscontact();
        System.out.println(" Какой изменить контакт? ");
        int number1 = scanner.nextInt();
        if(number1 < contacts.length){
            if (contacts[number1] != null){ //На этом этапе я нашел строку в которой хочу произвести редактирование. Нужно чтобы человек ввел данные и записать в нужную ячейку.

                int id = number1;

                System.out.println("Введите Имя ");
                String name = scanner.nextLine();

                System.out.println("Введите Фамилию ");
                String surname = scanner.nextLine();

                System.out.println("Введите номер ");
                String number = scanner.nextLine();
                Contact contact = new Contact(id, name, surname, number);
                addcontact(contact);

            }
        }
    }

    public void delcontact() {
        spiscontact();
        System.out.println(" Какой удалить контакт? ");
        int number = scanner.nextInt();
        if(number < contacts.length){
            if (contacts[number] != null) {
                contacts[number] = null;
            }
        }
        System.out.println("Не корректный индекс");
        menu();

    }

    public void spiscontact() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                System.out.println(i + " " + contacts[i].getName() + " " + contacts[i].getSurname() + " " + contacts[i].getNumber());
            }

        }
    }


    public void newContact() {
        System.out.println("Введите Имя ");
        String name = scanner.nextLine();

        System.out.println("Введите Фамилию ");
        String surname = scanner.nextLine();

        System.out.println("Введите номер ");
        String number = scanner.nextLine();

        int id = 0;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null){
                id = i;
            }
        }

        Contact contact = new Contact(id, name, surname, number);
        addcontact(contact);
        System.out.println(contacts[id].getName());
        menu();
    }

    public void addcontact(Contact contact) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
            }
        }
    }
}
