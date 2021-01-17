import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class ExampleTest {

    @Test
    public void verifyForm() throws Exception {
        FileInputStream credFile = new FileInputStream(".\\src\\test\\resources\\credentials.properties");
        Properties credentials = new Properties();
        credentials.load(credFile);
        Configuration.browser = "chrome";
        open("https://todoist.com/users/showlogin");
        $("[name='email']").setValue(credentials.getProperty("user"));
        $("#password").setValue(credentials.getProperty("password"));
        $(".sel_login").click();
        $("#left_menu").waitUntil(Condition.appear, 5000);
        SelenideElement leftMenu = $("#left_menu #top_filters");
        System.out.println($$("li").texts());
        System.out.println(leftMenu.$$("li").texts());
    }
}
