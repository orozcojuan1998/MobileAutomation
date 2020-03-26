package entities;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Ad {

    private String title;
    private String description;
    private String category;
    private String location;
    private String phone;

    public Ad() {
    }

    public Ad(String title, String description, String location, String phone) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }
}
