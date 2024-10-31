import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DepoProjectApp {


    public static void main(String[] args) {
        start();
    }

    private static void start() {

        Scanner input = new Scanner(System.in);
        int secim;

        public void urunGirisi(int idCounter){
            System.out.print("Giriş yapmak istediğiniz ürünün ID'sini girin: ");
            int id = input.nextInt();

            System.out.print("Giriş miktarını girin: ");
            int miktar = input.nextInt();
            input.nextLine(); // Newline consumation

            Product urunIsmi = null;
            if (Product.containsKey(idCounter)) {
                urunIsmi = (Product) urunIsmi.getIdCounter(int id);
                urunIsmi.setMiktar(urunIsmi.getMiktar() + miktar);
                System.out.println("Ürün girişi başarıyla yapıldı!");
            } else {
                System.out.println("Ürün bulunamadı.");
            }
        }

        do {

            System.out.println("-----DEPO ÜRÜN TAKİBİ-----");

            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            System.out.println("1-Ürün Tanımlama");
            System.out.println("2-Ürün Listeleme");
            System.out.println("3-Ürün Girişi");
            System.out.println("4-Ürün Rafa Koyma");
            System.out.println("5-Ürün Çıkışi");
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
                    //Ürün tanımlama
                    break;
                case 2:
                    //Ürün Listeleme
                    break;
                case 3:
                    //Ürün Girişi
                    ProductService.urunGirisi();
                    break;
                case 4:
                    //Rafa Koyma
                    break;
                case 5:
                    //Ürün Çıkışı
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