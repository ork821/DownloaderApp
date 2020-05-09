package com.ork821.downloading;

import com.ork821.exceptions.UrlErrorCodes;
import com.ork821.exceptions.UrlException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class YandexDiskDownloader implements AbstractDownloader {
    final String FILE_INFO_API = "https://cloud-api.yandex.net:443/v1/disk/public/resources?public_key=";

    @Override
    public File downloadFile(String url) throws Exception {
        if (!url.contains("yadi.sk")) {
            throw new UrlException(UrlErrorCodes.WRONG_URL, "This in not yandex disk");
        }
        String query_url = FILE_INFO_API + url;
        try {
            URL urlObject = new URL(query_url);
            URLConnection connection = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int ch;
            StringBuffer stringBuffer = new StringBuffer();
            while ((ch = in.read()) != -1) {
                stringBuffer.append((char) ch);
            }
            JSONObject json = new JSONObject(stringBuffer.toString());
            String fileName = json.get("name").toString();
            String fileLink = json.get("file").toString();
            return this.downloadAndCreateFile(fileName, fileLink);
        } catch (Exception e) {
            throw e;
        }
    }

    private File downloadAndCreateFile(String fileName, String downloadLink) throws Exception {
        try {
            File file = new File(fileName);
            URL url = new URL(downloadLink);
            BufferedInputStream input = new BufferedInputStream(url.openStream());
            FileOutputStream out = new FileOutputStream(file);
            out.write(input.readAllBytes());
            return file;
        } catch (Exception e) {
            throw e;
        }
    }
}
