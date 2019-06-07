package com.example.wbdvsu119serverjava.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.wbdvsu119serverjava.models.Widget;

public class WidgetService {
	
	static List<Widget> widgets = new ArrayList<Widget>();
    static {
        widgets.add(new Widget(1, "Widget 1", "HEADING",1));
        widgets.add(new Widget(2, "Widget 2", "LIST",2));
        widgets.add(new Widget(3, "Widget 3", "PARAGRAPH",3));
        widgets.add(new Widget(4, "Widget 4", "IMAGE",4));
        widgets.add(new Widget(5, "Widget 5", "LINK",5));
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
    	
    	widgets =  widgets.stream().filter(widget -> !widget.getId().equals(wid)).collect(Collectors.toList());
    	return widgets;
    }

	public List<Widget> saveWidgets(List<Widget> widgets2) {
		
		widgets.clear();

		for(Widget w: widgets2) {	
			widgets.add(w);
		}
		return widgets;
	}
    }
    
	

