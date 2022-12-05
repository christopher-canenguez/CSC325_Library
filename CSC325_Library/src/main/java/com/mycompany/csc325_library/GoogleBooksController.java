/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shameedjob
 */
public class GoogleBooksController extends HttpController {

    private String sendSearch(GBSearchObject searchObject) {
        String query = createSearchParameters(searchObject.data);
        try {
            var result = getHTML("https://www.googleapis.com/books/v1/volumes" + query);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    private String sendSearch(GBSearchObject searchObject, int startIndex)
    {
        String query = createSearchParameters(searchObject.data);
        try
        {
           var result = getHTML("https://www.googleapis.com/books/v1/volumes"
                   + query
                   + String.format("&startIndex=%d", startIndex)); 
           return result;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
    
    public static ArrayList<Book> getListFromDatabase(APISearchResult result)
    {
        ArrayList bookList =  new ArrayList();
        
        
        for(var b: result.items)
        {
            var resultIdentifiers = b.volumeInfo.industryIdentifiers;
            for(var id: resultIdentifiers)
            {
                Book databaseBook = Library.getInstance().getBook(
                        Integer.parseInt(
                                id.identifier));
                
                if(databaseBook != null)
                {
                    bookList.add(b);
                    break;   
                }
            }
        }
        
        
        return bookList;
    }
    
    public static ArrayList<Book> getBooksForSearch(ArrayList<Book> book, int page, int booksPerPage)
    {
        int indexToStart = (page-1) * booksPerPage;
        ArrayList returnBooks = new ArrayList();
        for(int i = indexToStart; i < book.size(); i++)
        {
            returnBooks.add(book.get(i));
        }
        return returnBooks;
    }
            
    
    public APISearchResult search(GBSearchObject searchObject)
    {
        var results = sendSearch(searchObject);
        if (results != null) {
            try {
                StringReader sr = new StringReader(results);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                APISearchResult result = gson.fromJson(sr, APISearchResult.class);
                if(result.totalItems > 10)
                {
                    int index = 10;
                    APISearchResult lastResult = result;
                    while(index < lastResult.totalItems)
                    {
                        results = sendSearch(searchObject, index);
                        sr = new StringReader(results);
                        lastResult = gson.fromJson(sr, APISearchResult.class);
                        result.combine(lastResult);
                        index += 10;
                    }
                    
                }
                return result;

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return null;
    }

    public static String createSearchParameters(GBSearchParameter[] params) {
        String results = "";
        for (int i = 0; i < params.length; i++) {
            var gbs = params[i];
            results += gbs.toString();
            if (i < params.length - 1) {
                results += "+";
            }
        }
        return "?q=" + results;
    }

}
