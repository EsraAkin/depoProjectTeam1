
//ÜRÜN TANIMLAMA   --Ertuğrul H.
//ÜRÜN LİSTELEME   --Ahsen H.
//ÜRÜN GİRİŞİ      --Hatice H.
//RAFA KOYMA       --Kerim H.
//ÜRÜN ÇIKIŞI      --Yuşa H.
//GÜNCELLEME       --Esra H.
//ARAMA            --Alper H. Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...


import java.util.*;
import java.util.stream.Stream;

public class ProductService {


    Scanner input = new Scanner(System.in);
    String urunIsmi;
    String uretici;
    String birim;
    String raf;
    Integer idCounter = 1000;
    int miktar = 0;
    Map<Integer, Product> mevcutUrunler = new HashMap<>();

    //----------------------------ÜRÜN TANIMLAMA   --Ertuğrul H.----------------------------//

    public void urunTanimlama() {

        String urunIsmi = Utils.bosGecılma("Lütfen Ürünün İsmini Giriniz: ");
        String uretici = Utils.bosGecılma("Lütfen Üretici İsmi Giriniz: ");
        String birim = Utils.bosGecılma("Lütfen Ürün Birimini Giriniz: ");


        System.out.println("Lütfen Ürünün İsmini Giriniz");
        urunIsmi = input.nextLine();

//        if (Utils.isEmpty(urunIsmi)) {
//            System.out.println("Uyarı:Bu alan boş bırakılamaz!");
//            urunTanimlama();
//        }

        System.out.println("Lütfen Üretici İsmi Giriniz");
        uretici = input.nextLine();

//        if (Utils.isEmpty(uretici)) {
//            System.out.println("Uyarı:Bu alan boş bırakılamaz!");
//            urunTanimlama();
//        }


        boolean urunBulunduMu = false;

        for (Map.Entry<Integer, Product> entry : mevcutUrunler.entrySet()) {
            Product product = entry.getValue();
            int id = entry.getKey();

            if (product.getUrunIsmi().equalsIgnoreCase(urunIsmi) && product.getUretici().equalsIgnoreCase(uretici)) {
                System.out.println("Bu ürün " + id + " ile zaten mevcut.");
                urunBulunduMu = true;
                break;
            }
        }

        if (!urunBulunduMu&&Utils.isEmpty(urunIsmi)) {

            System.out.println("Lütfen Ürün Birimini giriniz :");
            birim = input.nextLine();
            mevcutUrunler.put(idCounter, new Product(idCounter, urunIsmi, uretici, miktar, birim));
            System.out.println("Ürün Başarıyla Eklendi. ");
            idCounter++;

        }
        urunListele1();
    }


    //----------------------------ÜRÜN GİRİŞİ   --Hatice H.----------------------------//

    public void urunGirisi() {

        Utils utils = new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) {
            return; // Depoda ürün yoksa ana menüye dön
        }

        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

        if (mevcutUrunler.containsKey(id)) {
            Product product = mevcutUrunler.get(id);
            System.out.println("Eklemek istediğiniz miktarı giriniz : ");

            int eklenecekMiktar = utils.intGirisAl("");

            //  int eklenacekMiktar = input.nextInt();
            if (eklenecekMiktar <= 0) {
                System.out.println("Eklemek istediğiniz miktar sıfır ve negatif bir sayı olamaz. Lütfen tam sayı giriniz :");
            } else {
                //Miktar güncelle
                product.setMiktar(product.getMiktar() + eklenecekMiktar);
                System.out.println("Güncel ürün miktarı : " + product.getMiktar());
            }
        } else {
            System.out.println("Geçersiz ürün id'si.");
        }

