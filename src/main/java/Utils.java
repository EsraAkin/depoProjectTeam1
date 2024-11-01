import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    ProductService productService=new ProductService();

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

    //----------------------------List boşsa yardımcı metodu-----------------------------

        public static boolean urunKontrol(Map<Integer, Product> mevcutUrunler) {
            if (mevcutUrunler.isEmpty()) {
                System.out.println("Depoda henüz tanımlanmış bir ürün yok! Lütfen önce bir ürün tanımlayın.");
                return false; // Depoda ürün yoksa false döner
            }
            return true; // Depoda ürün varsa true döner

    }


}
