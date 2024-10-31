import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
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

    Integer idCounter=1;
    Map<Integer, Product> mevcutUrunler=new HashMap<>();



    private Random random = new Random();

    private String[] urunIsimleri = {"Un", "Şeker", "Çay", "Pirinç", "Yağ", "Süt", "Ekmek", "Et", "Sebze", "Meyve"};
    private String[] ureticiler = {"Firma A", "Firma B", "Firma C", "Firma D", "Firma E"};
    private String[] birimler = {"Unit"};

    public ProductService() {
        mevcutUrunler = new HashMap<>(); //urunler Map’i tüm ürünleri ID’leriyle saklar
        for (int i = 0; i < 20; i++) {
            String randomUrunIsmi = urunIsimleri[random.nextInt(urunIsimleri.length)];
            String randomUretici = ureticiler[random.nextInt(ureticiler.length)];
            String randomBirim = birimler[random.nextInt(birimler.length)];

            //urunTanimlama(randomUrunIsmi, randomUretici, randomBirim);
        }

    }

    // Ürün listeleme
    public void urunListele() {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%5s %10s %10s %8s %10s %10s\n", "ID", "İsim", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("---------------------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for (Map.Entry<Integer, Product> entry : mevcutUrunler.entrySet()) {
            i++;
            int key = entry.getKey();
            Product value = entry.getValue();
            System.out.println(value);
            if(i%10==0){

                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
        }
    }


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
    //ÜRÜN GİRİŞİ      --Hatice Angılcı.
    //RAFA KOYMA       --Kerim H.
    //ÜRÜN ÇIKIŞI      --Yuşa H.
    //GÜNCELLEME       --ALPER h. Esra AKINEDEN
    //ARAMA            --Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...


    }
