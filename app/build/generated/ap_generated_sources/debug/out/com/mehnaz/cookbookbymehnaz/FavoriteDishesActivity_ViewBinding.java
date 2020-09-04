// Generated code from Butter Knife. Do not modify!
package com.mehnaz.cookbookbymehnaz;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoriteDishesActivity_ViewBinding implements Unbinder {
  private FavoriteDishesActivity target;

  @UiThread
  public FavoriteDishesActivity_ViewBinding(FavoriteDishesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FavoriteDishesActivity_ViewBinding(FavoriteDishesActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoriteDishesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
