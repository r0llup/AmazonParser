/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package types;

/**
 *
 * @author Sh1fT
 */

public abstract class Media {
    public String title;
    public String asin;
    public String price;
    public String devise;
    public String image;

    public Media(String title, String asin, String price, String devise,
        String image) {
        this.title = title;
        this.asin = asin;
        this.price = price;
        this.devise = devise;
        this.image = image;
    }

    public Media() {
        this.title = null;
        this.asin = null;
        this.price = null;
        this.devise = null;
        this.image = null;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAsin() {
        return this.asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDevise() {
        return this.devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new StringBuilder("\nTitle...............: ").append(this.getTitle())
            .append("\nAsin................: ").append(this.getAsin())
            .append("\nPrice...............: ").append(this.getPrice())
            .append("\nDevise..............: ").append(this.getDevise())
            .append("\nImage...............:\n").append(this.getImage()).toString();
    }
}