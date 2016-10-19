package entity;

/**
 * Created by Ivan on 18.10.2016.
 */
public class Dish {

    private int dishID;
    private String dishType;
    private String photoPath;
    private String dishName;
    private String dishDescription;
    private String dishPortion;
    private int dishPrice;

    @Override
    public String toString() {
        return "dishID = " + dishID +
                "; dishType = " + dishType +
                "; dishName = " + dishName +
                "; dishDescription = " + dishDescription;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public void setDishPortion(String dishPortion) {
        this.dishPortion = dishPortion;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }
}
