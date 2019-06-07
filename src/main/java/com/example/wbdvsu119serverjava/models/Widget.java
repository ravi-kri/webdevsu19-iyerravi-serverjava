package com.example.wbdvsu119serverjava.models;

public class Widget {
    private Integer id;
    private String name;
    private String type;
    private Integer index;
    private String text;
    private String src;
    private Integer size;
    private String href;
    private String items;
    private Boolean isOrdered;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    /**
//	 * @return the order
//	 */
//	public Integer getOrder() {
//		return order;
//	}
//
//	/**
//	 * @param order the order to set
//	 */
//	public void setOrder(Integer order) {
//		this.order = order;
//	}
//
//	/**
//	 * @return the text
//	 */
//	public String getText() {
//		return text;
//	}
//
//	/**
//	 * @param text the text to set
//	 */
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	/**
//	 * @return the url
//	 */
//	public String getUrl() {
//		return url;
//	}
//
//	/**
//	 * @param url the url to set
//	 */
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	/**
//	 * @return the size
//	 */
//	public Integer getSize() {
//		return size;
//	}
//
//	/**
//	 * @param size the size to set
//	 */
//	public void setSize(Integer size) {
//		this.size = size;
//	}
//
//	/**
//	 * @return the width
//	 */
//	public Integer getWidth() {
//		return width;
//	}
//
//	/**
//	 * @param width the width to set
//	 */
//	public void setWidth(Integer width) {
//		this.width = width;
//	}
//
//	/**
//	 * @return the height
//	 */
//	public Integer getHeight() {
//		return height;
//	}
//
//	/**
//	 * @param height the height to set
//	 */
//	public void setHeight(Integer height) {
//		this.height = height;
//	}
//
//	/**
//	 * @return the cssClass
//	 */
//	public String getCssClass() {
//		return cssClass;
//	}
//
//	/**
//	 * @param cssClass the cssClass to set
//	 */
//	public void setCssClass(String cssClass) {
//		this.cssClass = cssClass;
//	}
//
//	/**
//	 * @return the style
//	 */
//	public String getStyle() {
//		return style;
//	}
//
//	/**
//	 * @param style the style to set
//	 */
//	public void setStyle(String style) {
//		this.style = style;
//	}
//
//	/**
//	 * @return the value
//	 */
//	public String getValue() {
//		return value;
//	}
//
//	/**
//	 * @param value the value to set
//	 */
//	public void setValue(String value) {
//		this.value = value;
//	}

	public Widget() {
    }

    public Widget(Integer id, String name, String type,Integer index) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.index = index;
    }

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Boolean getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(Boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
