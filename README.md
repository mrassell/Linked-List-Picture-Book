# 📸 PictureBook – Circular Linked List Photo Album

**Data Structures Programming Assignment 2**  
NYU CSCI Fall 2024

---

## 📄 Overview

This project simulates the backend of a photo-sharing app called **PictureBook**, using a **circular doubly linked list** to model a photo album carousel.

Users can:
- Move to the next/previous photo
- Resume viewing where they left off
- Track which photos have been viewed
- Add or delete photos at any time
- Compare albums for equality (regardless of order)

The album remembers viewing state and wraps around circularly when users reach the end of the photo list.

---

## 🛠️ Implementation Details

You will implement:

- `Photo.java`:  
  A class representing a photo, with:
  - `String name`
  - `String photoDigest` (a unique ID)
  - A method to mark the photo as viewed
  - An `equals()` method comparing photos by `photoDigest`

- `Album.java`:  
  Implements the provided `IAlbum` interface using a **custom circular doubly linked list**. It tracks the current photo, supports bidirectional traversal, and manages dynamic photo updates.

### Constraints:
- Must not use built-in Java list classes for the linked list implementation
- Must implement a custom node structure
- All view tracking and logic must be persistent per photo

---

## 🧪 Testing

Sample input and output files were provided with the assignment.  
Each input contains Java code snippets to paste into your `main()` method, and expected outputs for validation.  
Test cases increase in complexity and are meant to be completed in order.

---

## 📦 Submission Guidelines

- Submit all `.java` files you wrote (excluding `IAlbum.java`)
- Do **not** modify the provided interface
- Submit as a zip file named after your NetID (e.g., `mr6761.zip`)
- Include a `main(String[] args)` method in `Album.java` for testing
- Indicate your Java version in the submission form
