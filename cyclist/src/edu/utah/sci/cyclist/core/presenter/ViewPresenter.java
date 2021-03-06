/*******************************************************************************
 * Copyright (c) 2013 SCI Institute, University of Utah.
 * All rights reserved.
 *
 * License for the specific language governing rights and limitations under Permission
 * is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions: The above copyright notice 
 * and this permission notice shall be included in all copies  or substantial portions of the Software. 
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 *  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR 
 *  A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 *  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER 
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *     Yarden Livnat  
 *******************************************************************************/
package edu.utah.sci.cyclist.core.presenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.utah.sci.cyclist.core.controller.IMemento;
import edu.utah.sci.cyclist.core.event.notification.CyclistNotifications;
import edu.utah.sci.cyclist.core.event.notification.CyclistViewNotification;
import edu.utah.sci.cyclist.core.event.notification.EventBus;
import edu.utah.sci.cyclist.core.event.notification.SimpleNotification;
import edu.utah.sci.cyclist.core.model.Context;
import edu.utah.sci.cyclist.core.model.Resource;
import edu.utah.sci.cyclist.core.ui.View;

public class ViewPresenter extends PresenterBase {

	private View _view;
	
	
	public ViewPresenter(EventBus bus) {
		super(bus);
	}
	
	 public ViewPresenter clone(View view) {
            return null;
    }
		        
    public void setActive(boolean active) {
    }
		        
		 
	public void setView(View view) {
		_view = view;
		if (_view != null) {
			view.onCloseProperty().set(new EventHandler<ActionEvent>() {			
				@Override
				public void handle(ActionEvent event) {
					broadcast(new SimpleNotification(CyclistNotifications.REMOVE_VIEW, getId()));
				}
			});
		}
	}

	public View getView() {
		return _view;
	}

	public void onViewSelected(View view) {
		broadcast(new CyclistViewNotification(CyclistNotifications.VIEW_SELECTED, view));	
	}
	
	public void save(IMemento memento) {	
	}
	
	public void restore(IMemento memento, Context ctx) {	
	}
	
	public Boolean getDirtyFlag(){
		return false;
	}
	
	public void setDirtyFlag(Boolean flag){
	}
	
}
