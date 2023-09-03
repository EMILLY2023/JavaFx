package com.example.airfrance.controllers;

import com.example.airfrance.Container;
import com.example.airfrance.domain.Vehicule;
import com.example.airfrance.services.ObservableStorageService;
import com.example.airfrance.services.VehicleService;
import com.example.airfrance.services.impl.ObservableStorageServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class VehiculeController {

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputImm;

    @FXML
    private ListView<String> listView;

    private ArrayList<Vehicule> dataList = new ArrayList<>();

    private ObservableList<String> observableList;

    private VehicleService vehicleService;
    private ObservableStorageService observableStorageService;

    @FXML
    private TextField index;

    public void create() {
        String name = inputName.getText();
        String imm = inputImm.getText();
        if (name.length() > 0 && imm.length() > 0) {
            Vehicule vehicule = new Vehicule(name, imm);
            dataList.add(vehicule);
            observableList.add(vehicule.toString());

            inputName.clear();
            inputImm.clear();
        }
    }

    public void initialize() {
        Container container = Container.getInstance();
        vehicleService = container.get(VehicleService.class);
        observableStorageService = container.get(ObservableStorageService.class);
        observableList = FXCollections.observableArrayList(); // Initialize the observableList
        listView.setItems(observableList);
    }

    public void delete() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            dataList.remove(selectedIndex);
            observableList.remove(selectedIndex);
        }
    }

    public void goToSelect() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            index.setText(String.valueOf(selectedIndex));
            Vehicule vehicule = dataList.get(selectedIndex);
            inputName.setText(vehicule.getName());
            inputImm.setText(vehicule.getLicence());
        }
    }

    public void edit() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String newName = inputName.getText();
            if (newName.length() > 0) {
                Vehicule selectedVehicule = dataList.get(selectedIndex);
                selectedVehicule.setName(newName);
                observableList.set(selectedIndex, selectedVehicule.toString());
                inputName.clear();
                inputImm.clear();
            }
        }
    }
}
