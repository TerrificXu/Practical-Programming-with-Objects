// IPPO Assignment 1, Version 21, 25/10/2021
package ippo.assignment1.controller;

import ippo.assignment1.library.Picture;
import ippo.assignment1.library.controller.Controller;
import ippo.assignment1.library.service.Service;
import ippo.assignment1.library.service.ServiceFromProperties;
import ippo.assignment1.library.utils.HashMap;
import ippo.assignment1.library.utils.Properties;
import ippo.assignment1.library.view.View;
import ippo.assignment1.library.view.ViewFromProperties;

import java.util.Arrays;
import java.util.List;
//import java.util.Arrays;

/**
 * A property controller for the PictureViewer application ( use Array and HashMap ).
 *
 * @author Yingfan Xu;
 * @version Version 21, 25/10/2021
 */
public class PropertyController implements Controller {

	private View view;
	private Service service;

	HashMap<Integer, String> selections = new HashMap<>();

	//takes the name of a Munro, (a) adds a selection to the
	//interface, and (b) adds a corresponding entry to the HashMap
	public void addSubject(String labelName){
		// create three selections in the interface
		int selectionId = view.addSelection(labelName);
		selections.put(selectionId,labelName);
	}

	/**
	 * Start the controller.
	 */
	public void start() {

		// create the view and the service objects
		view = new ViewFromProperties(this);
		service = new ServiceFromProperties();

		// read properties and remove any leading or tail spaces
		String labelsString = Properties.get("controller.subjects");
		List<String> labels = Arrays.asList(labelsString.split(","));
		labels.forEach((x)-> x = x.strip());

		// to check the values
//		System.out.println(labels);
//		System.out.println(labels.get(2).strip());

		// create three selections in the interface
		for (String label:labels){
			addSubject(label);
		}

		// start the interface
		view.start();
	}

	/**
	 * Handle the specified selection from the interface.
	 *
	 * @param selectionID the id of the selected item
	 */
	public void select(int selectionID) {

		// a picture corresponding to the selectionID
		// by default, this is an empty picture
		// (this is used if the selectionID does not match)
		Picture picture = new Picture();

		// create a picture corresponding to the selectionID
		picture = service.getPicture(selections.get(selectionID),1);

		// show the picture in the interface
		view.showPicture(picture);
	}
}
