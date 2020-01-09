package com.example.meyss.javaretrofitdagger

import java.io.IOException
import java.io.InputStream
import java.net.URL
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView

class AsyncTaskLoadImage(private val imageView: ImageView) : AsyncTask<String, String, Bitmap>() {
    override fun doInBackground(vararg params: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val url = URL(params[0])
            bitmap = BitmapFactory.decodeStream(url.content as InputStream)
        } catch (e: IOException) {
            Log.e(TAG, e.message)
        }

        return bitmap
    }

    override fun onPostExecute(bitmap: Bitmap) {
        imageView.setImageBitmap(bitmap)
    }

    companion object {
        private val TAG = "AsyncTaskLoadImage"
    }
}