package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Widget;
import org.springframework.web.bind.annotation.*;
import com.example.wbdvsu119serverjava.controllers.WidgetService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    
    WidgetService WidgetService = new WidgetService();
    
    @PostMapping("/api/widgets")
    public List<Widget> createWidget(@RequestBody Widget widget) {
    	return WidgetService.createWidget(widget);
    }
    
    
    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
    	return WidgetService.findAllWidgets();
    }
    
   
    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
    	return WidgetService.findWidgetById(wid);
    }
    
    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") Integer wid,
            @RequestBody Widget widget) {
    	return WidgetService.updateWidget(wid,widget);
    }
    
    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") Integer wid) {
    	return WidgetService.deleteWidget(wid);
}
    
}
