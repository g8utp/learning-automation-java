package swagTests.utils;

import com.github.javafaker.Faker;
import swagTests.api.models.UserData;

import java.util.Locale;

public class UserDataFactory extends UserData {
    public static final Faker faker = new Faker(new Locale("en"));

    public static UserData getRandomUser() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String zip = faker.address().zipCode();
return new UserData(firstName, lastName, zip);
    }
}
