package helper;

import entity.Dish;
import entity.DishType;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 20.10.2016.
 */
public class StaxHelper {
    private static String elementName;
    private static Dish dish;

    public static List<Dish> getDishList(XMLStreamReader reader) throws XMLStreamException {
        List<Dish> dishList = new ArrayList<>();
        int eventType = reader.getEventType();
        while (true) {
            // проходим по типам событий
            switch (eventType) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("start parsing...");
                    System.out.println("characterEncodingScheme is : " + reader.getCharacterEncodingScheme());
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    if (elementName.equals("dish")) {
                        dish = new Dish();
                        int dishID = Integer.parseInt(reader.getAttributeValue(0));
                        dish.setDishID(dishID);
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    // если курсор указывает на символьное событие данных,
                    // которое состоит из всего пробела(между endElement и startElement),
                    //выходим из switch, иначе проведём инициализацию значением "/n"
                    if (reader.isWhiteSpace()) {
                        break;
                    }
                    switch (elementName) {
                        case "dishType":
                            dish.setDishType(DishType.valueOf(reader.getText()));
                            break;
                        case "photo":
                            dish.setPhotoPath(reader.getText());
                            break;
                        case "name":
                            dish.setDishName(reader.getText());
                            break;
                        case "description":
                            dish.setDishDescription(reader.getText());
                            break;
                        case "portion":
                            dish.setDishPortion(reader.getText());
                            break;
                        case "price":
                            dish.setDishPrice(Integer.parseInt(reader.getText()));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (reader.getLocalName().equals("dish")) {
                        dishList.add(dish);
                    }
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("end parsing...");
                    break;
            }
            // если больше элементов нет, то заканчиваем обход файла
            if (!reader.hasNext())
                break;
            // переход к следующему событию
            eventType = reader.next();
        }

        return dishList;
    }
}
