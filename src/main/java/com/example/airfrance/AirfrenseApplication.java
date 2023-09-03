package com.example.airfrance;

import com.example.airfrance.repositories.VehicleRepository;
import com.example.airfrance.repositories.impl.VehicleRepositoryImpl;
import com.example.airfrance.services.VehicleService;
import com.example.airfrance.services.impl.ObservableStorageServiceImpl;
import com.example.airfrance.services.impl.VehicleServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class AirfrenseApplication extends Application {

    public static Scene scene;
    public static Stage stage;
    public static HashMap<String, Pane > screenByName = new HashMap<>();

    public static void navigateTo(String name) {
        scene.setRoot(screenByName.get(name));
    }



    @Override
    public void start(Stage stage) throws IOException {
        VehicleRepository vehicleRepository= new VehicleRepositoryImpl();
        VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
        ObservableStorageServiceImpl observableStorageService = new ObservableStorageServiceImpl();

        Container container = Container.getInstance();
        container.register(VehicleService.class, vehicleService);
        container.register(ObservableStorageServiceImpl.class, observableStorageService);



        screenByName.put("dashboard", FXMLLoader.load(getClass().getResource("dashboard.fxml")));
        screenByName.put("login", FXMLLoader.load(getClass().getResource("login.fxml")));
        screenByName.put("menu", FXMLLoader.load(getClass().getResource("menu.fxml")));
        screenByName.put("about", FXMLLoader.load(getClass().getResource("about.fxml")));
        screenByName.put("booking/create", FXMLLoader.load(getClass().getResource("booking/create.fxml")));
       screenByName.put("booking/delete", FXMLLoader.load(getClass().getResource("booking/delete.fxml")));
        screenByName.put("booking/edit", FXMLLoader.load(getClass().getResource("booking/edit.fxml")));
       screenByName.put("booking/list", FXMLLoader.load(getClass().getResource("booking/list.fxml")));
        screenByName.put("vehicule/create", FXMLLoader.load(getClass().getResource("vehicule/create.fxml")));
       screenByName.put("vehicule/delete", FXMLLoader.load(getClass().getResource("vehicule/delete.fxml")));
        screenByName.put("vehicule/edit", FXMLLoader.load(getClass().getResource("vehicule/edit.fxml")));
        screenByName.put("vehicule/list", FXMLLoader.load(getClass().getResource("vehicule/list.fxml")));


        scene = new Scene(screenByName.get("booking/create"), 500, 500);

        stage.setTitle("Airfrense Amal!");
        stage.setScene(scene);
        stage.show();

        AirfrenseApplication.stage = stage;
    }



    public static void main(String[] args) {
        launch();
    }
}