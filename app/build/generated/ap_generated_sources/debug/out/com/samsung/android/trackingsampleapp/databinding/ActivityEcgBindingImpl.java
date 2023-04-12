package com.samsung.android.trackingsampleapp.databinding;
import com.samsung.android.trackingsampleapp.R;
import com.samsung.android.trackingsampleapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEcgBindingImpl extends ActivityEcgBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ecg_start_button, 1);
        sViewsWithIds.put(R.id.ecg_stop_button, 2);
        sViewsWithIds.put(R.id.progress_bar, 3);
        sViewsWithIds.put(R.id.liveData_header, 4);
        sViewsWithIds.put(R.id.ecg1_data, 5);
        sViewsWithIds.put(R.id.ecg1_data_value, 6);
        sViewsWithIds.put(R.id.lead_off_data, 7);
        sViewsWithIds.put(R.id.lead_off_data_value, 8);
        sViewsWithIds.put(R.id.sequence, 9);
        sViewsWithIds.put(R.id.sequence_value, 10);
        sViewsWithIds.put(R.id.ecg_green_data, 11);
        sViewsWithIds.put(R.id.ecg_green_data_value, 12);
        sViewsWithIds.put(R.id.threshold1_data, 13);
        sViewsWithIds.put(R.id.threshold_max_data_value, 14);
        sViewsWithIds.put(R.id.threshold2_data, 15);
        sViewsWithIds.put(R.id.threshold_min_data_value, 16);
    }
    // views
    @NonNull
    private final androidx.wear.widget.BoxInsetLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEcgBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityEcgBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ProgressBar) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[16]
            );
        this.mboundView0 = (androidx.wear.widget.BoxInsetLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}