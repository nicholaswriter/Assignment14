import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class App extends Application {
    public static void main (String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Assignment 14: Conversion Table");
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);

        Button ba = new Button("km = m");
        ba.setLayoutX(100);
        ba.setLayoutY(250);
        ba.setOnAction(e -> handleConversion("Kilometers", "Meters", 1000));

        Button bb = new Button("ft = m");
        bb.setLayoutX(200);
        bb.setLayoutY(250);
        bb.setOnAction(e -> handleConversion("Feet", "Meters", 0.30480));

        Button bc = new Button("cm = inch");
        bc.setLayoutX(300);
        bc.setLayoutY(250);
        bc.setOnAction(e -> handleConversion("Centimeters", "Inches", 0.39370));

        Button bd = new Button("kg = lb");
        bd.setLayoutX(400);
        bd.setLayoutY(250);
        bd.setOnAction(e -> handleConversion("Kilograms", "Pounds", 2.20462));

        Button be = new Button("kph = mph");
        be.setLayoutX(500);
        be.setLayoutY(250);
        be.setOnAction(e -> handleConversion("KPH", "MPH", 0.62137));

        Pane root = new Pane();
        root.getChildren().addAll(ba, bb, bc, bd, be);

        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }

    private void handleConversion(String starting, String ending, double conversionRate) {
        TextInputDialog text = new TextInputDialog();
        text.setHeaderText("Convert " + starting + " to " + ending); 
        text.setContentText("Enter the your required amount: ");
        
        Optional<String> input = text.showAndWait();
        input.ifPresent(value -> {
            try {
                double inputValue = Double.parseDouble(value);
                double convertedValue = inputValue * conversionRate;

                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setTitle("Conversion Result");
                newAlert.setHeaderText("Final Conversion");
                newAlert.setContentText(inputValue + " " + starting + "=" + convertedValue + " in " + ending);
                newAlert.showAndWait();
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        });
    }
}