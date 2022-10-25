/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

/**
 *
 * @author shameedjob
 */
public class APIBookResult {
    String kind;
    String id;
    String etag;
    String selfLink;
    
    VolumeInfo volumeInfo;
    
    public class VolumeInfo{
        String title;
        String subtitle;
        String[] authors;
        String publisher;
        String publishedDate;
        String description;

        IndustryIdentifier[] industrtdentifiers;
        ReadingMode readingModes;

        int pageCount;
        String printType;
        String[] categories;
        String maturityRating;
        boolean allowAnonLogging;
        
        String contentVersion;
        PanelizationSummary panelizationSummary;
        ImageLinks imageLinks;
        String language;
        String previewLink;
        String infoLink;
        String canonicalVolumeLink;
        SaleInfo saleInfo;
        AccessInfo accessInfo;
        SearchInfo searchInfo;
        
        public class IndustryIdentifier{
            String type;
            String identifier;
        }

        public class ReadingMode{
            boolean text;
            boolean image;
        }
        
        public class PanelizationSummary{
            boolean containsEpubBubbles;
            boolean containsImageBubbles;
        }
        
        public class ImageLinks{
            String smallThumbnail;
            String thumbnail;
        }
        

    }
    
    public class SaleInfo{
        String country;
        String saleability;
        boolean isEbook;
    }
        
    public class AccessInfo
    {
        String country;
        String viewability;
        boolean embeddable;
        boolean publicDomain;
        String textToSpeechPermission;
        Epub epub;
        Pdf pdf;
        String webReaderLink;
        String accessViewStatus;
        boolean quoteSharingAllowed;
        
        public class Epub{
            boolean isAvailable;
        }
        
        public class Pdf{
            boolean isAvailable;
        }
        
    }
    
    public class SearchInfo
    {
        String textSnippet;
    }
}

//{
//      "kind": "books#volume",
//      "id": "71M5EAAAQBAJ",
//      "etag": "grh0n7tZ9O8",
//      "selfLink": "https://www.googleapis.com/books/v1/volumes/71M5EAAAQBAJ",
//      "volumeInfo": {
//        "title": "Harry Potter: Crochet Wizardry | Crochet Patterns | Harry Potter Crafts",
//        "subtitle": "The Official Harry Potter Crochet Pattern Book",
//        "authors": [
//          "Lee Sartori"
//        ],
//        "publisher": "Simon and Schuster",
//        "publishedDate": "2021-08-17",
//        "description": "Some 24 official crochet patterns inspired by the Harry Potter films are included.",
//        "industryIdentifiers": [
//          {
//            "type": "ISBN_13",
//            "identifier": "9781647222604"
//          },
//          {
//            "type": "ISBN_10",
//            "identifier": "1647222605"
//          }
//        ],
//        "readingModes": {
//          "text": false,
//          "image": false
//        },
//        "pageCount": 89,
//        "printType": "BOOK",
//        "categories": [
//          "Crafts & Hobbies"
//        ],
//        "maturityRating": "NOT_MATURE",
//        "allowAnonLogging": false,
//        "contentVersion": "preview-1.0.0",
//        "panelizationSummary": {
//          "containsEpubBubbles": false,
//          "containsImageBubbles": false
//        },
//        "imageLinks": {
//          "smallThumbnail": "http://books.google.com/books/content?id=71M5EAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//          "thumbnail": "http://books.google.com/books/content?id=71M5EAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//        "previewLink": "http://books.google.com/books?id=71M5EAAAQBAJ&printsec=frontcover&dq=intitle:Harry+Potter&hl=&cd=10&source=gbs_api",
//        "infoLink": "http://books.google.com/books?id=71M5EAAAQBAJ&dq=intitle:Harry+Potter&hl=&source=gbs_api",
//        "canonicalVolumeLink": "https://books.google.com/books/about/Harry_Potter_Crochet_Wizardry_Crochet_Pa.html?hl=&id=71M5EAAAQBAJ"
//      },
//      "saleInfo": {
//        "country": "US",
//        "saleability": "NOT_FOR_SALE",
//        "isEbook": false
//      },
//      "accessInfo": {
//        "country": "US",
//        "viewability": "PARTIAL",
//        "embeddable": true,
//        "publicDomain": false,
//        "textToSpeechPermission": "ALLOWED_FOR_ACCESSIBILITY",
//        "epub": {
//          "isAvailable": false
//        },
//        "pdf": {
//          "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=71M5EAAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
//        "accessViewStatus": "SAMPLE",
//        "quoteSharingAllowed": false
//      },
//      "searchInfo": {
//        "textSnippet": "Some 24 official crochet patterns inspired by the Harry Potter films are included."
//      }
//    }