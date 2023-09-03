package com.example.airfrance.services;

import javafx.collections.ObservableList;

public interface ObservableStorageService {


    <T> ObservableList<T> get(String name, Class<T> c);
}
