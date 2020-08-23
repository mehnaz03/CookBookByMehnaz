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

public class ShortcutItemsActivity_ViewBinding implements Unbinder {
  private ShortcutItemsActivity target;

  @UiThread
  public ShortcutItemsActivity_ViewBinding(ShortcutItemsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShortcutItemsActivity_ViewBinding(ShortcutItemsActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'listView'", RecyclerView.class);
    target.my_recycler_view = Utils.findRequiredViewAsType(source, R.id.recyclerviewParent, "field 'my_recycler_view'", RecyclerView.class);
    target.my_recycler_view2 = Utils.findRequiredViewAsType(source, R.id.recyclerviewParent3, "field 'my_recycler_view2'", RecyclerView.class);
    target.my_recycler_view3 = Utils.findRequiredViewAsType(source, R.id.recyclerviewParent4, "field 'my_recycler_view3'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShortcutItemsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.my_recycler_view = null;
    target.my_recycler_view2 = null;
    target.my_recycler_view3 = null;
  }
}
