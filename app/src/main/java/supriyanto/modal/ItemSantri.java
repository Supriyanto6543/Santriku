package supriyanto.modal;

import java.io.Serializable;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class ItemSantri implements Serializable{

    private String name, alamat, kelas, ttl, images_santri, plp, plp_description, nomor, total;

    public ItemSantri(String name, String images_santri) {
        this.name = name;
        this.images_santri = images_santri;
    }

    public ItemSantri(String name, String alamat, String images_santri, String nomor, String total) {
        this.name = name;
        this.alamat = alamat;
        this.images_santri = images_santri;
        this.nomor = nomor;
        this.total = total;
    }

    public ItemSantri(String name, String alamat, String kelas, String ttl, String images_santri, String plp, String plp_description, String nomor, String total) {
        this.name = name;
        this.alamat = alamat;
        this.kelas = kelas;
        this.ttl = ttl;
        this.images_santri = images_santri;
        this.plp = plp;
        this.plp_description = plp_description;
        this.nomor = nomor;
        this.total = total;
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

    public String getImages_santri() {
        return images_santri;
    }

    public void setImages_santri(String images_santri) {
        this.images_santri = images_santri;
    }

    public String getPlp() {
        return plp;
    }

    public void setPlp(String plp) {
        this.plp = plp;
    }

    public String getPlp_description() {
        return plp_description;
    }

    public void setPlp_description(String plp_description) {
        this.plp_description = plp_description;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
