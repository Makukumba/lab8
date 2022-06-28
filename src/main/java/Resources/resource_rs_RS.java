package Resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;

public class resource_rs_RS extends ListResourceBundle {
    private static Locale locale = new Locale("rs","RS");
    // private static Locale locale;
    private static final Object[][] contents =
            {
                    {"Enter","Ентер"},
                    {"Registration","Регистрација"},
                    {"Date", DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(new Date())},
                    {"Changer","Промени језик"},
                    {"Change","Промена"},
                    {"Login","Пријавите се"},
                    {"Password","Лозинка"},
                    {"Table","Сто"},
                    {"Graph","Распоред"},
                    {"User","Корисник"},
                    {"Successful registration","Успешна регистрација"},
                    {"Error, First add items to collection","Грешка, прво додајте ставке у колекцију"},
                    {"Collection type","Врста колекције"},
                    {"Number of items in the collection","Број предмета у колекцији"},
                    {"Collection creation date","Датум креирања колекције"},
                    {"Имя дракона","Змајево име"},
                    {"Координата X","Кс координата"},
                    {"Координата Y","И координата"},
                    {"Описание дракона","Опис змаја"},
                    {"Возраст дракона","доба змајева"},
                    {"Вес дракона","тежина змаја"},
                    {"Характер дракона","Драгон цхарацтер"},
                    {"Количество глаз","Број очију"},
                    {"Добавить дракона","Додај змаја"},
                    {"Go to Main Menu","Изађите у главни мени"},
                    {"Ошибка, сначала зайдите в свой профиль VK","Грешка, прво идите на свој ВК профил"},
                    {"BackButton","Назад"}
            };
    protected Object[][] getContents() {
        return contents;
    }
}