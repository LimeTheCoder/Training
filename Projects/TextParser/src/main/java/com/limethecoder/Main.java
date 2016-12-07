package com.limethecoder;


import com.limethecoder.controller.Controller;
import com.limethecoder.model.Text;
import com.limethecoder.model.source.Source;
import com.limethecoder.model.source.SourceType;
import com.limethecoder.service.TextService;
import com.limethecoder.service.TextServiceImpl;
import com.limethecoder.view.View;


public class Main {
    public static void main(String args[]) {
        View view = new View(System.out);
        Source source = Source.getInstance(SourceType.DUMMY,
                "Hello,,,,,,        Jinny! I like to see you. Good luck! Bye?");
        //Source in = Source.getInstance(SourceType.FILE, "test.txt");
        //Source out = Source.getInstance(SourceType.FILE, "out.txt");
        TextService textService = new TextServiceImpl(source, source);
        Controller controller = new Controller(textService, view);
        controller.process();
    }
}
