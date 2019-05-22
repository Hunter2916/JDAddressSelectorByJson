package chihane.jdaddressselector.model;

import java.util.List;

/**
 * 地区
 */
public class County  {
    private String id;
    private String areaName;
    private String Fid;
    private List<Street> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getFid() {
        return Fid;
    }

    public void setFid(String fid) {
        Fid = fid;
    }

    public List<Street> getChildren() {
        return children;
    }

    public void setChildren(List<Street> children) {
        this.children = children;
    }
}