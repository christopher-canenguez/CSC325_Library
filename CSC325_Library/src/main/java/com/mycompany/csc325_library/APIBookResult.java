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
    public String kind;
    public String id;
    public String etag;
    public String selfLink;
    
    public VolumeInfo volumeInfo;
    
    public class VolumeInfo{
        public String title;
        public String subtitle;
        public String[] authors;
        public String publisher;
        public String publishedDate;
        public String description;

        public IndustryIdentifier[] industrtdentifiers;
        public ReadingMode readingModes;

        public int pageCount;
        public String printType;
        public String[] categories;
        public String maturityRating;
        public boolean allowAnonLogging;
        
        public String contentVersion;
        public PanelizationSummary panelizationSummary;
        public ImageLinks imageLinks;
        public String language;
        public String previewLink;
        public String infoLink;
        public String canonicalVolumeLink;
        public SaleInfo saleInfo;
        public SearchInfo searchInfo;
        
        public class IndustryIdentifier{
            public String type;
            public String identifier;
        }

        public class ReadingMode{
            public boolean text;
            public boolean image;
        }
        
        public class PanelizationSummary{
            public boolean containsEpubBubbles;
            public boolean containsImageBubbles;
        }
        
        public class ImageLinks{
            public String smallThumbnail;
            public String thumbnail;
        }
        

    }
    
    public class SaleInfo{
        public String country;
        public String saleability;
        public boolean isEbook;
    }
        
    public class AccessInfo
    {
        public String country;
        public String viewability;
        public boolean embeddable;
        public boolean publicDomain;
        public String textToSpeechPermission;
        public Epub epub;
        public Pdf pdf;
        public String webReaderLink;
        public String accessViewStatus;
        public boolean quoteSharingAllowed;
        
        public class Epub{
            public boolean isAvailable;
        }
        
        public class Pdf{
            public boolean isAvailable;
        }
        
    }
    
    public class SearchInfo
    {
        public String textSnippet;
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