package chihane.jdaddressselector.model;

import java.util.List;

public class City  {
    private String id;
    private String areaName;
    private List<County> children;
    private String Fid;

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

    public List<County> getChildren() {
        return children;
    }

    public void setChildren(List<County> children) {
        this.children = children;
    }

    public String getFid() {
        return Fid;
    }

    public void setFid(String fid) {
        Fid = fid;
    }
}