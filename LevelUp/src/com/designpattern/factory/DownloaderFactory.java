package com.designpattern.factory;

public class DownloaderFactory {
    public static Downloader getDownloader(String type){
        if(type.equals("API"))
            return new APIDownloader();
        else
            return new FTPDownloader();
    }

    public static void main(String[] args) {
        Downloader downloader=DownloaderFactory.getDownloader("API");
        downloader.createDownloader();
    }
}
