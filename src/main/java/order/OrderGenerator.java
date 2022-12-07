package order;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class OrderGenerator {


    static String firstName = RandomStringUtils.randomAlphabetic(4);
    static String lastname = RandomStringUtils.randomAlphabetic(4);
    static String address = RandomStringUtils.randomAlphabetic(4);
    static String metroStation = RandomStringUtils.randomNumeric(1);
    static String rentTime = RandomStringUtils.randomNumeric(1);
    static String phone = "+7" + RandomStringUtils.randomNumeric(10);
    static String day = "2022-12-" + new Random().nextInt(31);
    static String comment = "Saske, come back to Konoha";


    public static Order getWithBlack() {
        return new Order(firstName, lastname, address, metroStation, phone, rentTime, day, comment, new String[]{"BLACK"});
    }

    public static Order getWithGrey() {
        return new Order(firstName, lastname, address, metroStation, phone, rentTime, day, comment, new String[]{"GREY"});
    }

    public static Order getWithBlackAndGrey() {
        return new Order(firstName, lastname, address, metroStation, phone, rentTime, day, comment, new String[]{"BLACK", "GREY"});
    }

    public static Order getWithoutColours() {
        return new Order(firstName, lastname, address, metroStation, phone, rentTime, day, comment, null);
    }
}
