package supriyanto.modal;

import java.io.Serializable;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class ItemRecordSantri implements Serializable{

    private String name, alamat, kelas, ttl, absensi, plp, image, portfolio_name, portfolio_description, portfolio_images;

    public ItemRecordSantri(String plp, String image) {
        this.plp = plp;
        this.image = image;
    }

    public ItemRecordSantri(String name, String alamat, String kelas, String ttl, String absensi, String plp, String image, String portfolio_name, String portfolio_description, String portfolio_images) {
        this.name = name;
        this.alamat = alamat;
        this.kelas = kelas;
        this.ttl = ttl;
        this.absensi = absensi;
        this.plp = plp;
        this.image = image;
        this.portfolio_name = portfolio_name;
        this.portfolio_description = portfolio_description;
        this.portfolio_images = portfolio_images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAbsensi() {
        return absensi;
    }

    public void setAbsensi(String absensi) {
        this.absensi = absensi;
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

    public String getPortfolio_name() {
        return portfolio_name;
    }

    public void setPortfolio_name(String portfolio_name) {
        this.portfolio_name = portfolio_name;
    }

    public String getPortfolio_description() {
        return portfolio_description;
    }

    public void setPortfolio_description(String portfolio_description) {
        this.portfolio_description = portfolio_description;
    }

    public String getPortfolio_images() {
        return portfolio_images;
    }

    public void setPortfolio_images(String portfolio_images) {
        this.portfolio_images = portfolio_images;
    }
}
