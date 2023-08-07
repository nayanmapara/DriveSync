
/** 
 * @project Drive Sync
 * @version 1.0.0
 * @author Het Patel, Nayan Mapara
 * @date 2023-08-15
 * @class PROG24178 OBJECT PROGRAMMING -JAVA
 * @Professor Dr.Muhammad Shafique
 * file Name: App.java
 * Description: This is the main class of the project.
*/

import java.util.List;

import controller.FileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Car;

public class App extends Application {
    public static void main(String[] args) throws Exception {

        // read cars from csv file
        List<Car> cars = FileController.readCarsFromCSV();

        // display all cars
        FileController.displayCars(cars);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // load fxml file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/fxml/Review.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Drive Sync");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
