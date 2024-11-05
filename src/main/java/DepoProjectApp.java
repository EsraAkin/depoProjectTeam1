
import java.util.Scanner;

public class DepoProjectApp {


    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Utils utils = new Utils();
        ProductService productService = new ProductService();

        Scanner input = new Scanner(System.in);
        int secim;

        do {

            System.out.println();
            System.out.println("-----DEPO ÜRÜN TAKİBİ-----");

            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            System.out.println("1-Ürün Tanımlama");
            System.out.println("2-Ürün Listeleme");
            System.out.println("3-Ürün Girişi");
            System.out.println("4-Ürün Rafa Koyma");
            System.out.println("5-Ürün Çıkışi");
            System.out.println("6-Ürün Güncelle");
            System.out.println("7-Ürün Arama");
            System.out.println("0-ÇIKIŞ");

            //Kullanıcı int yerine string girerse exeption kontrolü yapıyotuz.

            secim = utils.intGirisAl("");

            switch (secim) {
                case 1:
                    productService.urunTanimlama();

                    break;
                case 2:
                    productService.urunListele1();
                    break;
                case 3:
                    productService.urunGirisi();
                    break;
                case 4:
                    productService.urunRafakoyma();
                    break;
                case 5:
                    productService.urunCikisi();
                    break;
                case 6:
                    productService.urunuGuncelle();
                    break;
                case 7:
                    productService.urunArama();
                    break;
                case 0:
                    //ÇIKIŞ
                    break;

                default:
                    boolean hataliGiris = (secim != -1) || (!(secim >= 0 && secim < 8));
                    if (hataliGiris) {
                        System.out.println("Hatalı giriş! Lütfen menüden bir tamsayı değer giriniz : ");
                    }
                    break;
            }

        } while (secim != 0);
        input.close();
    }

}
