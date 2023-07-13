package com.ippo.controller;

import com.ippo.library.component.LocalService;
import com.ippo.library.entity.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 2021/11/16 2:23
 */
public class SimpleController {

    private LocalService service;

    public SimpleController() {
        this.service = new LocalService();
        init();
    }

    private void init() {
        Picture bedroomN = new Picture("BEDROOM - NORTH", new Image("/imgs/bedroom-n.jpg"), false, Position.NORTH);
        Picture bedroomE = new Picture("BEDROOM - EAST", new Image("/imgs/bedroom-e.jpg"), false, Position.EAST);
        Picture bedroomS = new Picture("BEDROOM - SOUTH", new Image("/imgs/bedroom-s.jpg"), true, Position.SOUTH);
        Picture bedroomW = new Picture("BEDROOM - WEST", new Image("/imgs/bedroom-w.jpg"), true, Position.WEST);

        Picture livroomN = new Picture("LIVINGROOM - NORTH", new Image("/imgs/livingroom-n.jpg"), true, Position.NORTH);
        Picture livroomE = new Picture("LIVINGROOM - EAST", new Image("/imgs/livingroom-e.jpg"), false, Position.EAST);
        Picture livroomS = new Picture("LIVINGROOM - SOUTH", new Image("/imgs/livingroom-s.jpg"), false, Position.SOUTH);
        Picture livroomW = new Picture("LIVINGROOM - WEST", new Image("/imgs/livingroom-w.jpg"), false, Position.WEST);

        Picture bathroomN = new Picture("BATHROOM - NORTH", new Image("/imgs/bathroom-n.jpg"), false, Position.NORTH);
        Picture bathroomE = new Picture("BATHROOM - EAST", new Image("/imgs/bathroom-e.jpg"), true, Position.EAST);
        Picture bathroomS = new Picture("BATHROOM - SOUTH", new Image("/imgs/bathroom-s.jpg"), false, Position.SOUTH);
        Picture bathroomW = new Picture("BATHROOM - WEST", new Image("/imgs/bathroom-w.jpg"), false, Position.WEST);

        Views bedroomViews = new Views(bedroomN, bedroomE, bedroomS, bedroomW);
        Views livroomViews = new Views(livroomN, livroomE, livroomS, livroomW);
        Views bathroomViews = new Views(bathroomN, bathroomE, bathroomS, bathroomW);

        Item catItem = new Item(new Image("/imgs/cat.png"));
        Item dogItem = new Item(new Image("/imgs/dog.png"));
        Item cupItem = new Item(new Image("/imgs/cup.png"));
        Item cashItem = new Item(new Image("/imgs/cash.png"));

        List<Item> bedroomItems = new ArrayList<>();
        bedroomItems.add(catItem);
        bedroomItems.add(dogItem);
        List<Item> livroomItems = new ArrayList<>();
        livroomItems.add(cashItem);
        List<Item> bathroomItems = new ArrayList<>();
        bathroomItems.add(cupItem);

        Locate bedroomLocate = new Locate(bedroomViews, bedroomItems);
        Locate livroomLocate = new Locate(livroomViews, livroomItems);
        Locate bathroomLocate = new Locate(bathroomViews, bathroomItems);

        List<Locate> locates = new ArrayList<>();
        locates.add(bedroomLocate);
        locates.add(livroomLocate);
        locates.add(bathroomLocate);
        Room room = new Room(locates);

        /**
         *  Because class javafx.scene.image.Image doesn't have default constructor，
         *  The deserialization function cannot be completed using either FastJson or Jackson.
         *  I can use String instead of Image in the entity class, but that would be a large amount of changes to the whole project,
         *  so no further changes will be made here.
         */

        //FastJson
//        String string = JSON.toJSONString(room);
//        Room room1 = JSON.parseObject(string, Room.class);

        //Jackson
//        String string = null;
//        Room room1 = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            string = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(room);
//            room1 = mapper.readValue(string, Room.class);
//        } catch (IOException e) {
//            System.out.println(e.toString());
//            e.printStackTrace();
//        }
//
//        System.out.println(string);
//        System.out.println(room1);


        bedroomLocate.setWestNode(bathroomLocate);
        bedroomLocate.setSouthNode(livroomLocate);
        livroomLocate.setNorthNode(bedroomLocate);
        bathroomLocate.setEastNode(bedroomLocate);

        service.setNowLocate(bedroomLocate);
        service.setNowPos(Position.NORTH);
    }

    public Picture getPicture(){
        return service.getNowPicture();
    }

    public Picture execute(String operate) {
        return service.getPicture(operate);
    }

    public List<Item> refreshRoomView(Integer index) {
        return service.getNewRoomView(index);
    }

    public List<Item> refreshBasketView(Integer index) {
        return service.getNewBasketView(index);
    }

    public List<Item> getRoomViews() {
        return service.getNowItems();
    }

    public List<Item> getBasketViews() {
        return service.getBasketItems();
    }

}
