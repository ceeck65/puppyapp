package io.github.ceeck65.android.pyppysApp.Pets;

import java.io.Serializable;

/**
 * Created by mariofernandez on 5/8/16.
 */

public class Pets implements Serializable{

    private  String imgPetUrl;
    private  String namePet;
    private  Integer pointPet = new Integer(0);
    private  Boolean favorite;

    public Pets(String imgPetUrl, String namePet) {
        this.imgPetUrl = imgPetUrl;
        this.namePet = namePet;
    }

    public String getImgPetUrl() {
        return imgPetUrl;
    }

    public void setImgPetUrl(String imgPetUrl) {
        this.imgPetUrl = imgPetUrl;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Integer getPointPet() {
        return pointPet;
    }

    public void setPointPet(Integer pointPet) {
        this.pointPet = pointPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }
}
