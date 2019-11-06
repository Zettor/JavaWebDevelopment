import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HamletInternational {



    public static void main(String[] args) {
        System.out.println("1 — английский \n 2 — русский");

        char i = 0;
        try {
            i = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "UK";
        String language = "en";
        switch (i) {
            case '1':
                country = "UK";
                language = "en";
                break;
            case '2':
                country = "RU";
                language = "ru";
                break;
        }

        Locale current = new Locale(language, country);


        ResourceBundle rb = ResourceBundle.getBundle("properties.text", current);
        String s1 = rb.getString("str1");
        System.out.println("s1 = " + s1);

            String str2 = rb.getString("str2");
            System.out.println("coorectStr = " + str2);

        try {
            String s = new String(rb.getString("str2").getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException newE) {
            newE.printStackTrace();
        }
        //String s2 = rb.getString("str2");
        //System.out.println(s2);
    }
}
