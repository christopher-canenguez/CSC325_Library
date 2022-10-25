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
public class GBSearchObject {
    public GBSearchParameter[] data;
    
    public GBSearchObject(ArrayList<GBSearchParameter> data)
    {
        this.data = data.toArray(new GBSearchParameter[0]);
    }
}
