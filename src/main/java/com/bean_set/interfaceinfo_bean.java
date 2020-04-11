package com.bean_set;

/**
 * author:travissong
 * 对应数据库的表：interface_info
 */

public class interfaceinfo_bean {
    public int id;
    public String interface_name;
    public String methos;
    public String get_param;
    public String post_param;
    public String addtime;
    public String add_author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterface_name() {
        return interface_name;
    }

    public void setInterface_name(String interface_name) {
        this.interface_name = interface_name;
    }

    public String getMethos() {
        return methos;
    }

    public void setMethos(String methos) {
        this.methos = methos;
    }

    public String getGet_param() {
        return get_param;
    }

    public void setGet_param(String get_param) {
        this.get_param = get_param;
    }

    public String getPost_param() {
        return post_param;
    }

    public void setPost_param(String post_param) {
        this.post_param = post_param;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getAdd_author() {
        return add_author;
    }

    public void setAdd_author(String add_author) {
        this.add_author = add_author;
    }
}
