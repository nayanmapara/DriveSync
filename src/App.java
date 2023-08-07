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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // load fxml file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/fxml/Review.fxml"));
            Parent root = loader.load();

            VBox vbox = new VBox(root);

            primaryStage.setTitle("Drive Sync");
            primaryStage.setScene(new Scene(vbox));
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
