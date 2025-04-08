public class Album implements IAlbum {

    private String name;
    private int size;
    private boolean isOpen;

    class Node {
        Photo photo;
        Node next;
        Node prev;

        Node(Photo photo) {
            this.photo = photo;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node current;

    Album(String name) {
        this.head = null;
        this.current = null;
        this.name = name;
        this.size = 0;
        this.isOpen = false;
    }

    @Override
    public String getAlbumName() {
        return (this.name);
    }

    @Override
    public int getCount() {
        return this.size;
    }

    @Override
    public boolean hasPhoto(Photo photo) {
        if (head == null) {
            return false;
        } else {
            Node temp = head;
            while (temp != null) {  
                if (temp.photo.equals(photo)) {
                    return true; // photo is in the album
                }
                temp = temp.next; // iterate through album
            }
            return false;
        }
    }

    @Override
    public void addPhoto(Photo photo) {
        while (hasPhoto(photo)) {
            System.out.println("Attempted to add duplicate photo.");
            return;
        }
        Node newNode = new Node(photo);
        if (head == null) {
            head = newNode; // if the album is empty, it will set the head to this new photo (node)
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // set the next available space to this new photo
            newNode.prev = temp; // this new photo points back to the previous photo
        }
        size += 1; 
    }

    @Override
    public void deletePhoto(Photo photo) {
        if (!hasPhoto(photo)) {
            System.out.println("Attempted to delete a photo that is not in the album.");
        }
        if (head == null) {
            System.out.println("Album is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.photo.equals(photo)) {
                    if (temp.prev == null) { // if the photo we want to delete is the head, new head will be the next one after deletion
                        head = temp.next; 
                        current = head;
                    }
                    else {
                        temp.prev.next = temp.next; // previous node will now point to the next node
                        current = temp.next; // current will now be the next node
                    }
                    if (temp.next != null) { // if the photo we want to delete is not the last one, the next node will point back to the previous node
                        temp.next.prev = temp.prev;
                    }
                    size -= 1;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    @Override
    public boolean allPhotosViewed() { 
        if (head == null) {
            return true;
        }
        Node temp = head;
        while (temp != null) {
            if (!temp.photo.isViewed()) {
                return false;
            }
            temp = temp.next;
        }
        return true;

    }

    @Override
    public boolean equals(IAlbum other) {
        if (this.size != other.getCount()) {
            return false; // size of albums are different so already not equal
        }
        Node temp = head;
        while (temp != null) {
            if (!other.hasPhoto(temp.photo)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    @Override
    public void openAlbum() {
        System.out.println("Album " + this.name + " opened.");
        if (current == null && head != null) { // only set current to head if no photo has been viewed yet
            current = head;
            current.photo.viewPhoto();
        } else if (current != null) {
            current.photo.viewPhoto(); // continue from where we left off
        } else {
            System.out.println("Opened empty album");
        }

        isOpen = true;
    }

    @Override
    public void closeAlbum() {
        System.out.println("Album " + this.name + " closed.");
        isOpen = false;
    }

    @Override
    public void viewNextPhoto() {
        if (this.isOpen) {
            if (head == null) {
                System.out.println("Tried to view next photo, but album has no photos.");
                return;
            }
            if (current == null) { 
                current = head;
            } else if (current.next == null) { // if we are at the last photo, go back to the first photo
                current = head;
            } else {
                current = current.next; 
            }
            current.photo.viewPhoto(); 
        } else {
            System.out.println("Tried to view next photo, but album is closed.");
        }
    }

    @Override
    public void viewPreviousPhoto() {
        if (this.isOpen) {
            if (head == null) {
                System.out.println("Album is empty");
                return;
            }

            if (current == null) {
                current = head;
            } else if (current.prev == null) { // if we are at the first photo, go to the last photo
                while (current.next != null) {
                    current = current.next;
                }
            } else {
                current = current.prev;
            }
            current.photo.viewPhoto();
        } else {
            System.out.println("Tried to view previous photo, but album is closed.");
        }

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        //test sample inputs
        
    }

}
