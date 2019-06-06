package com.example.wbdvsu119serverjava.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.wbdvsu119serverjava.models.Widget;

public class WidgetService {
	
	static List<Widget> widgets = new ArrayList<Widget>();
    static {
        widgets.add(new Widget(123, "Widget 1", "HEADING",1));
        widgets.add(new Widget(234, "Widget 2", "LIST",2));
        widgets.add(new Widget(345, "Widget 3", "PARAGRAPH",3));
        widgets.add(new Widget(456, "Widget 4", "IMAGE",4));
        widgets.add(new Widget(567, "Widget 5", "LINK",5));
    }
    
    public List<Widget> createWidget(Widget widget) {
        widgets.add(widget);
        return widgets;
    }
   
    public List<Widget> findAllWidgets() {
        return widgets;
    }
   
    public Widget findWidgetById(Integer wid) {
        for(Widget w: widgets) {
            if(w.getId().equals(wid))
                return w;
        }
        return null;
    }
  
    public List<Widget> updateWidget(Integer wid, Widget widget) {
    	int i = 0;
        for(Widget w: widgets) {
            if(w.getId().equals(wid)) {
            	widgets.set(i,widget);            
        }
           i = i + 1; 
      }
        return widgets;
    }  

  
	public List<Widget> deleteWidget(Integer wid) {
    	
//    	widgets =  widgets.filter(widget -> !widget.getId().equals(wid)).collect(Collectors.toList());
    
    	int i = 0;
    	System.out.print("int i tak "); 
    	for(Widget w: widgets) {
            if(w.getId().equals(wid))
               {widgets.remove(i); }
         i = i + 1;
        }
    	return null;
    }
    
    
    
    }
    
	

