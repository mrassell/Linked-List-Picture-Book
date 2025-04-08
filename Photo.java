public class Photo {
    private String name;
    private String photoDigest;
    private boolean isViewed;

    Photo(String name, String photoDigest) {
        this.name = name;
        this.photoDigest = photoDigest;
        isViewed = false;
    }

    public String getPhotoName() {
        return this.name;
    }

    public void viewPhoto() {
        System.out.println("Now viewing " + this.name + ".");
        isViewed = true;
    }

    public boolean isViewed() {
        return this.isViewed;
    }

    public boolean equals(Photo other) {
        return (this.photoDigest.equals(other.photoDigest));
    }
}