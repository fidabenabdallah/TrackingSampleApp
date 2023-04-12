package com.samsung.android.trackingsampleapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.samsung.android.trackingsampleapp.databinding.ActivityChoixBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivityEcgBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivityHeartRateBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivityPpgGreenBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivityPpgIrBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivityPpgRedBindingImpl;
import com.samsung.android.trackingsampleapp.databinding.ActivitySettingsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCHOIX = 1;

  private static final int LAYOUT_ACTIVITYECG = 2;

  private static final int LAYOUT_ACTIVITYHEARTRATE = 3;

  private static final int LAYOUT_ACTIVITYPPGGREEN = 4;

  private static final int LAYOUT_ACTIVITYPPGIR = 5;

  private static final int LAYOUT_ACTIVITYPPGRED = 6;

  private static final int LAYOUT_ACTIVITYSETTINGS = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_choix, LAYOUT_ACTIVITYCHOIX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_ecg, LAYOUT_ACTIVITYECG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_heart_rate, LAYOUT_ACTIVITYHEARTRATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_ppg_green, LAYOUT_ACTIVITYPPGGREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_ppg_ir, LAYOUT_ACTIVITYPPGIR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_ppg_red, LAYOUT_ACTIVITYPPGRED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.samsung.android.trackingsampleapp.R.layout.activity_settings, LAYOUT_ACTIVITYSETTINGS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCHOIX: {
          if ("layout/activity_choix_0".equals(tag)) {
            return new ActivityChoixBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_choix is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYECG: {
          if ("layout/activity_ecg_0".equals(tag)) {
            return new ActivityEcgBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ecg is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHEARTRATE: {
          if ("layout/activity_heart_rate_0".equals(tag)) {
            return new ActivityHeartRateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_heart_rate is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPPGGREEN: {
          if ("layout/activity_ppg_green_0".equals(tag)) {
            return new ActivityPpgGreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ppg_green is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPPGIR: {
          if ("layout/activity_ppg_ir_0".equals(tag)) {
            return new ActivityPpgIrBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ppg_ir is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPPGRED: {
          if ("layout/activity_ppg_red_0".equals(tag)) {
            return new ActivityPpgRedBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ppg_red is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSETTINGS: {
          if ("layout/activity_settings_0".equals(tag)) {
            return new ActivitySettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_settings is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_choix_0", com.samsung.android.trackingsampleapp.R.layout.activity_choix);
      sKeys.put("layout/activity_ecg_0", com.samsung.android.trackingsampleapp.R.layout.activity_ecg);
      sKeys.put("layout/activity_heart_rate_0", com.samsung.android.trackingsampleapp.R.layout.activity_heart_rate);
      sKeys.put("layout/activity_ppg_green_0", com.samsung.android.trackingsampleapp.R.layout.activity_ppg_green);
      sKeys.put("layout/activity_ppg_ir_0", com.samsung.android.trackingsampleapp.R.layout.activity_ppg_ir);
      sKeys.put("layout/activity_ppg_red_0", com.samsung.android.trackingsampleapp.R.layout.activity_ppg_red);
      sKeys.put("layout/activity_settings_0", com.samsung.android.trackingsampleapp.R.layout.activity_settings);
    }
  }
}
