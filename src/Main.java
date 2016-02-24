/**
 * Created by IbraD00 on 24/02/2016.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.init(stage);
        this.build(stage);
    }

    public void init(Stage stage)
    {
        stage.setTitle("myWheater");
        stage.setResizable(false);
    }

    public void build(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid);
        scene.setFill(Color.SKYBLUE);

        this.buildContent(grid);

        stage.setScene(scene);
        stage.show();
    }

    public void buildContent(GridPane root)
    {
        Text title = new Text(5, 20,"Bienvenue sur myWheater");
        title.setFont(Font.font(15));

        Text subTitle = new Text (5, 35, "Convertisseur celsius Fahrenheit by IbraD00 https://github.com/IbraD00");
        subTitle.setFont(Font.font(10));

        Text result = new Text (5, 150, "Resultat: ");
        result.setFont(Font.font(15));

        Text label = new Text (5, 150, "Entrer un nombre (ex: 12 ou 32.4) :");

        ChoiceBox cb = new ChoiceBox<>(FXCollections.observableArrayList(
                "Celsius", "Fahrenheit"
        ));
        cb.minWidth(30);
        cb.maxWidth(50);
        cb.setValue("Celsius");

        Button button = new Button("Convertir");

        TextField textField = new TextField ();

        button.setOnAction(e -> {
            String data = textField.getText();
            if(data.isEmpty()) {
                result.setText("Resultat:");
            }else {
                double value = Double.parseDouble(data);
                if(cb.getValue() == "Celsius") {
                    double resultData = Converter.convertToCelsius(value);
                    result.setText("Resultat: "+Math.round(resultData)+"°C");
                }else {
                    double resultData = Converter.convertToFahrenheit(value);
                    result.setText("Resultat: "+Math.round(resultData)+"°F");
                }
            }

        });

        root.add(title, 1, 0, 1, 1);
        root.add(subTitle, 1, 1, 1, 1);
        root.add(result, 1, 2, 1, 1);
        root.add(label, 1, 3, 1, 1);
        root.add(textField, 1, 4, 1, 1);
        root.add(cb, 1, 5, 1, 1);
        root.add(button, 2, 5, 1, 1);
    }

}
