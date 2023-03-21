package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties pr;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        FileInputStream fs;
        try {
            fs = new FileInputStream(src);
            pr = new Properties();

            pr.load(fs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getApplicationURL() {
        String url = pr.getProperty("baseURL");
        return url;
    }

    public String getCellNumber() {
        String cellNumber = pr.getProperty("cellNumber");
        return cellNumber;
    }

    public String getChromepath() {
        String chromepath = pr.getProperty("chromepath");
        return chromepath;
    }
    public String getProduct1() {
        String firstProduct = pr.getProperty("product1");
        return firstProduct;
    }
    public String getProduct2() {
        String secondProduct = pr.getProperty("product2");
        return secondProduct;
    }
    public String getProduct3() {
        String ThirdProduct = pr.getProperty("product3");
        return ThirdProduct;
    }

    public String productToBeRemoved() {
        String product = pr.getProperty("removeProduct");
        return product;
    }
}
