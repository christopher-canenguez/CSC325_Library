/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import java.util.ArrayList;

/**
 *
 * @author shameedjob
 */
public class APISearchResult {

    public String kind;
    public int totalItems;
    public ArrayList<APIBookResult> items;
    
    public void combine(APISearchResult other)
    {
        System.out.println("Items: "+items.size());
        if(other.items == null)
        {
            return;
        }
        for(int i = 0; i < other.items.size(); i++)
        {
            items.add(other.items.get(i));
        }
//        APIBookResult[] fullItems = new APIBookResult[items.length + other.items.length];
//        int i = 0;
//        for(int j = 0; j < items.length; j++){
//            fullItems[i++] = items[j];
//        }
//        for(int j = 0; j < other.items.length; j++)
//        {
//            fullItems[i++] = other.items[j];
//        }
//        items = fullItems;
    }
}
