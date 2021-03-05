import java.util.Objects;
import java.util.stream.Stream;

public class JavaStreams {
    static int a = 9;
    static class Product {
        String status;
    }

    public static void test(Stream<Product> products) {
        products = products.filter(Objects::nonNull).filter(p -> p.status.equalsIgnoreCase("invalid"));
        products = products.filter(p -> p.status.equalsIgnoreCase("invalid"));
        products = products.skip(10);
        products = products.limit(20);
    }

    public static void main(String[] args) {
        try {
            a++;
            // success
        } catch (Exception exc) {
            if (exc instanceof RuntimeException) {
                // unchecked
            } else {
                // checked
            }
        } catch (Error e) {
            // error
        }
    }
}
