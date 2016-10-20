package helper;

import entity.Dish;
import entity.DishType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

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
            dish.setDishID(Integer.parseInt(attr.getValue(0)));

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
        switch (elementName) {
            case "dishType":
                dish.setDishType(DishType.valueOf(new String(ch, start, end)));
                break;
            case "photo":
                dish.setPhotoPath(new String(ch, start, end));
                break;
            case "name":
                dish.setDishName(new String(ch, start, end));
                break;
            case "description":
                dish.setDishDescription(new String(ch, start, end));
                break;
            case "portion":
                dish.setDishPortion(new String(ch, start, end));
                break;
            case "price":
                dish.setDishPrice(Integer.parseInt(new String(ch, start, end)));
                break;
        }
    }

    public List<Dish> getDishList() {
        return dishList;
    }

}
