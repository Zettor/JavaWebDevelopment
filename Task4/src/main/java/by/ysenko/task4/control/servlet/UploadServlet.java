package by.ysenko.task4.control.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;

import by.ysenko.task4.control.command.ParseCommand;
import by.ysenko.task4.control.command.ValidateCommand;
import by.ysenko.task4.service.FlowerService;
import by.ysenko.task4.service.factory.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static by.ysenko.task4.service.Constants.*;

@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileInputStream fis = new FileInputStream("D:\\Курсы\\JavaWebDevelopment\\Task4\\src\\main\\resources\\path");
        Properties property = new Properties();
        property.load(fis);

        String xsdPath = new String(property.getProperty("db.xsdPath").getBytes());
        String xmlPath = null;
        String parser = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FlowerService flowerService = serviceFactory.getTextService();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                        String fileName = new File(item.getName()).getName();
                        xmlPath = uploadPath + File.separator + fileName;
                        xsdPath = uploadPath + File.separator + "flowers.xsd";
                        File xmlFile = new File(xmlPath);
                        item.write(xmlFile);
                    } else {
                        parser = item.getString();
                    }
                }
                if (ValidateCommand.execute("file:///" + xmlPath + " " + xsdPath).equals("valid")) {
                    request.setAttribute("list", ParseCommand.execute(parser + " " + "file:///" + xmlPath + " " + xsdPath));
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/result.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
        }
        request.setAttribute("message", ValidateCommand.execute("file:///" + xmlPath + " " + xsdPath));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/wrong_result.jsp");
        requestDispatcher.forward(request, response);

    }
}