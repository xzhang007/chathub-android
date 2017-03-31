package edu.sfsu.csc780.chathub;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cjkriese on 3/12/17.
 */

public class ExampleInstrumentedTest {

    private static final int LARGE_DRAWABLE = R.drawable.android_bigbox;
    private static final int SMALL_DRAWABLE = R.drawable.android_smallbox;

    private Context mContext;

    @Before
    public void setup() {
        mContext = InstrumentationRegistry.getTargetContext();
    }


    @Test
    public void scaleBitmap_verifyLarge() throws Exception {

        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), LARGE_DRAWABLE);
        Bitmap resizedBitmap = ImageUtil.scaleImage(bitmap);
        assertNotEquals(bitmap, resizedBitmap);
        assertTrue((resizedBitmap.getHeight() + resizedBitmap.getWidth()) <= ImageUtil.MAX_LINEAR_DIMENSION);
    }


    @Test
    public void scaleBitmap_verifySmall() throws Exception {

        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), SMALL_DRAWABLE);
        Bitmap resizedBitmap = ImageUtil.scaleImage(bitmap);
        assertEquals(bitmap, resizedBitmap);
        assertTrue((resizedBitmap.getHeight() + resizedBitmap.getWidth()) <= ImageUtil.MAX_LINEAR_DIMENSION);
    }
}
