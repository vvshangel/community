package com.example.community.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    //当前页数
    private int current = 1;
    //每页限制上限
    private int limit = 10;
    //数据总数
    private int rows;
    //查询路径，用于复用分页链接
    private String path;


    /**
     * 获取当前页的起始行
     *
     * @return
     */
    public int getOffset(){
        return (current-1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }else{
            return rows / limit +1;
        }
    }

    /**
     *获取当前页数前几页
     *
     * @return
     */
    public int getFrom(){
        int from = current -2;
        return from <1 ? 1 : from;
    }

    /**
     * 获取当前页数后几页
     *
     * @return
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}
