package books;

/**
 * An interface for notebooks to implement basic operations
 */
public interface Inotablale {
    
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
     * @return a buffer containing the page content
     */
    public StringBuffer ReadPage(int page);

    /**
     * Saves the content of a single page
     * @param page - a Page class containing the name and content of the page
     * @return the number of bytes written
     */
    public int WritePage(Page page);

    /**
     * Saves an entire notebook
     * @param book - a book object containing the name and content of the book
     * @return The number of successfull pages saved
     */
    public int WriteNotebook(BookBase book);

    /**
     * Reads an entire notebook and creates a book base from the content
     * In other words, loads a previously saved notebook
     * @param path - The path where the notebook is saved
     * @return BookBase - a base book to create a custom notebook
     */
    public BookBase ReadNotebook(String path);

    /**
     * Creates a new notebook
     * @param path - path to save the notebook
     * @param name - the name of the notebook
     * @return 0 on success, -1 otherwise
     */
    public int CreateNewNotebook(String path, String name);

    /**
     * Removes a notebook from the file system
     * @param Path - The path where the notebook is saved
     * @return 0 on success, -1 otherwise
     */
    public int DeleteNotebook(String Path);
}
