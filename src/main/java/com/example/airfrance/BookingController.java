package com.example.airfrance;

import com.example.airfrance.domain.Booking;
import com.example.airfrance.domain.Vehicule;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BookingController  {
    // Les éléments de l'interface utilisateur FXML, annotés avec @FXML
    @FXML
    private TextField inputFname;
    @FXML
    private TextField inputLname;
    @FXML
    private TextField inputStart;
    @FXML
    private TextField inputEnd;
    @FXML
    private TextField inputEmail;
    @FXML
    private TextField inputPhone;
    @FXML
    private ListView<String> listView;
    @FXML
    private ArrayList<Booking> dataList = new ArrayList<>();
    @FXML
    private ArrayList<Vehicule> dataList1 = new ArrayList<>();
    @FXML
    private ObservableList<String> observableListVehicule = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> observableListBooking = FXCollections.observableArrayList();
    @FXML
    public ComboBox vehicleComboBox;
    @FXML
    private TextField index;

    // Méthode appelée lors de la création d'une réservation
    @FXML
    public void Create() {
        // Récupération de l'index du véhicule sélectionné dans la ComboBox
        int indexVeh = vehicleComboBox.getSelectionModel().getSelectedIndex();
        Vehicule ve1 = dataList1.get(indexVeh);

        // Création d'un objet Booking avec les données saisies dans l'interface
        Booking booking = new Booking(inputFname.getText(),
                inputLname.getText(), inputStart.getText(),
                inputEnd.getText(), inputEmail.getText(),
                inputPhone.getText(), ve1);

        // Vérification que tous les champs obligatoires sont remplis
        if (booking.getFirstname().length() > 0 && booking.getLastname().length() > 0
                && booking.getStartAt().length() > 0 && booking.getEndAt().length() > 0
                && booking.getEmail().length() > 0 && booking.getPhone().length() > 0) {
            dataList.add(booking);
            observableListBooking.add(booking.toString());
        }

        // Effacer les champs après la création
        inputFname.clear();
        inputLname.clear();
        inputPhone.clear();
        inputEmail.clear();
        inputEnd.clear();
        inputStart.clear();
    }

    // Méthode appelée lors de l'initialisation du contrôleur
    @FXML
    public void initialize() {
        // Initialisation de données de test pour les véhicules et les réservations
        // Ces données pourraient être chargées depuis une source de données réelle
        Vehicule vehicle1 = new Vehicule("Toyota", "EJ-884-NF");
        // ...

        // Ajout des véhicules à la liste observable pour la ComboBox
        for (Vehicule vv : dataList1) {
            observableListVehicule.add(vv.toString());
        }
        vehicleComboBox.setItems(observableListVehicule);

        // Initialisation de données de test pour les réservations
        Booking booking1 = new Booking("Annie", "VERSSAIRE", "10/04/2023",
                "09/05/2023", "annie.versaire@gmail.com", "07.90.79.65.67", vehicle1);
        // ...

        // Ajout des réservations à la liste observable pour la ListView
        for (Booking book : dataList) {
            observableListBooking.add(book.toString());
        }
        listView.setItems(observableListBooking);
    }

    // Méthode appelée lors de la suppression d'une réservation
    public void delete() {
        int index = listView.getSelectionModel().getSelectedIndex();
        dataList.remove(index);
        String supp = listView.getSelectionModel().getSelectedItem();
        if (supp != null) {
            observableListBooking.remove(supp);
        }
    }

    // Méthode appelée lors de la sélection d'une réservation
    public void select() {
        int indexValue = listView.getSelectionModel().getSelectedIndex();
        String indexValueString = String.valueOf(indexValue);
        index.setText(indexValueString);

        // Récupération des données de la réservation sélectionnée et affichage dans les champs
        Booking book = dataList.get(indexValue);
        String fName = book.getFirstname();
        inputFname.setText(fName);

        Vehicule vehi = book.getVehicule();
        int ind = dataList1.indexOf(vehi);
        vehicleComboBox.getSelectionModel().select(ind);

        // ...
    }

    // Méthode appelée lors de la modification d'une réservation
    public void edit() {
        int indexValue = vehicleComboBox.getSelectionModel().getSelectedIndex();
        Vehicule veh = dataList1.get(indexValue);
        int index = listView.getSelectionModel().getSelectedIndex();
        String fName = inputFname.getText();
        String lName = inputLname.getText();
        String ph = inputPhone.getText();
        String em = inputEmail.getText();
        String start = inputStart.getText();
        String end = inputEnd.getText();

        // Vérification des données de modification
        if (indexValue >= 0 && fName.length() > 0 && lName.length() > 0 && ph.length() > 0
                && em.length() > 0 && start.length() > 0 && end.length() > 0) {
            Booking book = dataList.get(index);
            book.setFirstname(fName);
            book.setLastname(lName);
            book.setEmail(em);
            book.setPhone(ph);
            book.setStartAt(start);
            book.setEndAt(end);
            book.setVehicule(veh);

            // Mise à jour de l'élément dans la liste observable
            observableListBooking.set(index, book.toString());
        }
    }
}
