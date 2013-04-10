package com.uncopt.android.screeninfo;

import java.text.MessageFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    final DisplayMetrics metrics = getResources().getDisplayMetrics();
    final float density = metrics.density;
    final float widthPx = metrics.widthPixels;
    final float widthDp = (int)(widthPx / density);
    final float heightPx = metrics.heightPixels;
    final float heightDp = (int)(heightPx / density);
    final TextView densityView = findById(R.id.density);
    densityView.setText(MessageFormat.format(getString(R.string.density_format), density));
    final TextView widthView = findById(R.id.width);
    widthView.setText(MessageFormat.format(getString(R.string.width_format), widthPx, widthDp));
    final TextView heightView = findById(R.id.height);
    heightView.setText(MessageFormat.format(getString(R.string.height_format), heightPx, heightDp));
  }

  @SuppressWarnings("unchecked")
  private <T extends View> T findById(final int id) {
    return (T)findViewById(id);
  }

}
