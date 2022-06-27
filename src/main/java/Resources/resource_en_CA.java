package Resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;

public class resource_en_CA extends ListResourceBundle {
    private static Locale locale = new Locale("en","CA");
    private static final Object[][] contents =
            {
                    {"Enter","Enter"},
                    {"Registration","Regisration"},
                    {"Date", DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(new Date())},
                    {"Changer","Change language"},
                    {"Change","Change"},
                    {"Login","Login"},
                    {"Password","Password"},
                    {"Table","Table"},
                    {"Graph","Graph"},
                    {"User", "User"},
                    {"Successful registration","Successful registration"},
                    {"Error, First add items to collection","Error, First add items to collection"},
                    {"Collection type","Collection type"},
                    {"Number of items in the collection","Number of items in the collection"},
                    {"Collection creation date","Collection creation date"},
                    {"Имя дракона","Dragon name"},
                    {"Координата X","X coordinate"},
                    {"Координата Y","Y coordinate"},
                    {"Описание дракона","Description of the dragon"},
                    {"Возраст дракона","Dragon age"},
                    {"Вес дракона","Dragon weight"},
                    {"Характер дракона","Dragon character"},
                    {"Количество глаз","Number of eyes"},
                    {"Добавить дракона","Add dragon"}
            };
    protected Object[][] getContents() {
        return contents;
    }
}
