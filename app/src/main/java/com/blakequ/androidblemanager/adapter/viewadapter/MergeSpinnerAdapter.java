package com.blakequ.androidblemanager.adapter.viewadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

import java.util.List;

/**
 * Adapter that merges multiple child adapters into a single
 * contiguous whole to be consumed by a Spinner.
 * <p>
 * Adapters used as pieces within MergeSpinnerAdapter must
 * have view type IDs monotonically increasing from 0.
 * Ideally, adapters also have distinct ranges for their row
 * ids, as returned by getItemId().
 * <p>
 * All Adapters used as pieces within MergeSpinnerAdapter
 * must be properly-configured implementations of
 * SpinnerAdapter (e.g., ArrayAdapter, CursorAdapter).
 * from:https://github.com/commonsguy/cwac-merge
 */
public class MergeSpinnerAdapter extends MergeAdapter {
    /**
     * Stock constructor, simply chaining to the superclass.
     */
    public MergeSpinnerAdapter() {
        super();
    }

    /*
     * Returns the drop-down View for a given position, by
     * iterating over the pieces. Assumes that all pieces are
     * implementations of SpinnerAdapter.
     *
     * @see android.widget.BaseAdapter#getDropDownView(int,
     * android.view.View, android.view.ViewGroup)
     */
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        for (ListAdapter piece : getPieces()) {
            int size = piece.getCount();

            if (position < size) {
                return (((SpinnerAdapter) piece).getDropDownView(position,
                        convertView,
                        parent));
            }

            position -= size;
        }

        return (null);
    }

    /**
     * Adds a new View to the roster of things to appear in
     * the aggregate list.
     *
     * @param view Single view to add
     */
    public void addView(View view) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    /**
     * Adds a new View to the roster of things to appear in
     * the aggregate list.
     *
     * @param view    Single view to add
     * @param enabled false if views are disabled, true if enabled
     */
    public void addView(View view, boolean enabled) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    /**
     * Adds a list of views to the roster of things to appear
     * in the aggregate list.
     *
     * @param views List of views to add
     */
    public void addViews(List<View> views) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    /**
     * Adds a list of views to the roster of things to appear
     * in the aggregate list.
     *
     * @param views   List of views to add
     * @param enabled false if views are disabled, true if enabled
     */
    public void addViews(List<View> views, boolean enabled) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }
}
