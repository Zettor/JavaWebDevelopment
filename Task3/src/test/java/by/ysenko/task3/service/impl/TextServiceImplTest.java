package by.ysenko.task3.service.impl;


import by.ysenko.task3.bean.Storage;
import by.ysenko.task3.bean.Text;
import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.exception.ServiceException;
import by.ysenko.task3.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertThrows;

public class TextServiceImplTest {

    final static String WRONG_PATH = "fdgdfsdfg/df//dfgd@fg/dfg";
    final static String OUTPUT_FILE = "src//main//resources//output.txt";
    final static String STANDART_FILE = "src//main//resources//standart_file.txt";
    final static String FILE_FOR_SORT = "src//main//resources//file_for_sort.txt";

    @BeforeMethod
    public void resetTrain() {
        Storage storage = Storage.getStorage();

        ArrayList<Text> texts = storage.getList();
        if (!texts.isEmpty()) {
            for (int i = texts.size() - 1; i >= 0; i--) {
                storage.delete(i);
            }
        }
    }

    @DataProvider(name = "NegativeDataForReadTextAndGetText")
    public Object[] createNegativeDataForReadTextAndGetText() {

        return new Object[][]{
                {WRONG_PATH, OUTPUT_FILE},
                {STANDART_FILE, WRONG_PATH}
        };
    }

    @Test
    public void testPositiveReadText() throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        String expected = "   An enum type is a special data type that enables for" +
                " a variable to be a set of predefined constants. The variabl" +
                "e must be equal to one of the values that have been predefin" +
                "ed for it! Common examples include compass directions (value" +
                "s of NORTH, SOUTH, EAST, and WEST) and the days of the week."  +
                "   Because they are constants, the names of an enum type's fields are in uppercase letters?"  +
                "   In the Java programming language, you define an enum type by using the enum keyword. For example, you would specify a days-of-the-week enum type as...";
        textService.readText(STANDART_FILE, OUTPUT_FILE);
        Assert.assertEquals(Storage.getStorage().getText(0).getString(), expected);
    }

    @Test(dataProvider = "NegativeDataForReadTextAndGetText")
    public void testNegativeReadTextAndGetText(String dataPath, String outPath) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        assertThrows(ServiceException.class, () -> {
            serviceFactory.getTextService().readText(dataPath, outPath);
        });

    }

    @Test
    public void testSortBySentence() throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        String expected = "   Because they are constants, the names of an enum type's fields are in uppercase letters?"  +
                "   In the Java programming language, you define an enum type by using the enum keyword. For example, you would specify a days-of-the-week enum type as..." +
                "   An enum type is a special data type that enables for" +
                " a variable to be a set of predefined constants. The variabl" +
                "e must be equal to one of the values that have been predefin" +
                "ed for it! Common examples include compass directions (value" +
                "s of NORTH, SOUTH, EAST, and WEST) and the days of the week." ;
        textService.readText(STANDART_FILE, OUTPUT_FILE);
        Assert.assertEquals(textService.sortBySentence("0"), expected);
    }

    @Test
    public void testSortByWord() throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        String expected = " , In an by the you the Java enum type enum using define keyword language programming ."+
                " , a as For you enum type would example specify days-of-the-week .";
        textService.readText(FILE_FOR_SORT, OUTPUT_FILE);
        Assert.assertEquals(textService.sortByWord("0"), expected);
    }

    @Test
    public void testSortByToken() throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();
        String expected = " days-of-the-week example, define type type the the specify language, keyword. enum enum enum you you would using programming Java In For by as. an a";

        textService.readText(FILE_FOR_SORT, OUTPUT_FILE);
        Assert.assertEquals(textService.sortByToken("0","e"), expected);
    }
}