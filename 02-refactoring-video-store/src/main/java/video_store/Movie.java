package video_store;

public class Movie {
    private static final int CHILDRENS = 2;
    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int code) {
        priceCode = code;
    }

    public String getTitle() {
        return title;
    }

    public static int getCHILDRENS() {
        return CHILDRENS;
    }

    public static int getREGULAR() {
        return REGULAR;
    }

    public static int getNEW_RELEASE() {
        return NEW_RELEASE;
    }

    
}
