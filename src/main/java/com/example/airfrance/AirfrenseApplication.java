package com.example.airfrance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class AirfrenseApplication extends Application {

    // Déclaration de variables statiques pour la scène, le stage et la carte des écrans
    public static Scene scene;
    public static Stage stage;
    public static HashMap<String, Pane> screenByName = new HashMap<>();

    // Méthode de navigation pour changer l'écran actif
    public static void navigateTo(String name) {
        scene.setRoot(screenByName.get(name));
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Initialisation des écrans et ajout à la carte screenByName
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

        // Création de la scène initiale avec l'écran "booking/create"
        scene = new Scene(screenByName.get("booking/create"), 500, 500);

        // Configuration du titre de la fenêtre principale et affichage de la scène
        stage.setTitle("Projet JavaFX Amal!");
        stage.setScene(scene);
        stage.show();

        // Mise à jour de la référence au stage dans la classe
        AirfrenseApplication.stage = stage;
    }

    public static void main(String[] args) {
        // Lancement de l'application JavaFX
        launch();
    }
}
