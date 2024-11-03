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

    public static String urunFormatlama(Product product) {
        return String.format("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s",
                product.getIdCounter(), product.getUrunIsmi(), product.getUretici(),
                product.getMiktar(), product.getBirim(), product.getRaf());
    }

//    public static boolean bosGecilemez(String str){
//        if(str==null){
//            System.out.println("Bu alan boş geçilemez! ");
//        }
//        return false;
//    }


    // Boş girdi kontrolü
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();

    }
    public static String bosGecılma(String mesaj) {
        Scanner input = new Scanner(System.in);
        String kullaniciGirisi = "";
        while (kullaniciGirisi.isEmpty()) {
            System.out.print(mesaj);
            kullaniciGirisi = input.nextLine().trim();
            if (kullaniciGirisi.isEmpty()) {
                System.out.println("Hata: Bu alan boş olamaz. Lütfen geçerli bir giriş yapınız.");
            }
        }
        return kullaniciGirisi;
    }




}
