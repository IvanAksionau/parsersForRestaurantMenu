package helper;

import entity.Dish;
import entity.DishType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

/**
 * Created by Ivan on 18.10.2016.
 */
public class SaxHandler extends DefaultHandler {
    private String elementName;
    private Dish dish;
    private List<Dish> dishList = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing...");
    }

    @Override
    public void startElement(String nameSpace, String localName, String qName, Attributes attr) {
        elementName = qName;
        if (elementName.equals("dish")) {
            dish = new Dish();
            dish.setDishID(parseInt(attr.getValue(0)));
        }
    }

    @Override
    public void endElement(String nameSpace, String localName, String qName) throws SAXException {
        if (qName.equals("dish")) {
            dishList.add(dish);
        }
        elementName = "";
    }

    @Override
    public void characters(char[] ch, int start, int end) {
        String value = new String(ch, start, end);
        switch (elementName) {
            case "dishType":
                dish.setDishType(DishType.valueOf(value));
                break;
            case "photo":
                dish.setPhotoPath(value);
                break;
            case "name":
                dish.setDishName(value);
                break;
            case "description":
                dish.setDishDescription(value);
                break;
            case "portion":
                dish.setDishPortion(value);
                break;
            case "price":
                dish.setDishPrice(parseInt(value));
                break;
        }
    }

    public List<Dish> getDishList() {
        return dishList;
    }
}
