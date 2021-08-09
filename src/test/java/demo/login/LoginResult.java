package demo.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class LoginResult {
    public static Question<String> userInfo() {
        return actor -> TextContent.of(MenuHeader.USER_INFO).viewedBy(actor).asString();
    }

}
