package com.ork821;

import com.ork821.exceptions.UrlException;

import java.io.File;

/**
 * Интерфейс объект "скачивателя" файлов
 */
public interface AbstractDownloader {
    /**
     * Функция для скачивания файла
     * @param url - путь по котором скачивать файл.
     */
    File downloadFile(String url) throws UrlException, Exception;
}
