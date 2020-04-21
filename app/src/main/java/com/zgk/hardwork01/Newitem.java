package com.zgk.hardwork01;

import android.media.Image;

public class Newitem {

        public String title;
        public int images;
        public String contents;
        public Newitem (String title,int image,String content){
           this.contents=content;
           this.title=title;
           this.images=image;
        }
        public Newitem()
        {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
