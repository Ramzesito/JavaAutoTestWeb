package ru.netology.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CallbackTest {

    @Test
    public void shouldTestSubmitForm() throws InterruptedException {
        Configuration.headless = true;
        open("http://localhost:9999");
        $(By.cssSelector("[data-test-id=name] input")).setValue("Василий Петров");
        $(By.cssSelector("[data-test-id=phone] input")).setValue("+79876543210");
        $(By.cssSelector("[data-test-id=agreement]")).click();
        $(By.className("button")).click();
        String gotText = $(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        Assertions.assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", gotText);

        //Thread.sleep(5000);
    }
}
