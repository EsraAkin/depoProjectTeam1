import java.util.HashMap;
import java.util.InputMismatchException;
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


    //ÜRÜN TANIMLAMA   --Ertuğrul H.
    //ÜRÜN LİSTELEME   --Ahsen H.
    //ÜRÜN GİRİŞİ      --Hatice Angılcı.
    //RAFA KOYMA       --Kerim H.
    //ÜRÜN ÇIKIŞI      --Yuşa H.
    //GÜNCELLEME       --ALPER h. Esra AKINEDEN
    //ARAMA            --Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...
    public void urunuGuncelle() {
        if (!urunKontrol()) return; // Depoda ürün yoksa ana menüye dön

        int id = intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

        if (mevcutUrunler.containsKey(id)) {
            Product product = mevcutUrunler.get(id);

            System.out.println("Güncellemek istemediğiniz alanları boş bırakabilirsiniz.\n");

            System.out.println("Mevcut Ürün İsmi: " + product.getUrunIsmi());
            System.out.print("Yeni Ürün İsmi (güncellenmeyecekse boş bırakın): ");
            String yeniIsim = input.nextLine();
            if (!yeniIsim.trim().isEmpty()) {
                product.setUrunIsmi(yeniIsim);
            }

            System.out.println("Mevcut Üretici: " + product.getUretici());
            System.out.print("Yeni Üretici (güncellenmeyecekse boş bırakın): ");
            String yeniUretici = input.nextLine();
            if (!yeniUretici.trim().isEmpty()) {
                product.setUretici(yeniUretici);
            }

            System.out.println("Mevcut Miktar: " + product.getMiktar());
            System.out.print("Yeni Miktar (güncellenmeyecekse boş bırakın): ");
            String yeniMiktarStr = input.nextLine();
            if (!yeniMiktarStr.trim().isEmpty()) {
                try {
                    int yeniMiktar = Integer.parseInt(yeniMiktarStr);
                    product.setMiktar(yeniMiktar);
                } catch (NumberFormatException e) {
                    System.out.println("Geçersiz giriş! Miktar bir tam sayı olmalıdır.");
                }
            }

            System.out.println("Mevcut Birim: " + product.getBirim());
            System.out.print("Yeni Birim (güncellenmeyecekse boş bırakın): ");
            String yeniBirim = input.nextLine();
            if (!yeniBirim.trim().isEmpty()) {
                product.setBirim(yeniBirim);
            }

            System.out.println("Mevcut Raf: " + product.getRaf());
            System.out.print("Yeni Raf (güncellenmeyecekse boş bırakın): ");
            String yeniRaf = input.nextLine();
            if (!yeniRaf.trim().isEmpty()) {
                product.setRaf("raf" + yeniRaf);
            }

            System.out.println("Ürün bilgileri başarıyla güncellendi.");
        } else {
            System.out.println("Bu ID numarası ile bir ürün bulunamadı.");
        }

        //urunListele(); // Güncellenmiş ürün listesini göster
    }




    //----------------------------List boşsa yardımcı metodu-----------------------------
    private boolean urunKontrol() {
        if (mevcutUrunler.isEmpty()) {
            System.out.println("Depoda henüz tanımlanmış bir ürün yok! Lütfen önce bir ürün tanımlayın.");
            return false; // Depoda ürün yoksa false döner
        }
        return true; // Depoda ürün varsa true döner
    }


    //---------------------------int yerine string exception metodu----------------------
    private int intGirisAl(String mesaj) {
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


}
