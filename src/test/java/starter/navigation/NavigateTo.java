package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.login.LoginPage;

public class NavigateTo {

    public static Performable theLoginPage() {
        return Task.where("{0} opens the Login page",
                Open.browserOn().the(LoginPage.class)
        );
    }

}