
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
    Integer idCounter = 1000;

    Map<Integer, Product> mevcutUrunler = new HashMap<>();

    //----------------------------ÜRÜN TANIMLAMA   --Ertuğrul H.----------------------------//

    public void urunTanimlama() {

        String urunIsmi = Utils.bosGec("--Lütfen Ürünün İsmini Giriniz: ");
        String uretici = Utils.bosGec("--Lütfen Üretici İsmi Giriniz: ");


        boolean urunBulunduMu = false;

        for (Map.Entry<Integer, Product> entry : mevcutUrunler.entrySet()) {
            Product product = entry.getValue();
            int id = entry.getKey();

            if (product.getUrunIsmi().equalsIgnoreCase(urunIsmi) && product.getUretici().equalsIgnoreCase(uretici)) {
                System.out.println("Bu ürün " + id + " id numarası ile zaten mevcut.");
                urunBulunduMu = true;
                break;
            }
        }

        if (!urunBulunduMu) {


            String birim = Utils.bosGec("--Lütfen Ürün Birimini Giriniz: ");

            mevcutUrunler.put(idCounter, new Product(idCounter, urunIsmi, uretici, birim));
            System.out.println("--Ürün Başarıyla Tanimlandi.-- \u2705");
            idCounter++;

        }
        urunListele();
    }

    //----------------------------ÜRÜN GİRİŞİ   --Hatice H.---------------------------------//

    public void urunGirisi() {
        Utils utils = new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) {
            return; // Depoda ürün yoksa ana menüye dön
        }

        int id = Utils.gecerliUrunIdAl(mevcutUrunler, "--İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");
        Product product = mevcutUrunler.get(id);

        // Pozitif miktar alınana kadar miktar sorma işlemi Utils'teki metotta yapılacak
        int eklenecekMiktar = Utils.gecerliPozitifMiktarAl("--Eklemek istediğiniz miktarı giriniz: ");

        // Miktarı güncelle
        product.setMiktar(product.getMiktar() + eklenecekMiktar);
        System.out.println("Güncel ürün miktarı: " + product.getMiktar());

        urunListele();
    }

    //----------------------------ÜRÜN LİSTELE   --Ahsen H.---------------------------------//

    public void urunListele() {

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

    //----------------------------ÜRÜN RAFA KOYMA   --Kerim H.-------------------------------//

    public void urunRafakoyma() {
        Utils utils = new Utils();

        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön

        Product product = null;
        int id;
        boolean gecerliUrunID = false;

        // Ürün ID'si geçerli olana kadar sor
        do {
            id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün ID numarasını giriniz: ");
            if (mevcutUrunler.containsKey(id)) {
                product = mevcutUrunler.get(id);
                gecerliUrunID = true; // Geçerli ID bulundu, döngüden çık
            } else {
                System.out.println("--Geçersiz ürün ID'si. Lütfen geçerli bir ID giriniz.--");
            }
        } while (!gecerliUrunID);

        // Ürünün zaten bir raf numarası varsa, işlemi sonlandır
        if (product.getRaf() != null && !product.getRaf().isEmpty()) {
            System.out.println("Ürünün zaten bir raf numarası var: " + product.getRaf());
            return;
        }

        String yeniRafStr;
        int yeniRaf;
        boolean gecerliRafNumarasi = false;

        // Raf numarası geçerli olana kadar sor
        do {
            System.out.println("Lütfen raf numarasını giriniz (100 ile 999 arasında): ");
            yeniRafStr = input.nextLine().trim();

            try {
                yeniRaf = Integer.parseInt(yeniRafStr);

                if (yeniRaf >= 100 && yeniRaf <= 999) {
                    String finalYeniRafStr = yeniRafStr;
                    boolean rafDolu = mevcutUrunler.values().stream()
                            .anyMatch(p -> finalYeniRafStr.equals(p.getRaf()));

                    if (!rafDolu) {
                        product.setRaf(yeniRafStr);
                        System.out.println("Ürün başarıyla " + yeniRaf + " nolu rafa yerleştirildi.");
                        gecerliRafNumarasi = true; // Geçerli raf numarası girildi, döngüden çık
                    } else {
                        System.out.println("--Bu raf numarası başka bir ürün tarafından kullanılmaktadır.--");
                    }
                } else {
                    System.out.println("--Geçersiz raf numarası! Lütfen 100 ile 999 arasında bir sayı giriniz.--");
                }
            } catch (NumberFormatException e) {
                System.out.println("--Geçersiz raf numarası! Lütfen sayısal bir değer giriniz.--");
            }
        } while (!gecerliRafNumarasi);

        urunListele(); // Güncel listeyi göster
    }

    //----------------------------ÜRÜN ÇIKIŞI ------Yuşa H.----------------------------------//

    public void urunCikisi() {
        Utils utils = new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön

        int id = Utils.gecerliUrunIdAl(mevcutUrunler, "--İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");
        Product product = mevcutUrunler.get(id);

        System.out.println(id + " id numaralı " + product.getUrunIsmi() + " " + product.getMiktar() + " " + product.getBirim() + " mevcuttur.");

        // Pozitif miktar alımı için Utils'teki metodu kullanıyoruz
        int cikisMiktari = Utils.gecerliPozitifMiktarAl("Çıkış yapmak istediğiniz miktarı yazınız: ");

        // Mevcut miktar kontrolü
        if (product.getMiktar() >= cikisMiktari) {
            product.setMiktar(product.getMiktar() - cikisMiktari); // Çıkış işlemi yapılıyor
            System.out.println("Çıkış işlemi başarıyla gerçekleştirildi.");
        } else {
            System.out.println("Hata: Çıkış miktarı mevcut miktardan fazla olamaz!");
        }

        urunListele();
    }

    //----------------------------ÜRÜN GÜNCELLE   --Esra H.----------------------------------//

    public void urunuGuncelle() {
        Utils utils = new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön
        int id = Utils.gecerliUrunIdAl(mevcutUrunler, "--İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

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
            Integer yeniRaf = Utils.intAralikKontrolu("Yeni Raf (güncellenmeyecekse boş bırakın, 100 ile 999 arasında olmalı): ", 100, 999);

            if (yeniRaf != null) {
                // Aynı raf numarasına sahip başka bir ürün varsa, onun rafını null yap
                mevcutUrunler.values().forEach(p -> {
                    if (yeniRaf.toString().equals(p.getRaf()) && p != product) {
                        p.setRaf(null); // Önceki ürünün raf numarasını iptal ediyoruz
                    }
                });

                // Yeni raf numarasını güncellenecek ürüne atayın
                product.setRaf(yeniRaf.toString());
            }



            System.out.println("--Ürün bilgileri başarıyla güncellendi.--");
        } else {
            System.out.println("--Bu ID numarası ile bir ürün bulunamadı.--");

        }

        urunListele(); // Güncellenmiş ürün listesini göster
    }

    //----------------------------ÜRÜN ARAMA   --Alper H.------------------------------------//

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
                System.out.println("--Ana menüye donuluyor...--");
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
                    System.out.println("--Lütfen Miktar Sınırını Giriniz--");
                    try {
                        int miktarUstSinir = Integer.parseInt(input.nextLine().trim());
                        aranan = mevcutUrunler.values().stream().filter(t -> t.getMiktar() <= miktarUstSinir);
                    } catch (NumberFormatException e) {
                        System.out.println("--Geçersiz veya boş giriş! Lütfen sayısal bir değer giriniz.--");
                    }
                    break;
                case 4:
                    System.out.println("--Lutfen Aranacak Raf Numarasini Giriniz--");
                    String aranacakRaf = input.nextLine();
                    aranan = mevcutUrunler.values().stream()
                            .filter(t -> t.getRaf() != null && t.getRaf().equalsIgnoreCase(aranacakRaf));
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
