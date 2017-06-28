package com.shuvojitkar.recylerview__wiseass;

import com.shuvojitkar.recylerview__wiseass.Data.DataSourceInterface;
import com.shuvojitkar.recylerview__wiseass.Data.FakeDataSource;
import com.shuvojitkar.recylerview__wiseass.Data.ListItem;
import com.shuvojitkar.recylerview__wiseass.Logic.Controller;
import com.shuvojitkar.recylerview__wiseass.View.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {


    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    /**
     * Often times we'll want data to run our tests against. I like to define such Data as a series
     * of Static variables in the Test file itself for convenience.
     */
    private static final ListItem testItem = new ListItem(
            "6:30AM 06/01/2017",
            "Look at Open Source Projects",
            R.color.RED);

    private static final ListItem testItem2= new ListItem(
            "6:30AM 06/01/2017",
            " Projects",
            R.color.RED);

    /**
     * Since we're testing our Controller Class, this one is the Real implementation!
     * How this works is we make a Real instance of the Controller talk to Fake Instances of
     * what it would normally talk to (i.e. our Mocks above). Since the Controller does most of the
     * thinking (Logic), it follows that it would benefit the most from a good suite of Tests.
     */
    Controller controller;

    /**
     * the @Before annotation makes this Code run before the Tests themselves. You can use this
     * to initialize the different components of your Test, should you need to. You can also
     * initialize things in the Test methods themselves. Whatever works best for your Use Case.
     */

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }


    @Test
    public void onGetlistOfDataSuccesful() throws Exception {
        //Since we require a List<ListItem> to be returned by the dataSource, we can define it here:
        List<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //This is where we tell our "Mocks" what to do when our Controller talks to them. Since they
        //aren't real objects, we must tell them exactly what to do if we want responses from them.
        Mockito.when(dataSource.getListOfData())
                .thenReturn(listOfData);

        //This is the method we are testing
        controller.getListFromDataSource();

        //Check how the Tested Class responds to the data it receives
        //or test it's behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);

    }



    @Test
    public void onListItemClicked() {
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource());
    }
}