package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("register")
@CssImport("./themes/my-theme/login.css")
public class RegistrationView extends VerticalLayout {

    public RegistrationView() {
        addClassName("login-content");
        Button loginButton;
        // Igual que en LoginView
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Título principal
        H1 title = new H1("Registro");

        // Creamos el formulario (con una sola columna, sin título interno)
        RegistrationForm registrationForm = new RegistrationForm();

        // Añadimos título y formulario al layout
        add(title, registrationForm);

        // Configuramos la lógica de validación
        RegistrationFormBinder registrationFormBinder = new RegistrationFormBinder(registrationForm);
        registrationFormBinder.addBindingAndValidation();
    }
}
