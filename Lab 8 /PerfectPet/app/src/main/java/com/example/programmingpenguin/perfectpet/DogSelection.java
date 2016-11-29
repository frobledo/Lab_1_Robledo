package com.example.programmingpenguin.perfectpet;

/**
 * Created by ProgrammingPenguin on 11/28/16.
 */

public class DogSelection {

    private String selectedDog;
    private String dogURL;

    private void setDogInfo (Integer personType){
        switch (personType){
            case 0: //athletic
                selectedDog="Australian Shepherd";
                dogURL="https://en.wikipedia.org/wiki/Australian_Shepherd";
                break;
            case 1: //couch potato
                selectedDog="Bulldog";
                dogURL="https://en.wikipedia.org/wiki/Bulldog";
                break;
            case 2: //beach bum
                selectedDog="Corgi";
                dogURL="https://en.wikipedia.org/wiki/Welsh_Corgi";
                break;
            case 3: //hipster
                selectedDog="French Bulldog";
                dogURL="https://en.wikipedia.org/wiki/French_Bulldog";

        }
    }

    public void setDog(Integer personType){
        setDogInfo(personType);
    }

    public void setDogURL(Integer personType){
        setDogInfo(personType);
    }

    public String getSelectedDog(){
        return selectedDog;
    }

    public String getDogURL(){

        return dogURL;
    }
}



