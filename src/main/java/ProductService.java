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

    public void urunGirisi(int idCounter){
        System.out.print("Giriş yapmak istediğiniz ürünün ID'sini girin: ");
        int id = input.nextInt();

        System.out.print("Giriş miktarını girin: ");
        int miktar = input.nextInt();
        input.nextLine(); // Newline consumation

        Product urunIsmi = null;
        if (Product.containsKey(idCounter)) {
            urunIsmi .getUrunIsmi()urunIsmi.getIdCounter(int id);
            urunIsmi.setMiktar(urunIsmi.getMiktar() + miktar);
            System.out.println("Ürün girişi başarıyla yapıldı!");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }

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
