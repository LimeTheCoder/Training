package com.limethecoder.pos;


import com.limethecoder.pos.controller.ConsoleController;
import com.limethecoder.pos.controller.Controller;
import com.limethecoder.pos.model.PointOfSale;
import com.limethecoder.pos.model.VendorMachine;
import com.limethecoder.pos.view.ConsoleView;
import com.limethecoder.pos.view.View;

public class App {
    public static void main(String args[]) {
        View view = new ConsoleView(System.out);
        PointOfSale pointOfSale = new VendorMachine();

        Controller controller = new ConsoleController(view, pointOfSale);
        controller.run();
    }
}
