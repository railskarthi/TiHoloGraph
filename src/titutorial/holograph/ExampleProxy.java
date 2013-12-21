/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package titutorial.holograph;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;
import org.json.JSONArray;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RatingBar;


// This proxy can be created by calling Holograph.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule=HolographModule.class)
public class ExampleProxy extends TiViewProxy
{
	// Standard Debugging variables
	private static final String LCAT = "ExampleProxy";
	private static final boolean DBG = TiConfig.LOGD;

	
	String chartType = "pie";
	PieGraph pieGraph;
	JSONArray jsonArray = new JSONArray();
	Object[] data = null;

	/*
	data =  [
    ['Heavy Industry', '#99CC00', 12],['Retail','#FFBB33', 9], ['Light Industry','#99CC00', 14], 
    ['Out of home','#FFBB33', 16],['Commuting','#99CC00', 7], ['Orientation','#FFBB33', 9]
  ]
	 */
	private class ExampleView extends TiUIView
	{
		public ExampleView(TiViewProxy proxy) {
			super(proxy);
			
			View chartWrapper = new View(getActivity());

			LayoutInflater inflater = LayoutInflater.from(getActivity());
			chartWrapper = inflater.inflate(Utility.resId_pieChartLayout, null);
			pieGraph = (PieGraph) chartWrapper.findViewById(Utility.resId_pieChart);
			
				System.out.println("@@## chk 1");
				System.out.println("@@## data = "+data.toString());
				System.out.println("@@## data len = "+data.length);
				if(data.length > 0){
					for(int k = 0; k< data.length; k++){
						//Object[] tt = (Object[]) data[k];
						//System.out.println("@@## tt = "+tt[0]);

						Object[] item = (Object[]) data[k];
						System.out.println("@@## item len  = "+item.length);
						PieSlice slice = new PieSlice();
						slice.setColor(Color.parseColor((String) item[1]));
						System.out.println("@@## before val  = "+item[2]);
						Float val = new Float((Integer) item[2]);
						System.out.println("@@## after val  = "+val);
						slice.setValue(val);
						pieGraph.addSlice(slice);
						
						for(int l=0; l<item.length; l++){
							System.out.println("@@## item element  = "+item[l]);
						}
					}
				}
				

				/*
				slice = new PieSlice();
				slice.setColor(Color.parseColor("#FFBB33"));
				slice.setValue(3);
				pieGraph.addSlice(slice);
				
				slice = new PieSlice();
				slice.setColor(Color.parseColor("#AA66CC"));
				slice.setValue(8);
				pieGraph.addSlice(slice);
				*/
				System.out.println("@@## chk 3");
			//} else if(chartType == LINE_CHART){
				
			//} else if(chartType == BAR_CHART){
				
			//} 
			System.out.println("@@## chk 4");
			setNativeView(chartWrapper);
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}


	// Constructor
	public ExampleProxy()
	{
		super();
	}

	@Override
	public TiUIView createView(Activity activity)
	{
		TiUIView view = new ExampleView(this);
		/*
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		*/
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);

		if (options.containsKey("data")) {
			data = (Object[]) options.get("data");
		} else {
			System.out.println("@@## no key data ");
		}
	}
	
	// Methods
	@Kroll.getProperty
	@Kroll.method
	public String getChartType() {
		return chartType;
	}

	@Kroll.setProperty
	@Kroll.method
	public void setChartType(String val) {
		chartType = val;
	}

}