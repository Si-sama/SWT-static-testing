/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sinan
 */
public class Category {
   private String CategoryID;
   private String CategoryName;
   private int StatusCategory;

    public Category() {
    }

    public Category(String CategoryID, String CategoryName, int StatusCategory) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.StatusCategory = StatusCategory;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public int getStatusCategory() {
        return StatusCategory;
    }

    public void setStatusCategory(int StatusCategory) {
        this.StatusCategory = StatusCategory;
    }
   
    
   
}
