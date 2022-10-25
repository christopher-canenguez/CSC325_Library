/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author shameedjob
 */
public class GoogleBooksController extends HttpController{
    
    public void search(GBSearchObject searchObject)
    {
        String query = createSearchParameters(searchObject.data);
        try
        {
           var result = getHTML("https://www.googleapis.com/books/v1/volumes"+query); 
           System.out.println(result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static String createSearchParameters(GBSearchParameter[] params)
    {
        String results = "";
        for(int i = 0; i < params.length; i++)
        {
            var gbs = params[i];
            results += gbs.toString();
            if(i < params.length-1)
            {
                results += "+";
            }
        }
        return "?q="+results;
    }

}
