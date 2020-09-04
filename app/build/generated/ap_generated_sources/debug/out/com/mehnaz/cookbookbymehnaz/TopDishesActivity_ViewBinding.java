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

public class TopDishesActivity_ViewBinding implements Unbinder {
  private TopDishesActivity target;

  @UiThread
  public TopDishesActivity_ViewBinding(TopDishesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TopDishesActivity_ViewBinding(TopDishesActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'listView'", RecyclerView.class);
    target.my_recycler_view = Utils.findRequiredViewAsType(source, R.id.recyclerview2, "field 'my_recycler_view'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TopDishesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.my_recycler_view = null;
  }
}
