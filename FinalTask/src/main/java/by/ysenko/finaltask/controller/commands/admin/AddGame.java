package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

@MultipartConfig
public class AddGame extends AdminCommand {

    public static final String UPLOAD_DIRECTORY = "upload";
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;


    private final static String NAME_ATTRIBUTE = "name";
    private final static String GENRE_ATTRIBUTE = "genre";
    private final static String EXCLUSIVITY_ATTRIBUTE = "exclusivity";
    private final static String DATE_ATTRIBUTE = "date";
    private final static String TO_HTML = "/games.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {


        Game game = new Game();
        uploadFile(request, game);

        GameService service = ServiceFactory.createGameService();
        service.add(game);
        return TO_HTML;
    }

    private void uploadFile(HttpServletRequest request, Game game) {
        String filePath = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        String uploadPath = request.getServletContext().getRealPath("") + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        writeFile(item, game, uploadPath);
                    } else {
                        setGameField(item, game);
                    }
                }

            }
        } catch (FileUploadException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile(FileItem item, Game game, String uploadPath) throws Exception {
        String fileName = new File(item.getName()).getName();
        String filePath = uploadPath + File.separator + fileName;
        File imgFile = new File(filePath);
        item.write(imgFile);
        System.out.println(filePath);
        game.setImgPath(UPLOAD_DIRECTORY + File.separator + fileName);
    }

    private void setGameField(FileItem item, Game game) {
        String parameter = item.getString();
        switch (item.getFieldName()) {
            case NAME_ATTRIBUTE:

                game.setName(parameter);
                break;
            case GENRE_ATTRIBUTE:

                Genre genre = new Genre();
                genre.setId(Integer.parseInt(parameter));
                game.setGenre(genre);
                break;
            case EXCLUSIVITY_ATTRIBUTE:

                game.setExclusivity(Integer.parseInt(parameter));
                break;
            case DATE_ATTRIBUTE:

                game.setReleaseDate((Timestamp.valueOf(parameter + " 00:00:00.0")));
                break;
            default:

                game.setDescription(parameter);
                break;
        }
    }
}
