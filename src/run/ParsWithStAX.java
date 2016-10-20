package run;

import entity.Dish;
import helper.StaxHelper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ivan on 19.10.2016.
 */
public class ParsWithStAX {
    private static List<Dish> dishList;
    private static XMLStreamReader reader;
    private static FileInputStream input;

    public static void main(String[] args) throws IOException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            input = new FileInputStream(new File("src/doc/menu.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("File don't exist ! ");
        }

        try {
            reader = factory.createXMLStreamReader(input);
            dishList = StaxHelper.getDishList(reader);
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }

        System.out.println("Count of founded dishes is " + dishList.size() + " :");
        for (Dish dish : dishList) {
            System.out.println(dish);
        }

    }
}
