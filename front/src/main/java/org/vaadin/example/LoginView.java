package org.vaadin.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@AnonymousAllowed
@CssImport("./themes/my-theme/login.css")
public class LoginView extends VerticalLayout {

    private TextField username;
    private PasswordField password;
    private Button loginButton;
    private Button registerButton;

    public LoginView() {
        addClassName("login-content");
        // Configuración del layout para centrar el contenido
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Título
        H1 title = new H1("Login");

        // Campos de entrada
        username = new TextField("Username");
        username.setRequiredIndicatorVisible(true);
        password = new PasswordField("Password");
        password.setRequiredIndicatorVisible(true);

        // Botón de login
        loginButton = new Button("Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClassName("button");

        // Botón para ir al registro
        registerButton = new Button("¿No tienes cuenta? Regístrate");
        registerButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        registerButton.addClickListener(e -> UI.getCurrent().navigate("register"));

        // Agregar componentes al layout
        add(title, username, password, loginButton, registerButton);

        // Lógica de login (demo)
        loginButton.addClickListener(e -> {
            // Validación simple: si username y password son "admin"
            if ("admin".equals(username.getValue()) && "admin".equals(password.getValue())) {
                Notification notification = Notification.show("Login exitoso");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                // Redirige a la vista principal o dashboard (en este ejemplo se navega a la raíz)
                UI.getCurrent().navigate("");
            } else {
                Notification notification = Notification.show("Credenciales inválidas");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });
    }
}
