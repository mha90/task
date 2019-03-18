package me.mhabulazm.task.common;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import me.mhabulazm.task.R;

/**
 * Created by mhabulazm on 3/19/19.
 * mhabulazm@gmail.com
 */
public class ProgressDialog extends Dialog {
    private Context context;
    private Dialog dialog;

    public ProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    public Dialog showDialog() {
        dialog = new ProgressDialog(context);
        ProgressBar progressBar = new ProgressBar(context);
        dialog.addContentView(progressBar, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        if (progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().
                    setColorFilter(context.getResources().getColor(R.color.colorAccent),
                            android.graphics.PorterDuff.Mode.SRC_IN);
        }
        dialog.show();
        return dialog;
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
