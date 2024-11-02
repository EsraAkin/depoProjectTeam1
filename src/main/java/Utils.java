import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    //---------------------------int yerine string exception metodu----------------------
    public int intGirisAl(String mesaj) {
        Scanner input = new Scanner(System.in);
        int sayi;

        while (true) {
            System.out.print(mesaj);
            try {
                sayi = input.nextInt();
                input.nextLine(); // Buffer temizliği
                return sayi; // Başarılı giriş yapılmışsa döndür
            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! Lütfen bir tam sayı giriniz.");
                input.nextLine(); // Hatalı girdiyi temizle
            }
        }


    }
    //---------------------------int yerine string exception metodu----------------------

    public class Utils1 {
        public static boolean urunKontrol(Map<Integer, Product> mevcutUrunler) {
            if (mevcutUrunler.isEmpty()) {
                System.out.println("Depoda henüz tanımlanmış bir ürün yok! Lütfen önce bir ürün tanımlayın.");
                return false; // Depoda ürün yoksa false döner
            }
            return true; // Depoda ürün varsa true döner
        }


    }

    public static String capitalize(String inputString) {

        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }

        return inputString.substring(0, 1).toUpperCase() + inputString.substring(1);

    }

}
