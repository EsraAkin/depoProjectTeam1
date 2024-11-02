
//ÜRÜN TANIMLAMA   --Ertuğrul H.
//ÜRÜN LİSTELEME   --Ahsen H.
//ÜRÜN GİRİŞİ      --Hatice H.
//RAFA KOYMA       --Kerim H.
//ÜRÜN ÇIKIŞI      --Yuşa H.--
//GÜNCELLEME       --Esra H.
//ARAMA            --Alper H. Lambda ile ürüne-üreticiye-kalan miktara göre arama yapılacak...


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

    //----------------------------ÜRÜN TANIMLAMA   --Ertuğrul H.----------------------------//

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
                System.out.println("Bu ürün " + id + " ile zaten mevcut.");
                urunBulunduMu = true;
                break;
            }
        }
        if (!urunBulunduMu) {

            System.out.println("Lütfen Ürün birimini giriniz :");
            birim = input.nextLine();

            mevcutUrunler.put(idCounter, new Product(idCounter, urunIsmi, uretici, miktar, birim, raf));

            System.out.println("Ürün başarıyla eklendi: ");
            idCounter++;

        }
        urunListele1();
    }


    //----------------------------ÜRÜN GİRİŞİ   --Hatice H.----------------------------//

    public void urunGirisi() {

        Utils utils=new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön
        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

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

    //----------------------------ÜRÜN LİSTELE   --Ahsen H.----------------------------//

    public void urunListele1() {


//        Utils utils=new Utils();
//        Utils utils1=new Utils();
//        if (!utils1.urunKontrol())
//        {
//            System.out.println("Listede henüz ürün mevcut değil.");
//            return; // Depoda ürün yoksa ana menüye dön
//        }
//        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");

        System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
        System.out.println("-".repeat(100));
        Set<Map.Entry<Integer, Product>> mevUrunList = mevcutUrunler.entrySet();
        for (Map.Entry<Integer, Product> entry : mevUrunList) {
            Product product = entry.getValue();


            Product value = entry.getValue();
            System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                    Utils.Utils1.capitilize(product.getIdCounter().toString()),
                    Utils.Utils1.capitilize(value.getUrunIsmi()),
                    Utils.Utils1.capitilize(value.getUretici()),
                    Utils.Utils1.capitilize(((Integer)(value.getMiktar())).toString()),
                    Utils.Utils1.capitilize(value.getBirim()),
                    Utils.Utils1.capitilize(value.getRaf()));

        }
    }

    //----------------------------ÜRÜN GÜNCELLE   --Esra H.----------------------------//
    public void urunuGuncelle() {

        Utils utils=new Utils();

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

       //----------------------------ÜRÜN RAFA KOYMA   --Kerim H.----------------------------//
    public void urunRafakoyma() {

        Utils utils=new Utils();
        Utils utils1=new Utils();
        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön
        int id = utils.intGirisAl("İşlem yapmak istediğiniz ürünün id numarasını giriniz: ");


        System.out.println("rafa koymak isteğiniz ürünün ıd sini giriniz :");
        input.nextLine();



        if (mevcutUrunler.containsKey(id)) {
            Product product = mevcutUrunler.get(id);
            if (!product.getRaf().equals("null")) {
                System.out.println("ürünün zaten raf numarası " + product.getRaf() + "noya  yerleştirilmiştir");

            } else {

                System.out.println("Lütfen raf numarasını giriniz(Sadece 100 ile 999 arasında sayı giriniz) :");
                String yeniRaf12 = input.nextLine();

                try {
                    int yeniRaf=Integer.parseInt(yeniRaf12)  ;


                    if (yeniRaf >= 100 && yeniRaf <= 900) {
                        boolean rafDolu = mevcutUrunler.values().stream().anyMatch(mevcut -> mevcut.getRaf().equals(String.valueOf(yeniRaf)));


                        if (!rafDolu) {
                            product.setRaf(String.valueOf(yeniRaf));
                            System.out.println("ürün başarıyla raf" + yeniRaf + "numarasına yerleştirilmiştir");

                        } else {
                            System.out.println("bu raf numarası başka bir ürün tarafından kullanılmaktadır");

                        }
                    } else {
                        System.out.println("geçersiz raf numarası lütfen 100 ile 999 arasında bir sayı giriniz");
                    }



                }catch (NumberFormatException e){
                    System.out.println("geçersiz raf numarası lütfen sayısal bir değer giriniz");
                }
            }
        }else {
            System.out.println("geçersiz ürün idsi ");


        }
        urunListele1();
    }




    //----------------------------ÜRÜN ARAMA   --Alper H.----------------------------//


    public void urunArama() {


        if (!Utils.Utils1.urunKontrol(mevcutUrunler)) return; // Depoda ürün yoksa ana menüye dön

        System.out.println("----Lutfen Arama Turunu Seciniz----");
        System.out.println("1-Urun Ismi ile Arama");
        System.out.println("2-Uretici Ismi ile Arama");
        System.out.println("3-Miktar Altindaki Urunleri Arama");

        int secim = input.nextInt();
        input.nextLine();



        switch (secim) {
            case 1:
                System.out.println("Lutfen Aranacak Urun Ismini Giriniz");
                String aranacakIsim = input.nextLine();
                System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                        "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
                System.out.println("-".repeat(95));
                mevcutUrunler.values().stream()
                        .filter(t -> t.getUrunIsmi().equalsIgnoreCase(aranacakIsim))
                        .forEach(System.out::println);
                System.out.println("Aramanız tamamlandı. Teşekkür ederiz!");
                break;

            case 2:
                System.out.println("Lutfen Aranacak Urun Ureticisini Giriniz");
                String aranacakUretici = input.nextLine();
                System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                        "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
                System.out.println("-".repeat(95));
                mevcutUrunler.values().stream().filter(t -> t.getUretici().equalsIgnoreCase(aranacakUretici)).forEach(System.out::println);
                System.out.println("Aramanız tamamlandı. Teşekkür ederiz!");
                break;

            case 3:
                System.out.println("Lutfen Miktar Sinirini Giriniz");
                int miktarUstSinir = input.nextInt();
                System.out.printf("%-20s | %-20s | %-20s | %-10s | %-10s | %-10s%n",
                        "Urun Numarasi", "Urun Ismi", "Uretici Ismi", "Miktar", "Birim", "Raf");
                System.out.println("-".repeat(95));
                mevcutUrunler.values().stream().filter(t -> t.getMiktar() <= miktarUstSinir).forEach(System.out::println);
                System.out.println("Aramanız tamamlandı. Teşekkür ederiz!");
                break;

            default:
                System.out.println("Gecersiz Bir Secim Yaptiniz");
                break;
        }

    }

}
