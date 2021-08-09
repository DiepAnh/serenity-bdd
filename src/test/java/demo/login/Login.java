package demo.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login {

    public static Performable withInfo(String username, String password) {
        return Task.where("{0} login to system",
                Enter.theValue(username).into(LoginForm.INPUT_USERNAME),
                Enter.theValue(password).into(LoginForm.INPUT_PASSWORD),
                Click.on(LoginForm.BT_LOGIN)
        ).with("username").of(username).with("password").of(password);
    }

}
