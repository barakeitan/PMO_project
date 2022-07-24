package books;

/**
 * An interface for notebooks to implement basic operations
 */
public interface Inotable {
    
    /**
     * opens a notebook for editing
     * @param path - the path where the notebook is saved
     * @return the botebook File Descriptor
     */
    public int OpenNotebook(String path);

    /**
     * Closes the notebook
     * @param SaveContent - make this true if you want to save the content 
     *                      of the notebook when closing, false otherwise
     * @return 0 - success, errno otherwise
     */
    public int CloseNotebook(Boolean SaveContent);


    /**
     * Return the content of a given page
     * @param page
     * @return a String containing the page content
     */
    public String ReadPage(int page);

    /**
     * Saves the content of a single page
     * @param page - a Page class containing the name and content of the page
     * @return the number of bytes written
     */
    public int WritePage(Page page);

    /**
     * Saves an entire notebook
     * @return The number of successfull pages saved
     */
    public int SaveNotebook();

    /**
     * Reads an entire notebook and creates a book base from the content
     * In other words, loads a previously saved notebook
     * @param path - The path where the notebook is saved
     * @return BookBase - a base book to create a custom notebook
     */
    public BookBase ReadNotebook(String path);

    /**
     * Creates a new notebook
     * @param name - the name of the notebook to be created when the path is known
     * @return 0 on success, -1 otherwise
     */
    public int CreateNewNotebook(String name);

    /**
     * Removes a notebook from the file system
     * @return 0 on success, -1 otherwise
     */
    public int DeleteNotebook();
}
