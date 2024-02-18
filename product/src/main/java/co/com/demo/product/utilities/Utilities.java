package co.com.demo.product.utilities;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utilities {


    public static final String LAND = "TERRESTRE";
    public static final String MARITIME = "MARITIMA";
    private static final String ALFANUMERICOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String id() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9);
    }

    public static boolean vehicleNumberValidate(String number) {
        return number.matches("^[A-Za-z]{3}\\d{3}$");
    }

    public static boolean shipNumberValidate(String number) {
        return number.matches("^[A-Za-z]{3}\\d{4}[A-Za-z]$");
    }

    public static String codeGenerate() {
        return IntStream.range(0, 10)
                .map(i -> random.nextInt(ALFANUMERICOS.length()))
                .mapToObj(ALFANUMERICOS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
