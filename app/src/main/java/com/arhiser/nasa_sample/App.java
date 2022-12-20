package com.arhiser.nasa_sample;

import android.app.Application;

import com.arhiser.nasa_sample.api.NasaService;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {

    private NasaService nasaService;

    @Override
    public void onCreate() {
        super.onCreate();

        nasaService = new NasaService(); // инициализируем сетевой сервис, для выполнения запросов к серверу

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true) // нужен кеш в памяти
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this) // вызываем функцию инициализации
                .defaultDisplayImageOptions(defaultOptions)

                .memoryCache(new LruMemoryCache(20 * 1024 * 1024)) // задаем размер памяти
                .memoryCacheSize(20 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config); // инициализация загрузчика картинок
    }

    public NasaService getNasaService() {
        return nasaService;
    }
}
