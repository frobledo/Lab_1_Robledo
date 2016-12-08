package com.example.programmingpenguin.icecreamfinalrobledo;

import android.content.Intent;

/**
 * Created by ProgrammingPenguin on 12/8/16.
 */

public class iceCream
{
    private String selectIceCream;
    private String selectIceCreamURL;

    private void setIceCreamInfo (Integer spinnerSelection){
        switch (spinnerSelection){
            case 0:
                selectIceCream = "Fior di Latte";
                selectIceCreamURL = "http://fiordilattegelato.com/";
                break;
            case 1:
                selectIceCream = "Glacier";
                selectIceCreamURL = "http://www.glaciericecream.com/";
                break;
            case 2:
                selectIceCream= "Sweet Cow";
                selectIceCreamURL = "http://www.sweetcowicecream.com/";
        }
    }

    public void setSelectIceCream (Integer spinnerSelection){
        setIceCreamInfo(spinnerSelection);
    }

    public void setSelectIceCreamURL (Integer spinnerSelection){
        setIceCreamInfo(spinnerSelection);
    }

    public String getSelectIceCream(){
        return selectIceCream;
    }

    public String getSelectIceCreamURL(){
        return selectIceCreamURL;
    }
}
