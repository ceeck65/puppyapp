package io.github.ceeck65.android.pyppysApp.Pets;

/**
 * Created by mariofernandez on 16/8/16.
 */

public class PetsProfile  {


    private  String imgPetUrlProfiles;
    private  String namePetProfiles;
    private  Integer ratingProfiles = new Integer(0);

    public PetsProfile(String imgPetUrlProfiles, String namePetProfiles, Integer ratingProfiles) {
        this.imgPetUrlProfiles = imgPetUrlProfiles;
        this.namePetProfiles = namePetProfiles;
        this.ratingProfiles = ratingProfiles;
    }

    public String getImgPetUrlProfiles() {
        return imgPetUrlProfiles;
    }

    public String getNamePetProfiles() {
        return namePetProfiles;
    }

    public Integer getRatingProfiles() {
        return ratingProfiles;
    }

    public void setImgPetUrlProfiles(String imgPetUrlProfiles) {
        this.imgPetUrlProfiles = imgPetUrlProfiles;
    }

    public void setNamePetProfiles(String namePetProfiles) {
        this.namePetProfiles = namePetProfiles;
    }
}
