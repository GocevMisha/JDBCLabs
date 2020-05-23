import java.sql.Date;

public class MusicItem {
    private int itemID;
    private String title;
    private String artist;
    private Date releaseDate;
    private float listPrice;
    private float price;
    private int version;

    @Override
    public String toString() {
        return "ID: " + this.itemID +
                "\nTitle: " + this.title +
                "\nArtist: " + this.artist +
                "\nRelease Date: " + this.releaseDate +
                "\nList Price: " + this.listPrice +
                "\nPrice: " + this.price +
                "\nVersion: " + this.version;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
