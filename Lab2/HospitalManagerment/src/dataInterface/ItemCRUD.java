
package dataInterface;


public interface ItemCRUD {
    // C, add new item
    void create();
    //R, read: listing all items
    void read();
    //U, Update, edit ìnormation
    void update();
    //D, delete item in list
    void delete();
    // show profile
    void showProfile();
}
