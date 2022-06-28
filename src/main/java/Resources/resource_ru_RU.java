package Resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;

public class resource_ru_RU extends ListResourceBundle {
    private static  Locale locale = new Locale("ru","RU");
   // private static Locale locale;
    private static final Object[][] contents =
            {
                    {"Enter","Вход"},
                    {"Registration","Регистрация"},
                    {"Date", DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(new Date())},
                    {"Changer","Смена языка"},
                    {"Change","Поменять"},
                    {"Login","Логин"},
                    {"Password","Пароль"},
                    {"Table","Таблица"},
                    {"Graph","График"},
                    {"User","Пользователь"},
                    {"Successful registration","Успешная регистрация"},
                    {"Error, First add items to collection","Ошибка. Сначала добавьте элементы в коллекцию."},
                    {"Collection type","Тип коллекции"},
                    {"Number of items in the collection","Количество элементов в коллекции"},
                    {"Collection creation date","Дата создания коллекции"},
                    {"Имя дракона","Имя дракона"},
                    {"Координата X","Координата Х"},
                    {"Координата Y","Координата Y"},
                    {"Описание дракона","Описание дракона"},
                    {"Возраст дракона","Возраст дракона"},
                    {"Вес дракона","Вес дракона"},
                    {"Характер дракона","Характер дракона"},
                    {"Количество глаз","Количество глаз"},
                    {"Добавить дракона","Добавить дракона"},
                    {"Go to Main Menu","В главное меню"},
                    {"Ошибка, сначала зайдите в свой профиль VK","Ошибка, сначала зайдите в свой профиль VK"},
                    {"BackButton","Назад"}
            };
    protected Object[][] getContents() {
        return contents;
    }
}
