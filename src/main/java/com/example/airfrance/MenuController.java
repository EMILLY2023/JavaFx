package com.example.airfrance;

import javafx.fxml.FXML;

public class MenuController {
    // Méthode appelée lors de la demande de fermeture de l'application
    @FXML
    private void clickClose() {
        AirfrenseApplication.stage.close();
    }

    // Méthodes de navigation vers différentes vues
    @FXML
    private void clickDashboard() {
        AirfrenseApplication.navigateTo("dashboard");
    }

    @FXML
    public void clickLogin() {
        AirfrenseApplication.navigateTo("login");
    }

    @FXML
    public void clickBookingCreate() {
        AirfrenseApplication.navigateTo("booking/create");
    }

    @FXML
    public void clickBookingList() {
        AirfrenseApplication.navigateTo("booking/list");
    }

    @FXML
    public void clickBookingEdit() {
        AirfrenseApplication.navigateTo("booking/edit");
    }

    @FXML
    public void clickBookingDelete() {
        AirfrenseApplication.navigateTo("booking/delete");
    }

    @FXML
    public void clickVehiculeList() {
        AirfrenseApplication.navigateTo("vehicule/list");
    }

    @FXML
    public void clickVehiculeCreate() {
        AirfrenseApplication.navigateTo("vehicule/create");
    }

    @FXML
    public void clickVehiculeEdit() {
        AirfrenseApplication.navigateTo("vehicule/edit");
    }

    @FXML
    public void clickVehiculeDelete() {
        AirfrenseApplication.navigateTo("vehicule/delete");
    }

    @FXML
    public void clickAbout() {
        AirfrenseApplication.navigateTo("about");
    }
}
