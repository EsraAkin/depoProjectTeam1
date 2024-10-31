import java.util.HashMap;
import java.util.Map;
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


    // Ürün girişi yapma metodu
    public static void urunGirisi(int id, int eklenenMiktar) {
        Product urunIsmi = urunIsmi.get(id); // Ürünü ID'sine göre bul
        if (urunIsmi != null) {
            urunIsmi.setMiktar(urunIsmi.getMiktar() + eklenenMiktar); // Miktarı güncelle
        }
    }





    //ÜRÜN TANIMLAMA   --Ertuğrul H.
    //ÜRÜN LİSTELEME   --Ahsen H.
    //ÜRÜN GİRİŞİ      --Hatice
    //RAFA KOYMA       --Kerim H.
    //ÜRÜN ÇIKIŞI      --Yuşa H.
    //GÜNCELLEME       --ALPER h. eSRA
    //ARAMA            --Lambda


}
