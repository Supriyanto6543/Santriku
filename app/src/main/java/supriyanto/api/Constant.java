package supriyanto.api;

import java.io.Serializable;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class Constant implements Serializable{

    private static final String SERVER_URL= "http://192.168.5.17/santriku/";

    public static final String URL_HOME = SERVER_URL + "api.php?home";
    public static final String URL_SANTRI = SERVER_URL + "api.php?santri_detail";
    public static final String URL_PLP = SERVER_URL + "api.php?plp";

    public static final String ROOT_JSON = "SANTRIKU";

    public static final String PLP_RECORD_NAME = "plp";
    public static final String PLP_REOCRD_IMAGE = "image";
    public static final String PLP_RECORD_DESCRIPTION = "plp_description";

    public static final String PLP_NAME = "plp_name";
    public static final String PLP_IMAGE = "image_plp";

    public static final String SANTRI_NAME = "name";
    public static final String SANTRI_ALAMAT = "alamat";
    public static final String SANTRI_KELAS = "kelas";
    public static final String SANTRI_TTL = "ttl";
    public static final String SANTRI_IMAGES = "images_santri";

    public static final String SANTRI_PORTFOLIO_NAME = "portfolio_name";
    public static final String SANTRI_PORTFOLIO_DESCRIPTION = "portfolio_description";
    public static final String SANTRI_PORTFOLIO_IMAGES = "portfolio_images";

    //SANTRI SHOW ALL DATA
    public static final String SANTRI_ALL_DATA = "santri";

    public static final String SANTRI_ALL_NAME = "name";
    public static final String SANTRI_ALL_ALAMAT = "alamat";
    public static final String SANTRI_ALL_KELAS = "kelas";
    public static final String SANTRI_ALL_TTL = "ttl";
    public static final String SANTRI_ALL_IMAGES = "images_santri";
    public static final String SANTRI_ALL_PLP = "plp";
    public static final String SANTRI_ALL_PLP_DES = "plp_description";
    public static final String SANTRI_ALL_NOMOR = "nomor";
    public static final String SANTRI_ALL_TOTAL = "total";
}
