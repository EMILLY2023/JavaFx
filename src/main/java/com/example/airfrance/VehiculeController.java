package com.example.airfrance;

import com.example.airfrance.domain.Vehicule;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VehiculeController {

    @FXML
    private TextField inputName;
    @FXML
    private TextField inputImm;
    @FXML
    private ListView<String> listView;
    @FXML
    private ArrayList<Vehicule> dataList = new ArrayList<>();
    @FXML
    private ObservableList<String> observableList = FXCollections.observableArrayList();
    @FXML
    private TextField index;

    // Méthode pour créer un nouveau véhicule
    public void create() {
        Vehicule vehicule = new Vehicule(inputName.getText(), inputImm.getText());
        if (vehicule.getName().length() > 0 && vehicule.getLicence().length() > 0) {
            dataList.add(vehicule);
            observableList.add(vehicule.toString());
            inputName.clear();
            inputImm.clear();
        }
    }

    // Méthode appelée lors de l'initialisation du contrôleur
    public void initialize() {
        // Initialisation de données de test pour les véhicules
        Vehicule vehicle1 = new Vehicule("Toyota", "EJ-884-NF");
        Vehicule vehicle2 = new Vehicule("Honda Civic", "CD5678");
        Vehicule vehicle3 = new Vehicule("Alfa Romeo", "GF6576");


        // Ajout des véhicules à la liste des données
        dataList.add(vehicle1);
        dataList.add(vehicle2);
        dataList.add(vehicle3);


        // Initialisation de la liste observable utilisée dans la ListView
        observableList = FXCollections.observableArrayList();
        for (Vehicule v : dataList) {
            observableList.add(v.toString());
        }
        // Liez l'ObservableList à la ListView
        listView.setItems(observableList);
    }

    // Méthode pour supprimer un véhicule
    public void delete() {
        String supp = listView.getSelectionModel().getSelectedItem();
        observableList.remove(supp);
    }

    // Méthode pour afficher les détails d'un véhicule sélectionné
    public void goToSelect() {
        int indexValue = listView.getSelectionModel().getSelectedIndex();
        String indexValueString = String.valueOf(indexValue);
        index.setText(indexValueString);

        Vehicule vehicule = dataList.get(indexValue);
        String nameVeh = vehicule.getName();
        inputName.setText(nameVeh);

        String immVeh = vehicule.getLicence();
        inputImm.setText(immVeh);
    }

    // Méthode pour éditer les détails d'un véhicule sélectionné
    public void edit() {
        int indexValue = listView.getSelectionModel().getSelectedIndex();
        String newName = inputName.getText();
        if (indexValue >= 0 && newName.length() > 0) {
            // Mettre à jour le nom du véhicule sélectionné dans la liste des données
            Vehicule selectedVehicule = dataList.get(indexValue);
            selectedVehicule.setName(newName);

            // Mettre à jour le texte dans la ListView
            listView.getItems().set(indexValue, newName);

            // Effacer les champs de saisie
            inputName.clear();
            inputImm.clear();
        }
    }
}
