package VK;

import Managers.CommandManager;
import Visual.MainMenu;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.net.HttpHeader;
import com.teamdev.jxbrowser.net.Network;
import com.teamdev.jxbrowser.net.UrlRequest;
import com.teamdev.jxbrowser.net.UrlRequestStatus;
import com.teamdev.jxbrowser.net.callback.ReceiveHeadersCallback;
import com.teamdev.jxbrowser.net.event.RedirectResponseCodeReceived;
import com.teamdev.jxbrowser.net.event.RequestCompleted;
import com.teamdev.jxbrowser.net.event.ResponseStarted;
import com.teamdev.jxbrowser.profile.Profile;
import com.teamdev.jxbrowser.profile.Profiles;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


import javax.swing.*;

import static Visual.EnterVisual.UserName;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

//1 - https://oauth.vk.com/authorize?client_id=8203886&display=page&redirect_uri=https://oauth.vk.com/blank.html.&scope=friends&response_type=token&v=5.59
//2 - https://oauth.vk.com/authorize?client_id=8203886&redirect_uri=https%3A%2F%2Foauth.vk.com%2Fblank.html.&response_type=token&scope=2&v=5.59&state=&display=page&slogin_h=cc3b84fd6ccd210094.7f45a3302343ed5c31&__q_hash=30a2f139a2e6c7bbe660a28802494dd8
//3 - https://oauth.vk.com/blank.html#access_token=vk1.a.QdTRFnNTe_GLcwLKm9aty5fX_MLCiQZNQefDghrC71HZjAwTr_CSPefcVSM54Ps4eHr0-2EtKNwSCpVzL412kEQPZKdlqfCZaWMqd969mxdpTbJUzJlOW8PmToyuMJJfgsxOe1Y9tCuTyWps89F-jg1YOEvbDKvcn0-HcsF-s-A40sKKiFbYBJA1R46SC2St&expires_in=86400&user_id=736927086
public class VKAuth {
    Browser browser;
    JTextField addressbar;
    CommandManager cm = new CommandManager();
    ResourceBundle bundle;
    JFrame frame;

     public  VKAuth(ResourceBundle bundle) throws IOException, URISyntaxException {
        this.bundle = bundle;
        Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("").build());
        browser = engine.newBrowser();
        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);
            addressbar = new JTextField("");
            addressbar.addActionListener(e -> browser.navigation().loadUrl(addressbar.getText()));
            frame = new JFrame("VK");
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });

            frame.add(addressbar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(1280, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl("https://oauth.vk.com/authorize?client_id=8203886&display=page&redirect_uri=https://oauth.vk.com/blank.html.&scope=friends&response_type=token&v=5.59");
        });
        while (true) {
            if (browser.url().startsWith("https://oauth.vk.com/blank.html")) {
                String url = browser.url();
                UserName = url.substring(browser.url().lastIndexOf("=") + 1);
                MainMenu mainMenu = new MainMenu(cm, bundle);
                frame.setVisible(false);
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

