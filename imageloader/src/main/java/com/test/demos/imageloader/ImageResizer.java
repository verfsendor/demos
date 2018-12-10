package com.test.demos.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileDescriptor;

public class ImageResizer {
    private static final String TAG = "ImageResizer";

    public ImageResizer(){
    }

    public Bitmap decodeSampleBitmapFromResource(Resources resources,int resId,
                                                 int reqWidth, int reqHeight){
        //first decode with inJustDecodeBounds = true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources,resId,options);
        options.inSampleSize = calculateInsampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources,resId,options);
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd,
                                                        int reqWidth, int reqHeight){
        //first decode with inJustDecodeBounds = true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd,null,options);
        options.inSampleSize = calculateInsampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fd,null,options);
    }

    public int calculateInsampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        if(reqWidth == 0 || reqHeight == 0){
            return 1;
        }
        //raw height android width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        Log.d("verf",TAG + " origin width = " + width + " h= " + height);
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height/2;
            final int halfWidth = width/2;
            //calculate the largest inSampleSize value that is a power of 2 and keeps both
            //height and width larger than the requested height and width
            while ((halfHeight/inSampleSize) >= reqHeight && (halfWidth/inSampleSize) >= reqWidth){
                inSampleSize *= 2;
            }
        }
        Log.v("verf",TAG + " sampleSize " + inSampleSize);
        return inSampleSize;

    }
}
