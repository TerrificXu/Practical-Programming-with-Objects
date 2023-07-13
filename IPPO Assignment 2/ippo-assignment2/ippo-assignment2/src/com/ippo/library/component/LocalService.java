package com.ippo.library.component;

import com.ippo.library.constant.Constants;
import com.ippo.library.entity.*;

import java.util.*;

/**
 *
 * 2021/11/16 10:35
 */
public class LocalService {

    private Locate nowLocate;

    private Position nowPos;

    private Map<Integer, Item> roomViews = new HashMap<>();

    private Map<Integer, Item> basketViews = new HashMap<>();

    public Picture getPicture(String operate) {
        Picture nowPicture;
        if (Constants.FORWARD.equals(operate)) {
            Locate newLocat = nowLocate.getNewLocate(nowLocate, nowPos);
            if (Objects.isNull(newLocat)) {
                return null;
            }
            nowLocate = newLocat;
            nowPicture = getNowPicture();
        } else {
            nowPicture = nowLocate.getViews().getNewPicture(nowPos, operate);
            nowPos = nowPos.getNewPosition(nowPos, operate);
        }
        return nowPicture;
    }

    public List<Item> getNewBasketView(Integer index) {
        Item item = basketViews.get(index);
        //locate-items add
        nowLocate.getItems().add(item);
        //roomViews add
        roomViews.put(roomViews.size(), item);
        //basketViews delete
        basketViews.remove(index);
        Set<Map.Entry<Integer, Item>> entries = basketViews.entrySet();
        int i = 0;
        Map<Integer, Item> map = new HashMap<>(8);
        for (Map.Entry<Integer, Item> entry : entries) {
            map.put(i, entry.getValue());
            i++;
        }
        basketViews = map;
        //return
        return new ArrayList<>(basketViews.values());
    }

    public List<Item> getNowItems() {
        List<Item> nowItems = nowLocate.getItems();
        //refresh views when forward
        Map<Integer, Item> map = new HashMap<>(8);
        for (int i = 0; i < nowItems.size(); i++) {
            map.put(i, nowItems.get(i));
        }
        roomViews = map;
        return nowItems;
    }

    public List<Item> getNewRoomView(Integer index) {
        Item item = roomViews.get(index);
        //locate-items delete
        nowLocate.getItems().remove(item);
        //basketViews add
        basketViews.put(basketViews.size(), item);
        //roomViews delete
        roomViews.remove(index);
        Set<Map.Entry<Integer, Item>> entries = roomViews.entrySet();
        int i = 0;
        Map<Integer, Item> map = new HashMap<>(8);
        for (Map.Entry<Integer, Item> entry : entries) {
            map.put(i, entry.getValue());
            i++;
        }
        roomViews = map;
        //return
        return new ArrayList<>(roomViews.values());
    }

    public List<Item> getBasketItems() {
        return new ArrayList<>(basketViews.values());
    }

    public void setNowLocate(Locate nowLocate) {
        this.nowLocate = nowLocate;
    }

    public void setNowPos(Position nowPos) {
        this.nowPos = nowPos;
    }

    public Picture getNowPicture() {
        return nowLocate.getViews().getPicture(nowPos);
    }

}
