package com.sarahemati.restaurant.view.pages;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class MainPage {
	private List<String> images;

	public List<String> getImages() {
		if (images == null) {
			images = new ArrayList<String>();
			images.add("b.jpg");
			images.add("c.jpeg");
			images.add("l.jpeg");
			images.add("d.jpg");
			images.add("g.jpeg");
			images.add("e.jpg");
			images.add("h.jpeg");
			images.add("j.jpeg");
			images.add("k.jpg");
		}
		return images;
	}

	public void save() {
		addMessage("Data saved");
	}

	public void update() {
		addMessage("Data updated");
	}

	public void delete() {
		addMessage("Data deleted");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
