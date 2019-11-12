package com.hrs.util;

import com.hrs.view.models.Airplane;
import com.hrs.view.models.Airport;
import com.hrs.view.models.Arrival;
import com.hrs.view.models.Flight;
import com.hrs.view.style.CSSStyle;
import com.hrs.view.util.FieldValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * A Utility/helper class for others usage. Provides support to other classes. Any method in here must be stand
 * alone method. All methods must be -- public static --. Other methods can exists but with must be private access.
 */
public class Utility
{
    public static final String HOME_PIC_PATH = "home.jpg";
    
    public static Node getNodeByRowColumnIndex (int row, int column, GridPane gridPane)
    {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();
        
        for (Node node : children)
        {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column)
            {
                result = node;
                break;
            }
        }
        return result;
    }
    
//    public static void setOnCenter(Stage stage)
//    {
//        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
//    }
    
    public static ObservableList<Arrival> toObservableList(List<Arrival> arrivals)
    {
        return FXCollections.observableArrayList(arrivals);
    }
    
    public static List<Label> arrivalHeaders()
    {
        return Arrays.asList(new Label(FieldValue.FLIGHT_CODE), new Label(FieldValue.AIRLINE),
                new Label(FieldValue.SOURCE),
                new Label(FieldValue.DATE), new Label(FieldValue.STATUS));
    }
    
    public static Button button(String label)
    {
        Button button = new Button(label);
        button.setMinHeight(30);
        button.setMinWidth(130);
        button.setMaxHeight(70);
        button.setMaxWidth(500);
        return button;
    }
    
    public static Label label(String label)
    {
        return new Label(label);
    }
    
    public static HBox reservationHeaders()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.SOURCE), button(FieldValue.DESTINATION),
                button(FieldValue.AIRLINE), button(FieldValue.AIRPLANE), button(FieldValue.FARE),
                        button(FieldValue.RV_DATE));
        
        return hBox;
    }
    
    public static HBox CUSTOMER_RSVP_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.AIRLINE), button(FieldValue.AIRPLANE), button(FieldValue.FLIGHT_CODE),
                        button(FieldValue.SOURCE), button(FieldValue.DESTINATION), button(FieldValue.FARE),
                        button(FieldValue.RV_DATE), button(FieldValue.STATUS), button(FieldValue.TO_CANCEL));
        
        return hBox;
    }
    
    public static HBox CUSTOMER_PAST_FLIGHTS_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll(button(FieldValue.AIRLINE), button(FieldValue.AIRPLANE),
                button(FieldValue.FLIGHT_CODE), button(FieldValue.SOURCE), button(FieldValue.DESTINATION),
                button(FieldValue.FARE));
        
        return hBox;
    }
    
    public static HBox airlineSpecificHeaders()
    {
        HBox hBox = new HBox();
    
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.DESTINATION), button(FieldValue.AIRLINE),
                        button(FieldValue.DATE), button(FieldValue.FARE), button(FieldValue.RV_DATE));
    
        return hBox;
    }
    
    public static HBox addFlightHeaders()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), label(" "), button(FieldValue.DESTINATION), label(" "),
                        button(FieldValue.AIRLINE), label(" "),
                        button(FieldValue.DATE), label(" "),
                        button(FieldValue.FARE), label(" "), button(FieldValue.RV_DATE));
        
        return hBox;
    }
    
    public static HBox GLOBAL_SEARCH_FLIGHT_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.SOURCE), button(FieldValue.DEP_DATE_TIME),
                        button(FieldValue.DESTINATION), button(FieldValue.ARR_DATE_TIME), button(FieldValue.AIRLINE),
                        button(FieldValue.AIRPLANE), button(FieldValue.FARE), button(FieldValue.AVAILABLE_SEAT),
                        button(FieldValue.STATUS), button(FieldValue.TO_RSVP));
        
        return hBox;
    }
    
    public static HBox AIRLINE_SEARCH_FLIGHT_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.SOURCE), button(FieldValue.DEP_DATE_TIME),
                        button(FieldValue.DESTINATION), button(FieldValue.ARR_DATE_TIME), button(FieldValue.AIRLINE),
                        button(FieldValue.AIRPLANE), button(FieldValue.FARE), button(FieldValue.AVAILABLE_SEAT), button(FieldValue.STATUS));
        
        return hBox;
    }
    
    public static Label SE_HEADER()
    {
        Label l = new Label(FieldValue.SEARCH_ENGINE_RESULTS);
        l.setAlignment(Pos.CENTER);
        l.setStyle(CSSStyle.fontFamily(FieldValue.FONT_MONACO)
                           .concat(CSSStyle.fontSize(15)));
        return l;
    }
    
    public static Label AIRLINE_HEADER(String airline)
    {
        Label l = new Label(FieldValue.RESULTS.concat(" ").concat(airline));
        l.setAlignment(Pos.CENTER);
        l.setStyle(CSSStyle.fontFamily(FieldValue.FONT_MONACO)
                           .concat(CSSStyle.fontSize(15)));
        return l;
    }
    
    public static Insets FLIGHT_LABEL()
    {
        return new Insets(8, 8, 8, 8);
    }
    
    public static Set<String> TIMES()
    {
        Set<String> times = new LinkedHashSet <>();
        
        times.add("12:00 am");
        times.add("3:00 am");
        times.add("6:00 am");
        times.add("9:00 am");
        times.add("12:00 pm");
        times.add("3:00 pm");
        times.add("6:00 pm");
        times.add("9:00 pm");
        
        return times;
    }
    
    public static HBox ADMIN_CANCEL_FLIGHT_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.AIRPLANE), button(FieldValue.SOURCE),
                        button(FieldValue.DEP_DATE_TIME), button(FieldValue.DESTINATION),
                        button(FieldValue.ARR_DATE_TIME), button(FieldValue.TOTAL_RSVP),
                        button(FieldValue.STATUS), button(FieldValue.TO_CANCEL));
        
        return hBox;
    }
    
    public static HBox ADMIN_VIEW_RESERVATION_HEADERS()
    {
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll
                (button(FieldValue.FLIGHT_CODE), button(FieldValue.AIRPLANE), button(FieldValue.SOURCE),
                        button(FieldValue.DESTINATION), button(FieldValue.LAST_NAME), button(FieldValue.STATUS),
                        button(FieldValue.RSVP_BY), button(FieldValue.RSVP_DATE));
        
        return hBox;
    }
    
    public static Set<Flight> SORT_BY_AIRLINE(Set<Flight> flights)
    {
        List<Flight> list = new LinkedList <>(flights);
    
        Collections.sort(list, new Comparator <Flight>()
        {
            @Override
            public int compare(Flight o1, Flight o2)
            {
                return o1.getAirLine().getAirlineName().compareTo(o2.getAirLine().getAirlineName());
            }
        });
        
        return new LinkedHashSet <>(list);
    }
    
    public static Set<Flight> SORT_BY_FARE(Set<Flight> flights)
    {
        List<Flight> list = new LinkedList <>(flights);
        
        Collections.sort(list, new Comparator <Flight>()
        {
            @Override
            public int compare(Flight o1, Flight o2)
            {
                return o1.getFare().compareTo(o2.getFare());
            }
        });
        
        return new LinkedHashSet <>(list);
    }
    
    public static Background BACKGROUND_IMAGE_BY_AIRLINE(String path)
    {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(new File(new File("")
                        .getAbsolutePath()+"/src/main/java/com/hrs/resources/"+path).toURI().toString(),true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }
    
    public static ObservableList<Airplane> AIRPLANES_LIST(Set<Airplane> airplanes)
    {
        List<Airplane> airplanes1 = new LinkedList <>(airplanes);
        return FXCollections.observableArrayList(airplanes1);
    }
    
    public static ObservableList<Airport> AIRPORTS_LIST(Set<Airport> airports)
    {
        List<Airport> airports1 = new LinkedList <>(airports);
        return FXCollections.observableArrayList(airports1);
    }
    
    public static ObservableList<String> TIMES_LIST()
    {
        List<String> airports1 = new LinkedList <>(Utility.TIMES());
        return FXCollections.observableArrayList(airports1);
    }
    
    
}
