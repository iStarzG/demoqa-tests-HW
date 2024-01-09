package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
        System.out.println("\n\n### @BeforeAll\n");


    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n### @AfterAll\n\n");
    }
    @Test
    void demoQATests() {
        open("/automation-practice-form"); // Открытие браузера с нужной ссылкой
        executeJavaScript("$('#fixedban').remove()");//Скрытие рекламы
        executeJavaScript("$('footer').remove()");// Скрытие футера
        $("#firstName").setValue("Kirill");  //Указываем значение поля имя
        $("#lastName").setValue("Mironov");  //Указываем значение поля фамилия
        $("#userEmail").setValue("kiryamironov@mail.ru");  //Указываем значение поля емайл
        $("label[for='gender-radio-3']").click();  //Выбираем пол "other"
        $("#userNumber").setValue("8800535353");  //Указываем значение поля номер телефона
        $("#dateOfBirthInput").click();   //Нажимаем на кнопку выбора даты рождения
        $("[class=react-datepicker__month-select]").click();  //Нажимаем на кнопку выбора месяца
        $(new ByText("September")).click(); //Указываем сентябрь
        $("[class=react-datepicker__year-select]").click(); //Нажимаем на кнопку выбора года рождения
        $(new ByText("2000")).click(); //Указываем 2000 год
        $("[class=react-datepicker__year-select]").click(); //Нажимаем на выбор числа
        $("[class=react-datepicker]").shouldHave(text("6")).click(); //Нажимаем на число 6
        $("#subjectsInput").setValue("e").sendKeys(Keys.ENTER); //Указываем English
        $("label[for='hobbies-checkbox-1']").click(); // Отмечаем хобби Sports
        $("label[for='hobbies-checkbox-2']").click(); // Отмечаем хобби Reading
        $("label[for='hobbies-checkbox-3']").click(); // Отмечаем хобби Music
        $("#uploadPicture").uploadFromClasspath("1.jpeg"); // Загружаем картинку с именем "1.jpeg"
        $("#currentAddress").setValue("Nigeria"); // Указываем адрес Nigeria
        $("#react-select-3-input").setValue("Haryana").sendKeys(Keys.ENTER); // Указываем страну Haryana
        $("#react-select-4-input").setValue("Karnal").sendKeys(Keys.ENTER); // Указываем город Karnal
        $("#submit").click(); // Нажимаем кнопку submit




        $(".modal-open").shouldBe(visible); // Проверка открытия окна с данными
        $(".table").shouldHave(text("Student Name Kirill Mironov")); // Проверка имени, фамилии
        $(".table").shouldHave(text("Student Email kiryamironov@mail.ru")); // Проверка емайла
        $(".table").shouldHave(text("Gender Other")); // Проверка пола "other"
        $(".table").shouldHave(text("Mobile 8800535353")); // Проверка номера телефона
        $(".table").shouldHave(text("Date of Birth 06 September,2000")); // Проверка даты рождения
        $(".table").shouldHave(text("Subjects English")); // Проверка субъекта
        $(".table").shouldHave(text("Hobbies Sports, Reading, Music")); // Проверка хобби
        $(".table").shouldHave(text("Picture 1.jpeg")); // Проверка загрузки картинки с именем "1.jpeg"
        $(".table").shouldHave(text("Address Nigeria")); // Проверка адреса
        $(".table").shouldHave(text("State and City Haryana Karnal")); // Проверка страны и города

    }
}
