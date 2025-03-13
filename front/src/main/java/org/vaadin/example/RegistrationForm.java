package org.vaadin.example;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;

public class RegistrationForm extends VerticalLayout {

    private TextField firstName;
    private TextField userName;
    private EmailField email;
    private PasswordField password;
    private PasswordField passwordConfirm;
    private Span errorMessageField;
    private Button submitButton;
    private Button loginButton;

    public RegistrationForm() {

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidth("100%");
        setSpacing(true);

        firstName = new TextField("Nombre");
        userName = new TextField("Username");
        email = new EmailField("Email");
        password = new PasswordField("Contraseña");
        passwordConfirm = new PasswordField("Confirmar contraseña");

        setRequiredIndicatorVisible(firstName, userName, email, password, passwordConfirm);

        errorMessageField = new Span();
        submitButton = new Button("Registrate");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submitButton.addClassName("button");

        // Botón para ir al login
        loginButton = new Button("¿Ya tienes cuenta? Login");
        loginButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        loginButton.addClickListener(e -> UI.getCurrent().navigate("login"));

        // Añade todos los componentes en orden vertical
        add(firstName, userName, email, password, passwordConfirm, errorMessageField, submitButton, loginButton);

    }

    public PasswordField getPasswordField() {
        return password;
    }

    public PasswordField getPasswordConfirmField() {
        return passwordConfirm;
    }

    public Span getErrorMessageField() {
        return errorMessageField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
