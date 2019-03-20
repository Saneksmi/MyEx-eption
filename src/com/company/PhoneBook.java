package com.company;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс содержит методы записи телефонной книжки в мапу,
 * запись мапы в файл и на всякий случай
 * просто вывод мапы в консоль для проверки.
 * */
public final class PhoneBook {

    private HashMap<String, String> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    //метод для заполнения телефонной книжки
    public void putToMap() throws IOException, DoubleContactException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String phoneNumber;
        System.out.println("Введите имя контакта:");
        name = reader.readLine();
        System.out.println("Введите номер телефона в формате (8900..):");
        phoneNumber = reader.readLine();
        if (map.containsKey(phoneNumber)) {
            //выбрасываем собственное исключение
            throw new DoubleContactException("Такой контакт уже есть");
        } else {
            map.put(phoneNumber, name);
        }
    }

    //метод для записи книжки в файл
    public void mapToFile(final String filePath) throws IOException {

        File file = new File(filePath);
        FileOutputStream fOS = new FileOutputStream(file);
        PrintWriter printWriter = new PrintWriter(fOS);

        for (Map.Entry<String, String> s : map.entrySet()) {
            printWriter.println(s.getValue() + " = " + s.getKey());
        }
        printWriter.flush();
        printWriter.close();
        fOS.close();
    }

    //метод для вывода мапы в консоль для проверки
    /*public void mapTest () {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getValue() + " = " + s.getKey());
        }
    }*/





}
