package Producer_Consumer_Problem;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Window.fxml"));
        primaryStage.setTitle("Producer And Consumer");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
