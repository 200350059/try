
import com.mysql.jdbc.Blob;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TV {

    private String brand;
    private int size, price;
    private Blob image;


    public TV(String brand, int size, int price) {
        setBrand(brand);
        setSize(size);
        setPrice(price);
     //   setImage(image);

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {


                this.brand = brand;

        }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {


        this.size = size;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {


        this.price = price;

    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {


        this.image = image;

    }

    }


