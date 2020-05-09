package com.ork821;

import java.io.File;

public class UrlDownloaderFactory {
    public File downloadFile(String url) throws Exception {
        AbstractDownloader downloader;
        if (url.contains("yadi.sk")) {
            downloader = new YandexDiskDownloader();
        } else {
            downloader = new GoogleImageDownloader();
        }
        return downloader.downloadFile(url);
    }
}
