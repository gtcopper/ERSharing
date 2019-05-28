package cn.ersharing.pojo;

import java.io.Serializable;

public class ResourcesCategory implements Serializable {
    private Integer categoryId;

    private Integer categoryParentId;

    private String categoryName;

    private String resourcesDescription;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getResourcesDescription() {
        return resourcesDescription;
    }

    public void setResourcesDescription(String resourcesDescription) {
        this.resourcesDescription = resourcesDescription == null ? null : resourcesDescription.trim();
    }
}