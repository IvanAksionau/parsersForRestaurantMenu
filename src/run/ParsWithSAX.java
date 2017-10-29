package run;

import entity.Dish;
import org.xml.sax.SAXException;
import helper.SaxHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ivan on 18.10.2016.
 */
public class ParsWithSAX {
    public static void main(String[] args) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(true);
        SaxHandler saxHandler = new SaxHandler();
        try {
            SAXParser parser = parserFactory.newSAXParser();

            parser.parse(new File("src/doc/menu.xml"), saxHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        for (Dish dish : saxHandler.getDishList()) {
            System.out.println(dish);
        }
    }
}

