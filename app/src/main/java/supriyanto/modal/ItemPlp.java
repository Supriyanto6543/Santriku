package supriyanto.modal;

import java.io.Serializable;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class ItemPlp implements Serializable{

    private String plp, image, plp_description;

    public ItemPlp(String plp, String image) {
        this.plp = plp;
        this.image = image;
    }

    public ItemPlp(String plp, String image, String plp_description) {
        this.plp = plp;
        this.image = image;
        this.plp_description = plp_description;
    }

    public String getPlp() {
        return plp;
    }

    public void setPlp(String plp) {
        this.plp = plp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlp_description() {
        return plp_description;
    }

    public void setPlp_description(String plp_description) {
        this.plp_description = plp_description;
    }
}
