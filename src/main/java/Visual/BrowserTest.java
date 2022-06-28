package Visual;

import Managers.CommandManager;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static Visual.EnterVisual.UserName;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class BrowserTest {
    Browser browser;
    CommandManager cm = new CommandManager();
    ResourceBundle bundle = ResourceBundle.getBundle("Resources.resource");
    JFrame frame;

    public BrowserTest() {
        Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G345QKJRYKLOQ8B2KD2HXGAAMAS2ARG85XUIFI1FOCWZNTQH9GYXP128QG29L").build());
        browser = engine.newBrowser();
        BrowserView view = BrowserView.newInstance(browser);
        frame = new JFrame("VK");
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(1280, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        browser.navigation().loadUrl("https://oauth.vk.com/authorize?client_id=8203886&display=page&redirect_uri=https://oauth.vk.com/blank.html.&scope=friends&response_type=token&v=5.59");
    }
}
