package com.example.rahul.retrofituserexanple;

import java.util.List;

/**
 * Created by rahul on 14/4/16.
 */
public class Books {

    public int errorcode;
    public List<BookData> data;
    public String message;

    public int getErrorcode() {
        return errorcode;
    }

    public List<BookData> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public class BookData {

        private String ebook_title_eng;

        public String getEbook_title_eng() {
            return ebook_title_eng;
        }
    }

}
