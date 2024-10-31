import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProductService {

    Scanner input = new Scanner(System.in);
    String urunIsmi;
    String uretici;
    String birim;

    String raf;

    Integer idCounter = 1000;
    int miktar = 0;
    static Map<Integer, Product> mevcutUrunler = new HashMap<>();


    //ÜRÜN TANIMLAMA   --Ertuğrul H.
    public void urunTanımlama() {


        Integer id = idCounter; // ID^yi otomatik arttırır.
        idCounter++;

        System.out.println("Lütfen Ürünün İsmini Giriniz");
        String ürünİsmi = input.nextLine();

        System.out.println("Lütfen Üretici İsmi Giriniz");
        String üreticiİsmi = input.nextLine();

        System.out.println("Lütfen Ürünün Birimini Giriniz");
        String ürünBirimi = input.nextLine();

        while (true) {
            System.out.println("Lütfen Ürün Miktarını Giriniz:");
            try {
                miktar = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Yanlış Giriş Yaptınız Sayı Girmelisiniz !");
                input.nextLine();
            }
        }

        System.out.println("Lütfen Raf İsmini Giriniz");
        String rafİsim = input.nextLine();

        Product yeniUrun = new Product(id, ürünİsmi, üreticiİsmi, miktar, ürünBirimi, rafİsim);
        mevcutUrunler.put(id, yeniUrun);

        System.out.println("Ürün başarıyla eklendi: ");


        }
        //ÜRÜN LİSTELEME   --Ahsen H.
        //ÜRÜN GİRİŞİ      --Hatice HHHHHHHHHHH
        //RAFA KOYMA       --Kerim H.
        //ÜRÜN ÇIKIŞI      --Yuşa H.
        //GÜNCELLEME       --ALPER h. eSRA eeee
        //ARAMA            --Lambda


    }
