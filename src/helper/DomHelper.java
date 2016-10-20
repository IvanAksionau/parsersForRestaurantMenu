package helper;

import entity.Dish;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by Ivan on 20.10.2016.
 */
public class DomHelper {
    private static ArrayList<Dish> dishList;
    private static NodeList dishes;
    private static Dish dishForList = new Dish();

    public static ArrayList<Dish> getDishList(Element element) {
        dishList = new ArrayList<>();
        System.out.println("Name of maim element is " + element.getNodeName());

        dishes = element.getElementsByTagName("dish");
        System.out.println("Count of founded dishes is " + dishes.getLength());

        for (int i = 0; i < dishes.getLength(); i++) {
            Element dish = (Element) dishes.item(i);
            dishForList.setDishID(Integer.parseInt(dish.getAttribute("ID")));
            // dish.getChildNodes().item(1/потом 2 и тд).getChildNodes().item(0).getNodeValue();таким способом короче, но непонятнее)
            dishForList.setDishType(
                    dish.getElementsByTagName("dishType").item(0).getChildNodes().item(0).getNodeValue());
            dishForList.setPhotoPath(
                    dish.getElementsByTagName("photo").item(0).getChildNodes().item(0).getNodeValue());
            dishForList.setDishName(
                    dish.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
            dishForList.setDishDescription(
                    dish.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue());
            dishForList.setDishPortion(
                    dish.getElementsByTagName("portion").item(0).getChildNodes().item(0).getNodeValue());
            dishForList.setDishPrice(
                    Integer.parseInt(dish.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue()));
            dishList.add(dishForList);
        }
        return dishList;
    }

}

