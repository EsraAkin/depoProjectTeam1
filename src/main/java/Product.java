public class Product {
//hatice angi
    private Integer idCounter;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;

    public Product(Integer idCounter, String urunIsmi, String uretici, int miktar, String birim, String raf) {
        this.idCounter = idCounter;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = 0;
        this.birim = birim;
        this.raf = "raf";/////kakakkaakkaka
    }


    //get set


    public Integer getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(Integer idCounter) {
        this.idCounter = idCounter;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }
}
