import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.sql.*;
import java.text.AttributedCharacterIterator;
import java.util.Locale;
import java.util.ResourceBundle;

import Drago.DragoPicture;
import Managers.*;
import Users.Auth;
import Users.AuthCheck;
import Users.Enter;
import Users.UserBDCreator;

import Visual.MainMenu;
import Visual.Ru.SimpleGuiRu;
import Visual.Test;

import javax.swing.*;


public class Main {
    public static void main(String args[]) {
        //AuthCheck authCheck = new AuthCheck();
        //   authCheck.Check();
        CommandManager cm = new CommandManager();
        Commander c = new Commander(cm);
        cm.read();
        //   try {
        //     c.start();
        //  } catch (IOException e) {
        //    e.printStackTrace();
     //   ResourceBundle bundle = ResourceBundle.getBundle("Resources.resource");
    //    System.out.println(bundle.getString("Enter"));
      //  System.out.println(bundle.getString("Registration"));
     //   System.out.println(bundle.getString("Date"));
       ResourceBundle bundle = ResourceBundle.getBundle("Resources.resource");
        SimpleGuiRu app = new SimpleGuiRu(bundle);
        //app.setVisible(true);
     //    DragoPicture dragoPicture = new DragoPicture();

     //   dragoPicture.paint(g);
        }
    }











