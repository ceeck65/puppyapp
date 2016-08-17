package io.github.ceeck65.android.pyppysApp.Picasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import io.github.ceeck65.android.pyppysApp.R;

/**
 * Created by mariofernandez on 8/8/16.
 */

public class PicassoClient {

    public static void loadPicasso(Context context, String url, ImageView imageView)
    {
        if (url != null && url.length() > 0)
        {
            Picasso.with(context).load(url).placeholder(R.drawable.no_image).resize(500, 500).centerCrop().into(imageView);

        } else
        {
            Picasso.with(context).load(url).into(imageView);
        }

    }

}
