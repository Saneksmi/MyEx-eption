package com.company;

import java.io.*;

/**
 * Программа для заполнения телефонной книги и записи её в файл,
 * с выбросом исключения если контакт дублируется.
 * */
public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        int numberOfNote;
        String filePath;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Сколько записей внести в телефонную книгу?");
        String s = reader.readLine();
        if (s.isEmpty()) {
            System.out.println("Вы ничего не ввели :(");
        } else {
            numberOfNote = Integer.parseInt(s);
            for (int i = 0; i < numberOfNote; i++) {
                try {
                    phoneBook.putToMap();
                } catch (DoubleContactException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //вывод мапы в консоль для проверки
        //phoneBook.mapTest();

        System.out.println(" ");
        System.out.println("Укажите путь к txt файлу,"
                + "для сохранения телефонной книги");
        filePath = reader.readLine();
        try {
            phoneBook.mapToFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
    }
}
