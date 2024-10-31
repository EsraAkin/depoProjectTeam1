import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DepoProjectApp {


    public static void main(String[] args) {
        start();
    }

    private static void start() {

        ProductService productService=new ProductService();

        Scanner input = new Scanner(System.in);
        int secim;

        do {

            System.out.println("-----DEPO ÜRÜN TAKİBİ-----");

            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            System.out.println("1-Ürün Tanımlama");
            System.out.println("2-Ürün Listeleme");
            System.out.println("3-Ürün Girişi");
            System.out.println("4-Ürün Rafa Koyma");
            System.out.println("5-Ürün Çıkışi");
            System.out.println("6-Ürün Güncelle");
            System.out.println("0-ÇIKIŞ");

            //Kullanıcı int yerine string girerse exeption kontrolü yapıyotuz.

            try {
                secim = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! Lütfen menüden bir tamsayı değer giriniz :");
                input.nextLine(); //Geçersiz girdiyi temizle
                secim = -1;
            }


            switch (secim) {
                case 1:
                    productService.urunTanimlama();

                break;
                case 2:
                    //Ürün Listeleme
                    productService.urunListele1();
                    break;
                case 3:
                    //Ürün Girişi
                    productService.urunGirisi();
                    break;
                case 4:
                    //Rafa Koyma
                    break;
                case 5:
                    //Ürün Çıkışı
                    break;
                case 6:
                    //Ürün güncelle

                    productService.urunuGuncelle();
                    break;

                case 0:
                    //ÇIKIŞ
                    break;

                default:
                    if (secim != -1) {
                        System.out.println("Hatalı giriş! Lütfen menüden bir tamsayı değer giriniz : ");
                    } else if (!(secim >= 0 && secim < 6)) {
                        System.out.println("Hatalı giriş! Lütfen menüden bir tamsayı değer giriniz : ");
                    }
                    break;
            }

        } while (secim != 0);
        input.close();
    }








}