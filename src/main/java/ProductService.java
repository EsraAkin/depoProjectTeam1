import java.util.*;

public class ProductService {

    Scanner input = new Scanner(System.in);
    String urunIsmi;
    String uretici;
    String birim;
    String raf;
    Integer idCounter = 1000;
    int miktar = 0;
    Map<Integer, Product> mevcutUrunler = new HashMap<>();

    //ÜRÜN TANIMLAMA   --Ertuğrul H.

    public void urunTanimlama() {

        System.out.println("Lütfen Ürünün İsmini Giriniz");
        urunIsmi = input.nextLine();
        System.out.println("Lütfen Üretici İsmi Giriniz");
        uretici = input.nextLine();

        boolean urunBulunduMu = false;

        for (Map.Entry<Integer, Product> entry : mevcutUrunler.entrySet()) {
            Product product = entry.getValue();
            int id = entry.getKey();

            if (product.getUrunIsmi().equalsIgnoreCase(urunIsmi) && product.getUretici().equalsIgnoreCase(uretici)) {
                System.out.println("Bu ürün" + id + " ile zaten mevcut.");
                urunBulunduMu = true;
                break;
            }
        }
        if (!urunBulunduMu) {

            System.out.println("Lütfen Ürün birimini giriniz :");
            birim = input.nextLine();

            mevcutUrunler.put(idCounter, new Product(idCounter, urunIsmi, uretici, miktar, birim, null));

            System.out.println("Ürün başarıyla eklendi: ");
            idCounter++;

        }

        urunListele1();
    }

    public void urunGirisi() {

        System.out.println("Miktar güncellemek için Id'yi giriniz :");
        int id = input.nextInt();

        if (mevcutUrunler.containsKey(id)) {
            Product product = mevcutUrunler.get(id);
            System.out.println("Eklemek istediğiniz miktarı giriniz : ");
            int eklenacekMiktar = input.nextInt();

            //Miktar güncelle
            product.setMiktar(product.getMiktar() + eklenacekMiktar);
            System.out.println("Güncel ürün miktarı : " + product.getMiktar());

        } else {
            System.out.println("Geçersiz ürün id'si.");
        }

        urunListele1();
    }

    public void urunListele1() {

        System.out.printf("%10s %10s %10s %10s %10s %10s%n", "ID", "İsim", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("----------------------------------------------------------------");
        Set<Map.Entry<Integer, Product>> mevUrunList = mevcutUrunler.entrySet();
        for (Map.Entry<Integer, Product> entry : mevUrunList) {
            Product product = entry.getValue();


            Product value = entry.getValue();
            System.out.printf("%10s %10s %10s %10s %10s %10s%n\n", product.getIdCounter(), value.getUrunIsmi(), value.getUretici(), value.getMiktar(), value.getBirim(), value.getRaf());

        }
    }

    //ÜRÜN LİSTELEME   --Ahsen H.

    //ÜRÜN GİRİŞİ      --Hatice Angılcı.
    //RAFA KOYMA       --Kerim H.
    //ÜRÜN ÇIKIŞI      --Yuşa H.
    //GÜNCELLEME       --ALPER h. Esra AKINEDEN
    //ARAMA            --Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...
    public void urunuGuncelle() {
        if (!urunKontrol()) return; // Depoda ürün yoksa ana menüye dön


        Utils utils = new Utils();

        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

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
                product.setRaf(yeniRaf);
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

}

