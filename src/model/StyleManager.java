package model;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StyleManager {
    public static int ID_COUNT = 0;
    private List<ClothesItem> clothesItems;


    public StyleManager() {
        this.clothesItems = new ArrayList<>();
        clothesItems.add(new ClothesItem(++ID_COUNT,"pink",78.4f,"Jeans",Type.PANTS));
    }

    public void insertClothesItem(ClothesItem clothesItem) {
        clothesItems.add(clothesItem);
    }

    public List<ClothesItem> listAllClothesItem() {
        return clothesItems;
    }

    public void deleteClothesItem(int id)  {
        for (ClothesItem clothesItem : clothesItems) {
            if (clothesItem.getId() == id) {
                clothesItems.remove(clothesItem);
                break;
            }
        }
    }

    public void updateClothesItem(ClothesItem clothesItem) {
        for (int i = 0; i < clothesItems.size() ; i++) {
            if (clothesItems.get(i).getId() == clothesItem.getId()) {
                clothesItems.set(i, clothesItem);
            }
        }
    }

    public ClothesItem getclothesItems(int id) {
        for (ClothesItem clothesItem : clothesItems) {
            if (clothesItem.getId() == id) {
                return clothesItem;
            }
        }
        return null;
    }
}
