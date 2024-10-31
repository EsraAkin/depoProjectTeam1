import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ProductService {

    Scanner input=new Scanner(System.in);
    String urunIsmi;
    String uretici;
    String birim;
    int miktar;
    String raf;

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
    //ÜRÜN LİSTELEME   --Ahsen H.
    //ÜRÜN GİRİŞİ      --Hatice Angılcı.
    //RAFA KOYMA       --Kerim H.
    //ÜRÜN ÇIKIŞI      --Yuşa H.
    //GÜNCELLEME       --ALPER h. Esra AKINEDEN
    //ARAMA            --Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...

}
