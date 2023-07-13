// IPPO Assignment 1, Version 20.3, 21/12/2020
package ippo.assignment1.controller;

import ippo.assignment1.library.Picture;
import ippo.assignment1.library.controller.Controller;
import ippo.assignment1.library.service.Service;
import ippo.assignment1.library.service.ServiceFromProperties;
import ippo.assignment1.library.view.View;
import ippo.assignment1.library.view.ViewFromProperties;
import ippo.assignment1.library.utils.HashMap;



/**
 * A HashMap controller for the PictureViewer application.
 * 
 * @author Yingfan Xu;
 * @version 20.3, 25/10/2021
 */
public class HashMapController implements Controller {

	private View view;
	private Service service;
	// store the correspondence between the selection identifier and the name
	private HashMap<Integer,String> Munro = new HashMap<Integer,String>();



	/**
	 * Start the controller.
	 */
	public void start() {


		// create the view and the service objects
		view = new ViewFromProperties(this);
		service = new ServiceFromProperties();

		// create three selections in the interface
		addSubject("Stob Binnein");
		addSubject("Gairich");
		addSubject("Ben Lomond");
		addSubject("Beinn Ghlas");

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
			picture = service.getPicture(Munro.get(selectionID), 1);

		// show the picture in the interface
		view.showPicture(picture);
	}

	public void addSubject(String PictureName){
		// create one selection in the interface
		int selectionadded = view.addSelection(PictureName);

		// create correspondence between the selection identifier and the name
		// adds a corresponding entry to the HashMap
		Munro.put(selectionadded, PictureName);
	}

}
