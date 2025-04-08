public interface IAlbum {
  /**
   * Returns the name of the photo album. The name can be any String.
   */
  public String getAlbumName();

  /**
   * Returns the number of photos in the album.
   */
  public int getCount();


  /**
   * Returns true if the album has the photo passed in. Use the
   * Photo.equals(Photo other) method to determine equality between photos.
   */
  public boolean hasPhoto(Photo photo);

  /**
   * Add a photo to the album. Note that duplicate photos are not allowed.
   * You can use the Photo.equals(Photo other) method to determine if the
   * new photo duplicates any of the photos currently in the list. If a user
   * attempts to add a duplicate photo, do not add the photo, and print an
   * error message "Attempted to add duplicate photo."
   * 
   * The new photo should be added such that it is the "previous" photo for
   * the first photo added to the list. (If the first photo has been deleted,
   * then the new photo should be the previous photo for whatever is the
   * oldest photo remaining in the list.)
   */
  public void addPhoto(Photo photo);

  /**
   * Delete a photo from the album. If the photo is not in the album, print
   * an error message "Attempted to delete a photo that is not in the album."
   */
  public void deletePhoto(Photo photo);

  /**
   * Return true if all photos in the album have been viewed, otherwise return
   * false.
   */
  public boolean allPhotosViewed();

  /**
   * Return true if two albums have the same photos, as determined by the Photo
   * class's equals(Photo other) method. Note that the photos do not need to
   * be in the same order. Both albums should have the same number of photos
   * in order to be considered equal. The names of the two albums do not need
   * to be the same for this definition of equality.
   */
  public boolean equals(IAlbum other);

  /**
   * Print the message "Album [album name] opened." If the album has any photos,
   * whichever photo is the current photo should be marked as viewed (i.e. 
   * the Photo object's viewPhoto() method should be called). The viewNextPhoto()
   * and viewPreviousPhoto() methods may only be called when an album is open.
   */
  public void openAlbum();

  /**
   * Print the message "Album [album name] closed."
   */
  public void closeAlbum();

  /**
   * Move to the next photo. This should set the next photo to be the current
   * photo and call its viewPhoto() method. If the album is closed, print the
   * error message "Tried to view next photo, but album is closed." If the album
   * has no photos, print the error message "Tried to view next photo, but album
   * has no photos."
   * 
   */
  public void viewNextPhoto();

    /**
   * Move to the previous photo. This should set the previous photo to be the
   * current photo and call its viewPhoto() method. If the album is closed,
   * print the error message "Tried to view previous photo, but album is closed."
   * If the album has no photos, print the error message "Tried to view previous
   * photo, but album has no photos." 
   */
  public void viewPreviousPhoto();
}
