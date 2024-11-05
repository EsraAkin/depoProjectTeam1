import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    //---------------------------int yerine string girilmesi durumunda exception metodu----------------------
    public int intGirisAl(String mesaj) {
        Scanner input = new Scanner(System.in); // Her çağrıda yeni Scanner başlat
        int sayi;

        while (true) {
            System.out.print(mesaj);
            try {
                String girdi = input.nextLine(); // nextLine ile tam girdi al
                sayi = Integer.parseInt(girdi); // Tam sayıya dönüştür
                return sayi;
            } catch (NumberFormatException e) {
                System.out.println("--Hatalı giriş! Lütfen geçerli bir değer giriniz.--");
            }
        }
    }

    //--------------------Map List boş mu kontrolü------------------------------
    public class Utils1 {
        public static boolean urunKontrol(Map<Integer, Product> mevcutUrunler) {
            if (mevcutUrunler.isEmpty()) {
                System.out.println("--Depoda henüz tanımlanmış bir ürün yok! Lütfen önce bir ürün tanımlayın.--");
                return false; // Depoda ürün yoksa false döner
            }
            return true; // Depoda ürün varsa true döner
        }
    }

    //--------------------Listi formatlı yazdır ----------------------------------
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

    // ------------------Boş girdi kontrolü---------------------------------
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();

    }

    public static String bosGec(String mesaj) {
        Scanner input = new Scanner(System.in);
        String kullaniciGirisi = "";
        while (kullaniciGirisi.isEmpty()) {
            System.out.print(mesaj);
            kullaniciGirisi = input.nextLine().trim();
            if (kullaniciGirisi.isEmpty()) {
                System.out.println("--Hata: Bu alan boş olamaz. Lütfen geçerli bir giriş yapınız.--");
            }
        }
        return kullaniciGirisi;
    }

    //--------------------------Alınacak inti belli aralıkta isteme-----------------------------------
    public static Integer intAralikKontrolu(String inputMesaji, int min, int max) {
        //kullanıcıdan belirli bir aralıkta bir tam sayı isteyip geçerli bir sayı alana kadar döngüye girilir.
        Scanner scanner = new Scanner(System.in);
        Integer deger = null;

        while (deger == null) {
            System.out.print(inputMesaji);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null; // Kullanıcı boş bırakırsa null döner (güncelleme yapılmaz)
            }

            try {
                int girilenDeger = Integer.parseInt(input);
                if (girilenDeger >= min && girilenDeger <= max) {
                    deger = girilenDeger;
                } else {
                    System.out.println("--Geçersiz giriş! Lütfen " + min + " ile " + max + " arasında bir değer giriniz.--");
                }
            } catch (NumberFormatException e) {
                System.out.println("--Geçersiz giriş! Lütfen sayısal bir değer giriniz.--");
            }
        }
        return deger;
    }

}
