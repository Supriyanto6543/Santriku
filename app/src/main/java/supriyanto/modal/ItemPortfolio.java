package supriyanto.modal;

import java.io.Serializable;

/**
 * Created by SUPRIYANTO on 20/04/2019.
 */

public class ItemPortfolio implements Serializable {

    private String portfolio_name, portfolio_description, portfolio_images;

    public ItemPortfolio(String portfolio_name, String portfolio_images) {
        this.portfolio_name = portfolio_name;
        this.portfolio_images = portfolio_images;
    }

    public ItemPortfolio(String portfolio_name, String portfolio_description, String portfolio_images) {
        this.portfolio_name = portfolio_name;
        this.portfolio_description = portfolio_description;
        this.portfolio_images = portfolio_images;
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
