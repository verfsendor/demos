package com.test.demos.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

import java.util.BitSet;

public class ImageLoader {
    private LruCache<String,Bitmap> mMemoryCache;
    private DiskLruCache diskLruCache;
}
