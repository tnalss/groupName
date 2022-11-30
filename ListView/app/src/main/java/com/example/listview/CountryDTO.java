package com.example.listview;

public class CountryDTO {
  int Image;
  String Name_k, Name_e;

    public CountryDTO(int image, String name_k, String name_e) {
        Image = image;
        Name_k = name_k;
        Name_e = name_e;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName_k() {
        return Name_k;
    }

    public void setName_k(String name_k) {
        Name_k = name_k;
    }

    public String getName_e() {
        return Name_e;
    }

    public void setName_e(String name_e) {
        Name_e = name_e;
    }
}
