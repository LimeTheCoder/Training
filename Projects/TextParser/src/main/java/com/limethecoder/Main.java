package com.limethecoder;


import com.limethecoder.controller.Controller;
import com.limethecoder.model.Model;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceType;
import com.limethecoder.view.View;


public class Main {
    public static void main(String args[]) {
        View view = new View(System.out);
        Model model = new Model();
        Source source = Source.getInstance(SourceType.DUMMY,
                "Hello, Jinny! I like to see you. Good luck! Bye?");
        Controller controller = new Controller(model, view, source, source);
        controller.process();
    }
}
