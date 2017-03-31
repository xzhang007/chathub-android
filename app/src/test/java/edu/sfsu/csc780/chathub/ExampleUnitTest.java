package edu.sfsu.csc780.chathub;


import android.content.Context;
import android.os.Environment;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    private static final java.lang.String FAKE_EXTERNAL_FILES_DIR = "/";

    @Mock
    Context mMockContext;
    private File mImageFile;

    @Test
    public void createImageFileVerification() throws Exception {

        when(mMockContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES))
                .thenReturn(new File(getClass().getResource(FAKE_EXTERNAL_FILES_DIR).getPath()));

        mImageFile = ImageUtil.createImageFile(mMockContext);

        assertTrue(mImageFile != null);

        assertTrue(mImageFile.exists());

        assertTrue(mImageFile.getName().substring(0,8).equalsIgnoreCase(ImageUtil.IMAGE_FILE_NAME_PREFIX));
    }

    @After
    public void cleanup() {
        if (mImageFile != null && mImageFile.exists()) {
            mImageFile.delete();
        }
    }
}