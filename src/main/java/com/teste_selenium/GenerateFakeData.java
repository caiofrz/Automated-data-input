import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class GenerateFakeData {

    public static void main(String[] args) {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        Faker faker = new Faker(new Locale("pt-BR"));

        File data = new File("data.txt");

        final String sobrenome = "Caio Ikaro"; 

        try {
            FileWriter writer = new FileWriter(data);

            for (int i = 0; i < 100; i++) {
                String nome = faker.name().firstName();
                String email = faker.internet().emailAddress();
                String address = faker.address().streetAddress();
                String address2 = faker.address().secondaryAddress();
                String city = faker.address().city();
                String state = faker.address().state();
                String zipcode = faker.address().zipCode();
                String country = faker.address().country();
                String telefone = faker.phoneNumber().cellPhone();
                String birthday = faker.date().birthday().toString();

                writer.write(nome + "," + sobrenome + "," + email + "," + address + "," + address2 + "," + city + "," + state + "," + zipcode + "," + country + "," + telefone + "," + birthday + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Dados gerados e salvos em data.txt");
    }
}
