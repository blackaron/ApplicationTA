package com.example.myapplication.Common;

import com.example.myapplication.Model.User;



public class Common {
    public static User currentUser;

    public static String convertCodeToStatus(String status)
    {
        if (status.equals("0"))
            return "Placed";
        else if (status.equals("1"))
            return "On My Way";
        else
            return "Shipped";
    }

//    public static IGeoCoordinates getGeoCodeServices(){
//        return RetrofitClient.getClient(baseUrl)
//    }
}
