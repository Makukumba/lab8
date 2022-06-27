package commands;

import Managers.CommandManager;

import java.util.ResourceBundle;

public class InfoCommand extends AbstractCommand {
    CommandManager cm;
    ResourceBundle bundle;
    public InfoCommand(CommandManager cm,ResourceBundle bundle) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.cm = cm;
        this.bundle = bundle;
    }


    public void execute() {
        cm.info(bundle);

    }
}