        urunListele1();
    }

    //----------------------------ÜRÜN LİSTELE   --Ahsen H.----------------------------//

    public void urunListele1() {

        System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
        System.out.println("-".repeat(100));
        Set<Map.Entry<Integer, Product>> mevUrunList = mevcutUrunler.entrySet();
        for (Map.Entry<Integer, Product> entry : mevUrunList) {
            Product product = entry.getValue();


            Product value = entry.getValue();
            System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                    Utils.capitalize(product.getIdCounter().toString()),
                    Utils.capitalize(value.getUrunIsmi()),
                    Utils.capitalize(value.getUretici()),
                    Utils.capitalize(((Integer) (value.getMiktar())).toString()),
                    Utils.capitalize(value.getBirim()),
                    Utils.capitalize(value.getRaf()));

        }
    }

    //----------------------------ÜRÜN GÜNCELLE   --Esra H.----------------------------//
    public void urunuGuncelle() {

        Utils utils = new Utils();

        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön
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

        urunListele1(); // Güncellenmiş ürün listesini göster
    }

    //-----------------------Ürün Çıkışı------Yuşa H.-------------------------------------//
    public void urunCikisi() {

        Utils utils = new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön
        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

        if (mevcutUrunler.containsKey(id)) {  //Ürün varsa miktar kontrolü yapalım.
            System.out.println(id + " id numaralı " + mevcutUrunler.get(id).getUrunIsmi() + " " + mevcutUrunler.get(id).getMiktar() + " " + mevcutUrunler.get(id).getBirim() + " mevcuttur.");

            System.out.println(" Çıkış yapmak istediğiniz miktarı yazınız.");
            //  int cikisMiktari = input.nextInt();
            int cikisMiktari = utils.intGirisAl("");
            Product product = mevcutUrunler.get(id); // ID'ye göre ürünü alıyoruz
            if (cikisMiktari < 0) {
                System.out.println("Hata: Çıkış miktarı negatif olamaz!");
            } else if (mevcutUrunler.get(id).getMiktar() >= cikisMiktari) {
                product.setMiktar(product.getMiktar() - cikisMiktari); // Çıkış işlemi yapılıyor
                System.out.println("Çıkış işlemi başarıyla gerçekleştirildi.");
            } else {
                System.out.println("Hata: Çıkış miktarı mevcut miktardan fazla olamaz!");
            }

        } else {
            System.out.println("Bu id numarası ile ürün bulunamadı.");
        }
        urunListele1();
    }

    //----------------------------ÜRÜN RAFA KOYMA   --Kerim H.----------------------------//
    public void urunRafakoyma() {
        Utils utils = new Utils();

        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön

        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

        if (mevcutUrunler.containsKey(id)) {
            Product product = mevcutUrunler.get(id);

            if (product.getRaf() != null && !product.getRaf().isEmpty()) {
                System.out.println("Ürünün zaten bir raf numarası var: " + product.getRaf());
                return;
            }

            System.out.println("Lütfen raf numarasını giriniz (100 ile 999 arasında): ");

            // Eğer burada sayı alacaksanız, buffer temizliğini sağlayın
            String yeniRafStr = input.nextLine().trim(); // nextInt'ten sonra kullanıyorsanız buffer temizliği önemli

            try {
                int yeniRaf = Integer.parseInt(yeniRafStr);

                if (yeniRaf >= 100 && yeniRaf <= 999) {
                    boolean rafDolu = mevcutUrunler.values().stream()
                            .anyMatch(p -> yeniRafStr.equals(p.getRaf()));

                    if (!rafDolu) {
                        product.setRaf(yeniRafStr);
                        System.out.println("Ürün başarıyla " + yeniRaf + " nolu rafa yerleştirildi.");
                    } else {
                        System.out.println("Bu raf numarası başka bir ürün tarafından kullanılmaktadır.");
                    }
                } else {
                    System.out.println("Geçersiz raf numarası! Lütfen 100 ile 999 arasında bir sayı giriniz.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz raf numarası! Lütfen sayısal bir değer giriniz.");
            }
        } else {
            System.out.println("Geçersiz ürün ID'si. Lütfen geçerli bir ID giriniz.");
        }

        urunListele1(); // Güncel listeyi göster
    }


    //----------------------------ÜRÜN ARAMA   --Alper H.----------------------------//


    public void urunArama() {

        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) {
            System.out.println("--Depoda ürün olmadığı için ana menüye dönüyorsunuz.--");
            return; // Depoda ürün yoksa ana menüye dön
        }
        boolean devam = true;
        while (devam) {
            System.out.println("----Lutfen Arama Turunu Seciniz----");
            System.out.println("1-Urun Ismi ile Arama");
            System.out.println("2-Uretici Ismi ile Arama");
            System.out.println("3-Miktar Altindaki Urunleri Arama");
            System.out.println("4-Raf Numarasi ile Arama");
            System.out.println("0-Ana Menüye Dön");

            int secim = input.nextInt();
            input.nextLine();

            if (secim == 0) {
                System.out.println("Ana menüye donuluyor...");
                devam = false;
                continue;
            }
            Stream<Product> aranan = Stream.empty();


            switch (secim) {
                case 1:
                    System.out.println("--Lutfen Aranacak Urun Ismini Giriniz--");
                    String aranacakIsim = input.nextLine();
                    aranan = mevcutUrunler.values().stream()
                            .filter(t -> t.getUrunIsmi().equalsIgnoreCase(aranacakIsim));
                    break;
                case 2:
                    System.out.println("--Lutfen Aranacak Urun Ureticisini Giriniz--");
                    String aranacakUretici = input.nextLine();
                    aranan = mevcutUrunler.values().stream().filter(t -> t.getUretici().equalsIgnoreCase(aranacakUretici));
                    break;
                case 3:
                    System.out.println("--Lutfen Miktar Sinirini Giriniz--");
                    int miktarUstSinir = input.nextInt();
                    aranan = mevcutUrunler.values().stream().filter(t -> t.getMiktar() <= miktarUstSinir);
                    break;
                case 4:
                    System.out.println("--Lutfen Aranacak Raf Numarasini Giriniz--");
                    String aranacakRaf = input.nextLine();
                    aranan = mevcutUrunler.values().stream()
                            .filter(t -> t.getRaf().equalsIgnoreCase(aranacakRaf));
                    break;
                default:
                    System.out.println("--Gecersiz bir secim yaptiniz. Lutfen 0 ile 4 arasinda bir sayi giriniz.--");
                    return;
            }
            System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                    "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
            System.out.println("-".repeat(95));


            int urunSayisi = (int) aranan.peek(product -> System.out.println(Utils.urunFormatlama(product))).count();
            if (urunSayisi == 0) {
                System.out.println("--Aradığınız kriterlere uygun ürün bulunamadı.--");
            }
            System.out.println("--Aramanız tamamlandı. Teşekkür ederiz!--");

        }
    }

}
