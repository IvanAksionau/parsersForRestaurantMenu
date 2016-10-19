package run;

import entity.Dish;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan on 19.10.2016.
 */
public class ParsWithDom {
    private static ArrayList<Dish> dishList = new ArrayList<>();

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(new File("src/doc/menu.xml"));

            Element element = document.getDocumentElement();
            String nodeName = element.getNodeName();
            System.out.println(nodeName);

            NodeList dishes = element.getElementsByTagName("dish");
            System.out.println(dishes.getLength());
            for (int i = 0; i < dishes.getLength(); i++) {
                Element dish = (Element) dishes.item(i);
                Dish dishForList = new Dish();
                dishForList.setDishID(Integer.parseInt(dish.getAttribute("ID")));
                // String DishType =
                // dish.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();таким способом короче, но непонятнее)
                dishForList.setDishType(dish.getElementsByTagName("dishType").item(0).getChildNodes().item(0).getNodeValue());
                dishForList.setPhotoPath(dish.getElementsByTagName("photo").item(0).getChildNodes().item(0).getNodeValue());
                dishForList.setDishName(dish.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
                dishForList.setDishDescription(dish.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue());
                dishForList.setDishPortion(dish.getElementsByTagName("portion").item(0).getChildNodes().item(0).getNodeValue());
                dishForList.setDishPrice(Integer.parseInt(dish.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue()));
                dishList.add(dishForList);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        for (Dish dish : dishList) {
            System.out.println(dish);
        }
    }
}
