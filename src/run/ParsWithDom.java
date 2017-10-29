package run;

import entity.Dish;
import helper.DomHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
    private static ArrayList<Dish> dishList;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/doc/menu.xml"));
        Element element = document.getDocumentElement();
        dishList = DomHelper.getDishList(element);

        for (Dish dish : dishList) {
            System.out.println(dish);
        }
    }
}
