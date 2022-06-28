package Resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;

public class resource_hu_HU extends ListResourceBundle {
    private static Locale locale = new Locale("hu", "HU");
    private static final Object[][] contents =
            {
                    {"Enter", "Belép"},
                    {"Registration", "Bejegyzés"},
                    {"Date", DateFormat.getDateInstance(DateFormat.DEFAULT, locale).format(new Date())},
                    {"Changer", "Válts nyelvet"},
                    {"Change", "változás"},
                    {"Login","Belépés"},
                    {"Password","Jelszó"},
                    {"Table","Asztal"},
                    {"Graph","Menetrend"},
                    {"User","Felhasználó"},
                    {"Successful registration","Sikeres regisztráció"},
                    {"Error, First add items to collection","Hiba, először adjon hozzá elemeket a gyűjteményhez"},
                    {"Collection type","Gyűjtemény típusa"},
                    {"Number of items in the collection","A gyűjtemény elemeinek száma"},
                    {"Collection creation date","Gyűjtemény létrehozásának dátuma"},
                    {"Имя дракона","Sárkány neve"},
                    {"Координата X","X koordináta"},
                    {"Координата Y","Y koordináta"},
                    {"Описание дракона","A sárkány leírása"},
                    {"Возраст дракона","Sárkánykor"},
                    {"Вес дракона","Sárkány súlya"},
                    {"Характер дракона","Sárkány karakter"},
                    {"Количество глаз","Szemek száma"},
                    {"Добавить дракона","Add hozzá a sárkányt"},
                    {"Go to Main Menu","Lépjen ki a főmenübe"},
                    {"Ошибка, сначала зайдите в свой профиль VK","Hiba, először lépjen a VK-profiljába"},
                    {"BackButton","Vissza"}
            };

    protected Object[][] getContents() {
        return contents;
    }
}