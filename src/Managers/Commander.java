package Managers;

import Drago.Dragon;
import Users.Enter;
import commands.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Commander {
   public static HashMap<String, Command> commands;
    Dragon dragon;
    long id;
    String d;
    ResourceBundle bundle;
    public Commander(CommandManager cm) {
        commands = new HashMap<>();
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(cm,bundle));
        commands.put("show", new ShowCommand(cm));
        commands.put("save", new SaveCommand(cm));
        commands.put("add", new AddCommand(cm,dragon));
        commands.put("update", new UpdateCommand(cm,dragon));
        commands.put("remove_by_id", new RemoveById(cm,id));
        commands.put("clear", new ClearCommand(cm));
        commands.put("execute_script", new Execute_script(commands));
        commands.put("exit", new ExitCommand(cm));
        commands.put("add_if_max", new Add_if_max(cm,dragon));
        commands.put("add_if_min", new Add_if_min(cm,dragon));
        commands.put("remove_lower", new RemoveLowerCommand(cm,id));
        commands.put("remove_any_by_description", new Remove_any_by_description(cm,d));
        commands.put("print_field_descending_head", new Print_field_descending_head(cm));
        commands.put("create_table",new Create_table());
        commands.put("auth", new Authorization());
        commands.put("show_users", new ShowUsersCommand(bundle));
    }

    public void start() throws IOException {

        while (true) {
            Scanner s = new Scanner(System.in);
            String text = s.nextLine();
            int a = 0;
           for (Map.Entry<String, Command> command : commands.entrySet()) {

                if (text.equals(command.getKey())) {
                    command.getValue().execute();
                    a = 1;
                }
            }


            if (a == 0) {
                System.out.println("Команда не найдена");
            }
        }
    }
}
