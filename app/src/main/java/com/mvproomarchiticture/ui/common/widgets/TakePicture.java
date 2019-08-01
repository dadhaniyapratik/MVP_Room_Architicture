package com.mvproomarchiticture.ui.common.widgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import com.mvproomarchiticture.BuildConfig;
import com.mvproomarchiticture.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static android.app.Activity.RESULT_OK;
import static com.mvproomarchiticture.util.Constants.CAMERA_CAPTURE;
import static com.mvproomarchiticture.util.Constants.CROP_CODE;
import static com.mvproomarchiticture.util.Constants.GALLERY;


public class TakePicture {
    private Uri outPutFileUri;
    private final Activity mContext;
    String SDCARD = Environment.getExternalStorageDirectory() + "/Lock Sub/";

    public TakePicture(Activity mContext) {
        this.mContext = mContext;

    }

    public void selectImage() {
        final CharSequence[] items = {mContext.getResources().getString(R.string.take_new_photo),
                mContext.getResources().getString(R.string.select_from_photo), mContext.getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getString(R.string.add_photo));
        builder.setItems(items, (dialog, item) -> {
            if (items[item].equals(mContext.getResources().getString(R.string.take_new_photo))) {

                try {
                    captureImageUsingCamera();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (items[item].equals(mContext.getResources().getString(R.string.select_from_photo))) {

                pickImageFromGallery();
            } else if (items[item].equals(mContext.getResources().getString(R.string.cancel))) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    // Capture Image From Camera
    public void captureImageUsingCamera() throws ActivityNotFoundException, IOException {
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            outPutFileUri = FileProvider.getUriForFile(mContext, BuildConfig.APPLICATION_ID + ".provider", createImageFile());
        } else {
            outPutFileUri = Uri.fromFile(createImageFile());
        }
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outPutFileUri);
        mContext.startActivityForResult(captureIntent, CAMERA_CAPTURE);
    }

    // Pick Image From Gallery
    public void pickImageFromGallery() throws ActivityNotFoundException {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        mContext.startActivityForResult(pickIntent, GALLERY);
    }

    public String onActivityResult(int requestCode, int resultCode, Intent data) throws IOException {
        if (resultCode == RESULT_OK) {

            if (requestCode == CAMERA_CAPTURE) {
                if (outPutFileUri != null) {
                    cropImage(outPutFileUri);
//                    performCrop(outPutFileUri);
                }
            } else if (requestCode == GALLERY && data != null) {
                Uri fileUri = data == null ? null : data.getData();
                if (fileUri != null) {
                    cropImage(fileUri);
//                    performCrop(fileUri);
                }
            } else if (requestCode == CROP_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), resultUri);
                return reduceImageSize(1000, 60, bitmap);
            }
        } else {
            return "";
        }
        return "";
    }

    private void cropImage(Uri mUri) {
        CropImage.activity(mUri).setGuidelines(CropImageView.Guidelines.ON).setAspectRatio(1, 1).start(mContext);
    }

    public String reduceImageSize(int maxSize, int quality, Bitmap image) throws IOException {
        int mWidth, mHeight;
        if (image.getWidth() > image.getHeight()) {
            mWidth = maxSize;
            mHeight = Math.round((maxSize * image.getHeight()) / image.getWidth());
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else if (image.getHeight() > image.getWidth()) {
            mHeight = maxSize;
            mWidth = Math.round((maxSize * image.getWidth()) / image.getHeight());
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else if (image.getHeight() == image.getWidth() && image.getHeight() > maxSize) {
            mHeight = maxSize;
            mWidth = maxSize;
            return saveImageAsPerQuality(resizeBitmap(image, mWidth, mHeight), quality);
        } else {
            return saveImageAsPerQuality(image, quality);
        }
    }

    // For File Store
    private File createImageFile() throws IOException {

        File myDir;
        String FolderName = mContext.getResources().getString(R.string.app_name);
        if (FolderName.equalsIgnoreCase("")) {
            myDir = new File(SDCARD + "/saved_images");
        } else {
            myDir = new File(SDCARD + "/." + FolderName);
        }

        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image_" + n + ".jpeg";
        File file = new File(myDir, fname);
        return file;
    }

    private Bitmap resizeBitmap(Bitmap mBitmap, int mWidth, int mHeight) {
        return Bitmap.createScaledBitmap(mBitmap, mWidth, mHeight, false);
    }

    private String saveImageAsPerQuality(Bitmap finalBitmap, int quality) throws IOException {
        File file = createImageFile();
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
