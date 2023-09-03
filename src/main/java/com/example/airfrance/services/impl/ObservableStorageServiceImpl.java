package com.example.airfrance.services.impl;

import com.example.airfrance.services.ObservableStorageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;

public class ObservableStorageServiceImpl implements ObservableStorageService {
    private final HashMap<String, ObservableList<String>> storage = new HashMap<>();




    @Override
    public <T> ObservableList<T> get(String name, Class<T> c) {
        if(!storage.containsKey(name)) {
            storage.put(name, FXCollections.observableArrayList());
        }
        return (ObservableList<T>) storage.get(name);
    }
}














        /* La classe ObservableStorageServiceImpl implémente l'interface ObservableStorageService.
        Elle utilise un Map appelé storage pour stocker les ObservableList en les associant à un nom spécifique.
        Dans la méthode getList(), on vérifie si une ObservableList avec le nom spécifié existe déjà dans le storage.
         Si ce n'est pas le cas, on crée une nouvelle ObservableList en utilisant FXCollections.observableArrayList()
         et on l'ajoute au storage. Ensuite, on la récupère du storage et on la retourne.
          Ainsi, chaque fois que vous appelez getList() avec le même nom, vous obtiendrez la même instance de ObservableList,
          ce qui permet de partager les données entre les différents écrans.
        Notez que vous devrez créer une classe d'implémentation de l'interface ObservableStorageService (ObservableStorageServiceImpl)
         dans votre projet et implémenter d'autres méthodes nécessaires selon vos besoins.
         */

