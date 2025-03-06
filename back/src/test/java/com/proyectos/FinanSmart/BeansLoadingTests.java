package com.proyectos.FinanSmart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest(classes = FinanSmartApplication.class)
class BeansLoadingTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testBeansAreLoaded() {
        // Imprime todos los beans registrados en Spring Boot
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

        // Verifica que la aplicación carga correctamente el contexto
        assertThat(applicationContext.getBean(FinanSmartApplication.class)).isNotNull();
    }
}
