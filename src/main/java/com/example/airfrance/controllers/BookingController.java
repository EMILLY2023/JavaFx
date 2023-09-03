package com.example.airfrance.controllers;

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



    @FXML
    public void Create() {

        int indexVeh = vehicleComboBox.getSelectionModel().getSelectedIndex();
        Vehicule ve1 = dataList1.get(indexVeh);

        Booking booking = new Booking(inputFname.getText(),
                inputLname.getText(),inputStart.getText(),
                inputEnd.getText(),inputEmail.getText(),
                inputPhone.getText(),ve1);

            if (booking.getFirstname().length() > 0 && booking.getLastname().length()>0
                && booking.getStartAt().length()>0 && booking.getEndAt().length()>0
                && booking.getEmail().length()>0 && booking.getPhone().length()>0) {
                dataList.add(booking);
                observableListBooking.add(booking.toString());
            }
            inputFname.clear();
            inputLname.clear();
            inputPhone.clear();
            inputEmail.clear();
            inputEnd.clear();
            inputStart.clear();
        }


    @FXML
    public void initialize() {

            Vehicule vehicle1 = new Vehicule("Toyota", "EJ-884-NF");
            Vehicule vehicle2 = new Vehicule("Honda Civic", "CD5678");
            Vehicule vehicle3 = new Vehicule("Ford Mustang", "EF9012");
            Vehicule vehicle4 = new Vehicule("Chevrolet Malibu", "GH3456");
            Vehicule vehicle5 = new Vehicule("Volkswagen Golf", "IJ7890");
            dataList1.add(vehicle1);
            dataList1.add(vehicle2);
            dataList1.add(vehicle3);
            dataList1.add(vehicle4);
            dataList1.add(vehicle5);
            for(Vehicule vv:dataList1){
                observableListVehicule.add(vv.toString());
            }
                  vehicleComboBox.setItems(observableListVehicule);

            Booking booking1 = new Booking("Annie", "VERSSAIRE", "10/04/2023",
                    "09/05/2023", "annie.versaire@gmail.com", "07.90.79.65.67", vehicle1);
            Booking booking2 = new Booking("vincent", "TIME", "01/03/2023", "09/03/2023", "vincent.time@gmail.com", "02.43.34.34.34", vehicle2);
            dataList.add(booking1);
            dataList.add(booking2);


            for (Booking book : dataList) {
                observableListBooking.add(book.toString());
                // Liez l'ObservableList à la ListView

            }
                 listView.setItems(observableListBooking);
        }

    public void delete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        dataList.remove(index);
        System.out.println(dataList);
        String supp =  listView.getSelectionModel().getSelectedItem();
        if (supp != null) {
            observableListBooking.remove(supp);
        }


    }

    public void select(){
       int indexValue = listView.getSelectionModel().getSelectedIndex();
       String indexValueString = String.valueOf(indexValue);
       index.setText(indexValueString);

       Booking book = dataList.get(indexValue);
       String fName = book.getFirstname();
       inputFname.setText(fName);

       Vehicule vehi = book.getVehicule();
       int ind = dataList1.indexOf(vehi);
        vehicleComboBox.getSelectionModel().select(ind);

       String lName = book.getLastname();
       inputLname.setText(lName);

       String stAt = book.getStartAt();
       inputStart.setText(stAt);

       String endAt = book.getEndAt();
       inputEnd.setText(endAt);

       String phone = book.getPhone();
       inputPhone.setText(phone);

       String email = book.getEmail();
       inputEmail.setText(email);

    }
    public void edit(){
       int indexValue = vehicleComboBox.getSelectionModel().getSelectedIndex();
       Vehicule veh = dataList1.get(indexValue);
       int index = listView.getSelectionModel().getSelectedIndex();
       String fName = inputFname.getText();
       String lName = inputLname.getText();
       String ph = inputPhone.getText();
       String em = inputEmail.getText();
       String start = inputStart.getText();
       String end = inputEnd.getText();


       if(indexValue>=0 && fName.length()>0 && lName.length()>0 && ph.length()>0
               && em.length()>0 && start.length()>0 && end.length()>0){
           Booking book = dataList.get(index);
           book.setFirstname(fName);
           book.setLastname(lName);
           book.setEmail(em);
           book.setPhone(ph);
           book.setStartAt(start);
           book.setEndAt(end);
           book.setVehicule(veh);
           System.out.println(dataList.get(index));
           observableListBooking.set(index,book.toString());



       }

    }

}
