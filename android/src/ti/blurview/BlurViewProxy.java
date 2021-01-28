/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.blurview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.github.mmin18.widget.RealtimeBlurView;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiUIView;

@Kroll.proxy(creatableInModule = TiBlurViewModule.class)
public class BlurViewProxy extends TiViewProxy
{
	// Standard Debugging variables
	private static final String LCAT = "BlurViewProxy";
	private static final boolean DBG = TiConfig.LOGD;
	RealtimeBlurView blurLayout;
	private int blurRadius = -1;
	private float downscaleFactor = -1.0f;
	private int fps = -1;
	private int col = -1;

	private class BlurView extends TiUIView
	{
		public BlurView(TiViewProxy proxy)
		{
			super(proxy);
			String packageName = proxy.getActivity().getPackageName();
			Resources resources = proxy.getActivity().getResources();
			View viewWrapper;

			int resId_viewHolder;
			int resIdPublish;

			resId_viewHolder = resources.getIdentifier("layout_main", "layout", packageName);
			resIdPublish = resources.getIdentifier("blurLayout", "id", packageName);

			LayoutInflater inflater = LayoutInflater.from(proxy.getActivity());
			viewWrapper = inflater.inflate(resId_viewHolder, null);
			blurLayout = (RealtimeBlurView) viewWrapper.findViewById(resIdPublish);

			if (blurRadius != -1) {
				blurLayout.setBlurRadius(blurRadius);
			}
			if (col != -1) {
				blurLayout.setOverlayColor(col);
			}

			setNativeView(viewWrapper);
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}

	// Constructor
	public BlurViewProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		TiUIView view = new BlurView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);

		if (options.containsKey("blurFactor")) {
			blurRadius = TiConvert.toInt(options.get("blurRadius"), 2);
		}
		if (options.containsKey("backgroundColor")) {
			col = TiConvert.toColor(TiConvert.toString(options.get("backgroundColor"),"#88000000"));
		}
	}

	@Kroll.setProperty
	public void blurRadius(int factor)
	{
		blurRadius = factor;
		blurLayout.setBlurRadius(blurRadius);
	}

	@Kroll.setProperty
	public void backgroundColor(int factor)
	{
		col = factor;
		blurLayout.setOverlayColor(col);
	}

	@Kroll.getProperty
	public int blurRadius()
	{
		return blurRadius;
	}
}
